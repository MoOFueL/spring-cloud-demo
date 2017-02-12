package ru.atc.domain;

/**
 * Created by Дмитрий on 11.02.2017.
 */
public class OldUral {

    private String name;

    private String make;

    public OldUral() {
    }

    public OldUral(String name, String make) {
        this.name = name;
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "OldUral{" +
                "name='" + name + '\'' +
                ", make='" + make + '\'' +
                '}';
    }
}
