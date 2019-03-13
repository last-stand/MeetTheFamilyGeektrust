package com.example.family;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class MeetTheFamily {

    static void readFile(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String filePath = scanner.nextLine();
//        readFile(args[0]);
//        readFile("/Users/jaiprak/workspace/geektrust/src/main/resources/example");
        HashMap<String, Member> familyMembers =  PopulateFamily.populateFamily();
        Family royalFamily = new Family(familyMembers);
    }
}
