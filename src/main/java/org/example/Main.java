package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static Set<String> textProcessing = new HashSet<String>();

    static Scanner scanner = new Scanner(System.in);

    public static void menu(int choice){
        System.out.println("1. View All Text");
        System.out.println("2. Add Text");
        System.out.println();

        switch (choice){
            case 1:
                System.out.println("1. View All Text");
                break;
            case 2:
                System.out.println("Add Text");
                System.out.print("Enter Text to Add");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void main(String[] args) {

        System.out.println("TEXT PROCESSING WITH JAVA!");
        menu(2);
    }
}