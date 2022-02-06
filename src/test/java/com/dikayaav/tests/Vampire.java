package com.dikayaav.tests;

public class Vampire {

    String name;
    boolean isHunger;
    int bite;

    public Vampire (String name, boolean isHunger, int bite) {
        this.name = name;
        this.isHunger = isHunger;
        this.bite = bite;
    }

    void eat(Human human, Vampire vampire) {
        human.lostHealth(human, vampire);
        System.out.println(human.name + " потерял " + 5 + " здоровья");
    }

    void vampireAwake(Vampire vampire, Human human) {
        System.out.println(name + " пробудился");
        if (this.isHunger == true)
        {
            System.out.println(name + " хочет скушОт " + human.name);
            vampire.eat(human, vampire);

        }
        else
            System.out.println(name + " пошел гулять");

    }





}
