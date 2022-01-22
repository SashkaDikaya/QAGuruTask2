package com.dikayaav.tests;

public class Vampire {

    String name;
    int age;
    int hunger;
    boolean isHunger;

    public static void main (String[]args){
        Vampire vampire = new Vampire(); //объект
        vampire.name = "Алукард";
        vampire.age = 1000;
        vampire.isHunger = true;

        Vampire vampire2 = new Vampire(); //объект
        vampire2.name = "Дракула";
        vampire2.age = 2000;
        vampire2.isHunger = true;
    }



    void eat() {
        hunger = 0;
        isHunger = false;
    }


    void talk() {
        if (isHunger = true) {
            System.out.println(name + ": Пойду посплю");
        } else {
            System.out.println(name + ": Пойду поем");
        }
     }


}






