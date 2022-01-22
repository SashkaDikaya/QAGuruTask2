package com.dikayaav.tests;

public class Test {

    public static void main (String[]args){
        Vampire vampire = new Vampire(); //объект
        vampire.name = "Алукард";
        vampire.age = 1000;
        vampire.isHunger = true;
        vampire.power = 13;

        Vampire vampire2 = new Vampire(); //объект
        vampire2.name = "Дракула";
        vampire2.age = 2000;
        vampire2.isHunger = true;
        vampire.power = 16;


        Human human = new Human();
        human.health = 100;


        vampire.eat();
        vampire.talk();
        vampire2.talk();
        vampire.sunrise();
        vampire2.sunrise();
    }
}
