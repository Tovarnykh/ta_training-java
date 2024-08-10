package com.epam.training.student_viktor_tovarnykh.classes.main_task5;

import java.util.Arrays;

public class Rectangle {

    private double sideA;
    private double sideB;

    public Rectangle (double a, double b) {
        if (a<=0||b<=0) {
            throw new IllegalArgumentException();
        }
        this.sideA = a;
        this.sideB = b;
    }
    public Rectangle (double side) {
        if (side<=0) {
            throw new IllegalArgumentException();
        }
        this.sideA = side;
        this.sideB = side;
    }
    public Rectangle () {
        this.sideA = 4.0;
        this.sideB = 3.0;
    }

    public double getSideA(){
        return sideA;
    }
    public double getSideB(){
        return sideB;
    }
    public double area(){
        return sideA*sideB;
    }
    public double perimeter(){
        return (sideA+sideB)*2;
    }
    public boolean isSquare() {
        if(sideA==sideB) {
            return true;
        }
        else return false;
    }
    public void replaceSides(){
        Rectangle swap = new Rectangle();
        swap.sideA=this.sideB;
        swap.sideB=this.sideA;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Rectangle)) return false;
        Rectangle r = (Rectangle)obj;
        return r.sideA==sideA &&
                r.sideB==sideB;
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[] { sideA, sideB });
    }
    @Override
    public String toString() {
        return String.format("Rectangle " + "{" + sideA + ", " + sideB + "}");
    }

}
