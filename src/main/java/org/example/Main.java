package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    static int choice;

    public static Set<String> textProcessingSet = new HashSet<String>();

    static Scanner scanner = new Scanner(System.in);

    public static void menu(){
        System.out.println();
        System.out.println("1. View All Text");
        System.out.println("2. Add Text");
        System.out.println("3. Replace Text");
        System.out.println("4. Delete Text");
        System.out.println("5. Exit");
        System.out.println("6. Search Text");
        System.out.println();

        System.out.print("Choose an option: ");

        try{
            choice =  scanner.nextInt();
        } catch(Exception e){
            choice = -1;
        }

        scanner.nextLine();

        switch (choice){
            case 1:
                if(textProcessingSet.isEmpty()){
                    System.out.println("Nothing to Display");
                } else {
                    System.out.println("A list of text in the set");

                    textProcessingSet.forEach((text) -> {
                        System.out.println(text);
                    });
                }

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

                if(textProcessingSet.isEmpty()) {
                    System.out.println("There's Nothing to Replace!");
                } else {
                    System.out.println("Replace Text");
                    System.out.print("Enter text to replace: ");
                    String oldText = scanner.nextLine().trim();

                    if(textProcessingSet.contains(oldText)) {
                        System.out.print("Enter new text: ");
                        String newText = scanner.nextLine().trim();

                        Pattern pattern = Pattern.compile("\\b" + oldText + "\\b");

                        textProcessingSet = textProcessingSet.stream()
                                        .map(phrase -> pattern.matcher(phrase).replaceAll(newText))
                                        .collect(Collectors.toSet());

                        System.out.println("Text replaced successfully!");
                    } else {
                        System.out.println(oldText + " is not in the set!");
                    }
                }
                break;
            case 4:
                System.out.println("4. Delete Text");
                break;
            case 5:
                System.out.println("Exit");
                System.out.println("The program says bye!");
                break;
            case 6:
                if(textProcessingSet.isEmpty()){
                    System.out.println("The Set is Empty!");
                } else {
                    System.out.println("Search Text");
                    System.out.print("Enter text to search: ");
                    String search = scanner.nextLine().trim();

                    Pattern pattern = Pattern.compile(search);

                    textProcessingSet.stream()
                            .filter(phrase -> pattern.matcher(phrase).find())
                            .forEach(phrase -> System.out.println("Match found: " + phrase));
                }
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