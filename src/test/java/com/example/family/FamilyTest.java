package com.example.family;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class FamilyTest {

    private  Family family;

    @Test
    public void addChildToFamilyShouldAddNewMemberToFamilyThroughMother() {
        Member chitra = new Member("Chitra", Gender.FEMALE);
        Member aras = new Member("Aras", Gender.MALE);
        chitra.setSpouse(aras);
        TreeMap<String, Member> familyMembers = new TreeMap<>();
        familyMembers.put("Chitra", chitra);
        familyMembers.put("Aras", aras);
        family = new Family(familyMembers);

        family.addChildToFamily("Chitra", "Jnki", Gender.FEMALE);
        family.addChildToFamily("Chitra", "Ahit", Gender.MALE);

        assertEquals("Jnki", family.get("Jnki").getName());
        assertEquals("Ahit", family.get("Ahit").getName());
        assertEquals(4, family.getSize());
    }

    @Test
    public void addChildToFamilyShouldNotAddNewMemberThroughFather() {
        Member chitra = new Member("Chitra", Gender.FEMALE);
        Member aras = new Member("Aras", Gender.MALE);
        chitra.setSpouse(aras);
        TreeMap<String, Member> familyMembers = new TreeMap<>();
        familyMembers.put("Chitra", chitra);
        familyMembers.put("Aras", aras);
        family = new Family(familyMembers);

        family.addChildToFamily("Aras", "Jnki", Gender.FEMALE);
        family.addChildToFamily("Aras", "Ahit", Gender.MALE);

        assertEquals(2, family.getSize());
    }

    @Test
    public void addChildToFamilyShouldReturnPersonNotFoundIfPersonNotExist(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Member chitra = new Member("Chitra", Gender.FEMALE);
        Member aras = new Member("Aras", Gender.MALE);
        chitra.setSpouse(aras);
        TreeMap<String, Member> familyMembers = new TreeMap<>();
        familyMembers.put("Chitra", chitra);
        familyMembers.put("Aras", aras);
        family = new Family(familyMembers);

        family.addChildToFamily("Anna", "Mina", Gender.FEMALE);

        assertEquals("PERSON_NOT_FOUND\n", outContent.toString());

    }
}