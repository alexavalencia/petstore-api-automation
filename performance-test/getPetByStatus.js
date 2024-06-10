import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  stages: [
    { duration: '5m', target: 200 }, // ramp-up
    { duration: '20m', target: 200 }, // stable
    { duration: '5m', target: 0 }, // ramp-down
  ],
     thresholds: {
        http_req_failed: ['rate<0.01'],
    	http_req_duration: ['p(99)<100'] // 99% of requests must complete within 100ms
      }
};

const reqHeader = {
    headers: { 'Content-Type': 'application/json'}
}
export default function () {
  let res = http.get('https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available',reqHeader);
  check(res, { 'status was 200': (r) => r.status == 200 });
  sleep(1);
}