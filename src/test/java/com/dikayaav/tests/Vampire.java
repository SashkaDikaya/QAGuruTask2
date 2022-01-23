package com.dikayaav.tests;

public class Vampire {

    String name;
    boolean isHunger;
    int power;
    int health;
    int sunDamage = 1000;

    void eat() {
        System.out.println(name + " выпил крови");
        isHunger = false;
    }

    void talk() {
        System.out.println(name + " говорит: ");
        if (isHunger) {
            System.out.println("'Пойду посплю'");
        } else {
            System.out.println("'Пойду поем'");
        }
     }

     void sunrise() {
         System.out.println(name + " говорит: 'О нет! Солнце застало меня в расплох!'");
        health = health - sunDamage;
        if (health <= 0) {
            System.out.println(name + " воспламенился и истлел");
        } else {
            System.out.println(name + " раненый уползает в тень");
        }
     }


}
