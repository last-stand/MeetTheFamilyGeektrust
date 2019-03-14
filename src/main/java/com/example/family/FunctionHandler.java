package com.example.family;

public class FunctionHandler {

    private Family family;
    private FamilyRelationships familyRelationships;

    public FunctionHandler(Family family) {
        this.family = family;
        this.familyRelationships = new FamilyRelationships(family);
    }

    public void execute(String input) {
        String[] inputArray = input.split("\\s+");
        if (inputArray[0].equals("ADD_CHILD")){
            family.addChildToFamily(inputArray[1], inputArray[2], Gender.valueOf(inputArray[3].toUpperCase()));
        }
        if (inputArray[0].equals("GET_RELATIONSHIP")){
            switch (inputArray[2]){
                case "Son":
                    System.out.println(familyRelationships.getSon(inputArray[1]));
                    break;
                case "Daughter":
                    System.out.println(familyRelationships.getDaughter(inputArray[1]));
                    break;
                case "Siblings":
                    System.out.println(familyRelationships.getSiblings(inputArray[1]));
                    break;
                case "Paternal-Uncle":
                    System.out.println(familyRelationships.getPaternalUncle(inputArray[1]));
                    break;
                case "Paternal-Aunt":
                    System.out.println(familyRelationships.getPaternalAunt(inputArray[1]));
                    break;
                case "Maternal-Uncle":
                    System.out.println(familyRelationships.getMaternalUncle(inputArray[1]));
                    break;
                case "Maternal-Aunt":
                    System.out.println(familyRelationships.getMaternalAunt(inputArray[1]));
                    break;
                case "Sister-In-Law":
                    System.out.println(familyRelationships.getSisterInLaw(inputArray[1]));
                    break;
                case "Brother-In-Law":
                    System.out.println(familyRelationships.getBrotherInLaw(inputArray[1]));
                    break;
                default:
                    System.out.println("INVALID INPUT");
                    break;
            }
        }
        else{
            System.out.println("INVALID INPUT");
        }
    }
}
