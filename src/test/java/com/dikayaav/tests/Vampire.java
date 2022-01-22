package com.dikayaav.tests;

public class Vampire {

    String name;
    int age;
    boolean isHunger;
    int power;
    int damage = power * 2;
    int health;
    int sunDamage = 1000;
    int bite;

    void eat() {
        System.out.println(name + " выпил крови");
        isHunger = false;
    }

    void talk() {

        if (isHunger == false) {
            System.out.println(name + ": Пойду посплю");
        } else {
            System.out.println(name + ": Пойду поем");
        }
     }

     void sunrise() {
        health = health - sunDamage;
        if (health <= 0) {
            System.out.println(name + " воспламенился и истлел");
        } else {
            System.out.println(name + " раненый уползает в тень");
        }
     }


}






