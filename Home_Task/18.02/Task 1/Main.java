package com.veronica;

public class Main {

    public static void main(String[] args) {
        ObservableSB observableStringBuilder = new ObservableSB("Hello, ");
        observableStringBuilder.setOnChangeListener(builder ->
                System.out.println("Новое состояние: " + builder.toString()));

        observableStringBuilder.append("World!");
    }
}
