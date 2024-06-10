package com.petstore.constants;

public enum BasePaths {
    GET_PET_BY_ID("/v3/pet/"),
    GET_PET_BY_TAGS("v3/pet/findByTags"),
    GET_PET_BY_STATUS("/v3/pet/findByStatus");



    private String basePath;

    BasePaths(String basePath) {
        this.basePath= basePath;
    }

    public String getBasePath() {
        return basePath;
    }
}
