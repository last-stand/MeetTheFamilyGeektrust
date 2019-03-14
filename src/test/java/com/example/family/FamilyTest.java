package com.example.family;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class FamilyTest {

    private  Family family;

    @Test
    public void addChildToFamilyShouldAddNewMemberToFamilyThroughMother() {
        Member chitra = new Member("Chitra", Gender.FEMALE);
        Member aras = new Member("Aras", Gender.MALE);
        chitra.setSpouse(aras);
        HashMap<String, Member> familyMembers = new HashMap<>();
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
        HashMap<String, Member> familyMembers = new HashMap<>();
        familyMembers.put("Chitra", chitra);
        familyMembers.put("Aras", aras);
        family = new Family(familyMembers);

        family.addChildToFamily("Aras", "Jnki", Gender.FEMALE);
        family.addChildToFamily("Aras", "Ahit", Gender.MALE);


        assertEquals(2, family.getSize());
    }
}