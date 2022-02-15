package com.dikayaav.tests;

public class Human{
    int health;
    double stamina;
    String name;
    float happiness;
    double exhaustion = happiness * 0.3;

void goToWork() {
    System.out.println(name + " идет ишачить на работу");
    stamina = stamina - 8 * exhaustion;
    if (stamina <= 5) {
        System.out.println(name + " ползет уставший домой");
    } else {
        System.out.println(name + " идет домой");
    }
}

void looseHealth (Human human, Vampire vampire) {
    human.health -= vampire.power;

}

void battle (Human human, Vampire vampire) {
    int i = 0;
    while (human.health > 0 & vampire.health > 0)  {
        System.out.println(vampire.name + " кусает " + human.name);
        System.out.println(human.name + " бьет " + vampire.name);
        human.health -= vampire.power;
        vampire.health -= human.stamina;
        i += 1;

    }
    if (human.health < 0)
    System.out.println(human.name + " умер. " + vampire.name + " укусил " + human.name + " " + i + "раз" );
    else
        System.out.println(vampire.name + " умер. " + human.name + " ударил " + vampire.name + " " + i + "раз" );

}

}
