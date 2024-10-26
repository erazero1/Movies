package com.erazero1.movies.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Rating implements Serializable {
    @SerializedName("kp")
    private double kp;

    public double getKp() {
        return kp;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "kp='" + kp + '\'' +
                '}';
    }

    public Rating(double kp) {
        this.kp = kp;
    }
}
