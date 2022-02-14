package com.dikayaav.tests;

public class Test {

    public static void main (String[]args){
        Vampire vampire = new Vampire();
        vampire.name = "Алукард";
        vampire.health = 1000;
        vampire.isHunger = true;
        vampire.power = 13;

        Vampire vampire1 = new Vampire();
        vampire1.name = "Дракула";
        vampire1.health = 2000;
        vampire1.isHunger = true;
        vampire1.power = 22;

        Human human = new Human();
        human.name = "Вася";
        human.health = 100;
        human.stamina = 4;
        human.happiness = 3;

        Human human1 = new Human();
        human1.name = "Петя";
        human1.health = 56;
        human1.stamina = 56;
        human1.happiness = 15;

        vampire.eat();
        vampire.talk();
        vampire1.talk();
        vampire.sunrise();
        vampire1.sunrise();
        human.goToWork();
        human1.goToWork();
        //human.looseHealth(human, vampire);
    }
}
