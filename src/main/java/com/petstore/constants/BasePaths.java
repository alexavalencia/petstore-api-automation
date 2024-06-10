package com.petstore.constants;

public enum BasePaths {
    GET_PET_BY_ID("/v3/pet");



    private String basePath;

    BasePaths(String basePath) {
        this.basePath= basePath;
    }

    public String getBasePath() {
        return basePath;
    }
}
