package com.dikayaav.tests;

public class Test {

    public static void main (String[]args){
        Vampire vampire = new Vampire(); //объект
        vampire.name = "Алукард";
        vampire.age = 1000;
        vampire.isHunger = true;
        vampire.power = 13;
        vampire.health = 1000;
        vampire.bite = 300;

        Vampire vampire2 = new Vampire(); //объект
        vampire2.name = "Дракула";
        vampire2.age = 2000;
        vampire2.isHunger = true;
        vampire.power = 16;
        vampire2.health = 2000;
        vampire2.bite = 450;

        Mage mage = new Mage(); //объект
        mage.mageClass = "Некромант";
        mage.age = 46;
        mage.power = 3;
        mage.damage = 5;
        mage.health = 180;

        vampire.eat();
        vampire.talk();
        vampire2.talk();
        vampire.sunrise();
        vampire2.sunrise();
    }
}
