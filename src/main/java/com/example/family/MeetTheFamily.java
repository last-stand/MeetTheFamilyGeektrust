package com.example.family;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class MeetTheFamily {

    public static void main(String[] args) {
        TreeMap<String, Member> familyMembers =  PopulateFamily.populateFamily();
        Family royalFamily = new Family(familyMembers);
        FunctionHandler functionHandler = new FunctionHandler(royalFamily);
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            while (scanner.hasNextLine()) {
                functionHandler.execute(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(familyMembers.toString());
    }
}
