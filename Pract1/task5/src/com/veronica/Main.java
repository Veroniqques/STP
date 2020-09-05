/*
№5 Дано два числа a и b. Найдите гипотенузу треугольника с заданными катетами
 */
package com.veronica;

public class Main {
    public static void main(String[] args) {
	    double a=3;
	    double b=4;
	    double c = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
        System.out.println(c);
    }
}
