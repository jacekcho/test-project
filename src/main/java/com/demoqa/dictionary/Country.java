package com.demoqa.dictionary;


public enum Country {

    POLAND("Poland"),
    SLOVAKIA("Slovakia"),
    YEMEN("Yemen");

    private String setCountry;

    private Country(String setCountry) {
        this.setCountry = setCountry;
    }

    public String get() {
        return setCountry;
    }


}
