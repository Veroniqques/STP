package com.veronica;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Hired> hireds = new ArrayList<>() {{
            add(new HourlyHired(1, 15, "Rita"));
            add(new FixedHired(2, 234, "Daria"));
            add(new FixedHired(3, 234, "Ivan"));
            add(new HourlyHired(4, 15, "Veronica"));
            add(new HourlyHired(5, 54, "Anastasia"));
        }};

        hireds.sort((o1, o2) -> {
            if (o1.calculateSalary() == o2.calculateSalary())
                return o1.getName().compareTo(o2.getName());

            return (int) (o2.calculateSalary() - o1.calculateSalary());
        });

        System.out.println("------ Выводим идентификатор работника, его имя и среднемесячную зарплату ------");
        for (Hired Hired : hireds) {
            System.out.println("[" + Hired.getId() + "]: " + Hired.getName() + " - " + String.format("%.2f", Hired.calculateSalary()) + "$");
        }
        System.out.println();

        System.out.println("------ Выводим первые 5 имен работников из списка выше ------");
        for (int index = 0; index < 5; index++) {
            Hired Hired = hireds.get(index);
            System.out.println(Hired.getName());
        }
        System.out.println();

        System.out.println("------ Выводи последние 3 идентификатора работников из списка выше------");
        for (int index = hireds.size() - 3; index < hireds.size(); index++) {
            Hired Hired = hireds.get(index);
            System.out.println(Hired.getId());
        }
    }
}
