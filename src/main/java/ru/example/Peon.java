package ru.example;

import ru.example.logging.Logging;

class Peon {

    @Logging
    public void work(final String name, final int hours) {
        System.out.println("Something need doing warchief " + name + "?");
        System.out.println("Working for " + hours + " hours");
    }

    @Logging
    public void work(final String name) {
        System.out.println("Something need doing warchief " + name + "?");
    }
}
