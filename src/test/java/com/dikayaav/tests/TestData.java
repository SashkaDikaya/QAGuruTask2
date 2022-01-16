package com.dikayaav.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static String
    firstName = "Alexandra",
    lastName = "Dikaya",
    email = "dikaya@gmail.com",
    femaleGender = "Female",
    phone = "1234567890",
    day = "29",
    month = "December",
    year = "1987",
    subject = "Maths",
    hobbie = "Music",
    picture = "img/Alukard.png",
    address = "Saint-P, Red kursant, house 4, app 15",
    state = "Haryana",
    city = "Karnal";

    static Faker faker = new Faker(new Locale("ru"));
    public static String
    randomFirstName = faker.name().firstName(),
    randomLastName = faker.name().lastName(),
    randomEmail = faker.internet().emailAddress(),
    randomAddress = faker.address().fullAddress(),
    randomPhoneNumber = faker.phoneNumber().subscriberNumber(10);




}
