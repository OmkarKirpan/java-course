package net.azib.java.students.t107678.homework;

import static java.lang.Math.pow;

public abstract class TrackEvent implements Event{

    double A,B,C,performance;


    @Override
    public int getPoints() {
        return (int)(A*pow(B-performance,C));
    }
}



