package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String filePath = "./data.txt";

    static Scanner in = new Scanner(System.in);

    public static ArrayList<Person> peopleArray = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Load data from previous run? Enter y for yes");
        String answer = in.next();

        if (answer.equals("y")) {
            readDataFromFile();
        }

        System.out.println("Add new data? Enter y for yes");
        answer = in.next();

        if (answer.equals("y")) {
            addNewPerson();
        }
    }

    public static void addNewPerson() {
        System.out.println("Enter name: ");
        String answer = in.next();

        Person newPerson = new Person(answer);

        System.out.println("Enter id number: ");
        answer = in.next();

        newPerson.id = answer;
        String data = newPerson.dataAsString();

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath, true);
        } catch (Exception error) {
            System.out.println("This error occured: " + error);
            return;
        }

        byte[] dataBytes = data.getBytes();

        try {
            outputStream.write(dataBytes);
        } catch (Exception error) {
            System.out.println("You got this error: " + error);
        }
    }

    public static void readDataFromFile() {
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            String data = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            String[] personStrings = data.split(",");

            for (int i = 0; i < personStrings.length; i++) {
                String[] personString = personStrings[i].split("-");
                String name = personString[0];
                String id = personString[1];
                Person person = new Person(name, id);
                peopleArray.add(person);
            }

            System.out.println("Printing out persons from text file database: ");
            for (int i = 0; i < peopleArray.size(); i++) {
                Person person = peopleArray.get(i);
                String personData = person.dataAsString();
                System.out.println(personData);
            }
        } catch (Exception error) {
            System.out.println("This error occured: " + error);
        }
    }
}

class Person {
    public String name;
    public String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Person(String name) {
        this.name = name;
    }

    public String dataAsString() {
        return this.name + "-" + this.id +",";
    }
}
