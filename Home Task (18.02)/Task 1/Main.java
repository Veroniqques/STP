package com.veronica;

public class Main {

    public static void main(String[] args) {
        ObservableSB ObservableSB = new ObservableSB("Hello ");
        ObservableSB.setOnChangeListener(builder ->
                System.out.println("New condition: " + builder.toString()));

        ObservableSB.append("World!");
    }
}
