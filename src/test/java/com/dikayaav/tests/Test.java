package com.dikayaav.tests;

public class Test {

    public static void main (String[]args){
        Vampire vampire = new Vampire();
        vampire.name = "Алукард";
        vampire.health = 1000;
        vampire.isHunger = true;
        vampire.power = 30;

        Vampire vampire1 = new Vampire();
        vampire1.name = "Дракула";
        vampire1.health = 2000;
        vampire1.isHunger = true;
        vampire1.power = 50;

        Vampire vampire2 = new Vampire();
        vampire2.name = "Низший вампир Пупа";
        vampire2.health = 320;
        vampire2.power = 14;

        Vampire vampire3 = new Vampire();
        vampire3.name = "Низший вампир Буба";
        vampire3.health = 150;
        vampire3.power = 7;

        Human human = new Human();
        human.name = "Вася";
        human.health = 100;
        human.stamina = 4;
        human.happiness = 3;

        Human human1 = new Human();
        human1.name = "Петя";
        human1.health = 45;
        human1.stamina = 5;
        human1.happiness = 15;

        Human human2 = new Human();
        human2.name = "Ванхеллсинг";
        human2.health = 350;
        human2.stamina = 15;
        human2.happiness = 15;

        vampire.eat();
        vampire.talk();
        vampire1.talk();
        vampire.sunrise();
        vampire1.sunrise();
        human.goToWork();
        human1.goToWork();

        vampire1.bite(human, vampire1);

        human.battle(human2, vampire2);
        human.battle(human1, vampire3);
    }
}
