package com.veronica;

public class Main {
    public static double pointer (double x1, double y1, double x2, double y2) {
        double pointx = Math.pow(x2-x1,2);
        double pointy = Math.pow(y2-y1,2);
        return Math.sqrt(pointx+pointy);
    }
    public static void main(String[] args) {
        System.out.println(pointer(3.34,5.23,6.56,7.35));
    }
}
