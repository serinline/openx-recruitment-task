package com.openx.openxtask.models;

public class Company {
    String name;
    String catchPhrase;
    String bs;

    public String getBs() {
        return bs;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getName() {
        return name;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public void setName(String name) {
        this.name = name;
    }
}
