package com.dikayaav.tests;

public class Test {

    public static void main (String[]args){
        Vampire vampire = new Vampire("Алукард", true, 5);
        Vampire vampire1 = new Vampire("Дракула", false, 7);

        Human human = new Human("Vasya", 6);
        Human human1 = new Human("Alyosha", 1);

        vampire.vampireAwake(vampire, human);
        vampire.vampireAwake(vampire1, human1);


    }
}
