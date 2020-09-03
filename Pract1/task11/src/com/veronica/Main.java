package com.veronica;

public class Main {
    public static double geomean (int A, int B) {
        return Math.sqrt(A*B);
    }
    public static void main(String[] args) {
        System.out.println(geomean(5,5));
        System.out.println(geomean(32,128));

    }
}
// перемножить все числа и извлечь корень