package com.dikayaav.tests;

public class Human {

    String name;
    int health;

    public Human (String name, int health) {
        this.name = name;
        this.health = health;
    }
void lostHealth(Human human, Vampire vampire) {
    if (this.health > 0) this.health = this.health - vampire.bite;
    else
        System.out.println(name + "мертв");
}

}
