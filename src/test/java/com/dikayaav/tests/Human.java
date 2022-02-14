package com.dikayaav.tests;

public class Human{
    int health;
    double stamina;
    String name;
    float happiness;
    double exhaustion = happiness * 0.3;

void goToWork() {
    System.out.println(name + " идет ишачить на работу");
    stamina = stamina - 8 * exhaustion;
    if (stamina <= 5) {
        System.out.println(name + " ползет уставший домой");
    } else {
        System.out.println(name + " идет домой");
    }
}

void looseHealth (Human human, Vampire vampire) {
    human.health -= 10;

}

}
