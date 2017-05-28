package com.demoqa.dictionary;

public enum State {

    ALABAMA("Alabama"),
    ALASKA("Alaska"),
    ARIZONA("Arizona"),
    CALIFORNIA("California"),
    COLORADO("Colordo");

    private String state;

    private State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
