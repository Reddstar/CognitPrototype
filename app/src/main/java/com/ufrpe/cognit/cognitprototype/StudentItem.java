package com.ufrpe.cognit.cognitprototype;

/**
 * Created by Ricardo Silva on 07/01/2018.
 */

public class StudentItem {

    private String imageName;
    private String name;
    private String points;

    public StudentItem(String name, String userName, String points){
        this.imageName = name;
        this.name = userName;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public String getPoints() {
        return points;
    }

    public String getImageName() {
        return imageName;
    }

}
