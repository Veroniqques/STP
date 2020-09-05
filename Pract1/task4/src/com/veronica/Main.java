/*
№4 Даны две переменные. Поменяйте значения переменных друг с другом двумя способами
 */
package com.veronica;

public class Main {

    public static void main(String[] args) {
        //Способ 1
        int a = 10;
        int b = 4;
        int c = 0;
        c = a;
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);
        //Способ 2
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);
    }
}



