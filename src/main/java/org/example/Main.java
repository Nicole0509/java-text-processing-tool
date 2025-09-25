package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int choice;

    public static Set<String> textProcessingSet = new HashSet<String>();

    static Scanner scanner = new Scanner(System.in);

    public static void menu(){
        System.out.println();
        System.out.println("1. View All Text");
        System.out.println("2. Add Text");
        System.out.println("3. Update Text");
        System.out.println("4. Delete Text");
        System.out.println("5. Exit");
        System.out.println();

        System.out.print("Choose an option:");

        try{
            choice =  scanner.nextInt();
        } catch(Exception e){
            choice = -1;
        }

        scanner.nextLine();

        switch (choice){
            case 1:
                System.out.println("1. View All Text");

                textProcessingSet.forEach((text) -> {
                    System.out.println(text);
                });
                break;
            case 2:
                System.out.println("Add Text");

                System.out.print("Enter Text to Add: ");

                String text = scanner.nextLine().trim();
                System.out.println(text);

                if(text.isEmpty()) {
                    do{
                        System.out.println("\nEmpty text phrases are not allowed!");
                        System.out.print("Please enter a valid text: ");
                        text = scanner.nextLine().trim();
                    }while(text.isEmpty());

                    textProcessingSet.add(text);

                } else{
                    textProcessingSet.add(text);
                }

                System.out.println("Text added successfully!");
                System.out.println("You have " + textProcessingSet.size() + " texts available in the set!");
                break;
            case 3:
                System.out.println("3. Update Text");
                break;
            case 4:
                System.out.println("4. Delete Text");
                break;
            case 5:
                System.out.println("Exit");
                System.out.println("The program says bye!");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void main(String[] args) {

        System.out.println("TEXT PROCESSING WITH JAVA!");

        do{
            menu();
        } while (choice != 5);
    }
}