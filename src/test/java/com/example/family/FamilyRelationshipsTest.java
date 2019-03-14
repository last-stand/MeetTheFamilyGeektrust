package com.example.family;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FamilyRelationshipsTest {

    private HashMap<String, Member> familyMembers =  PopulateFamily.populateFamily();
    Family family = new Family(familyMembers);
    private  FamilyRelationships relationships = new FamilyRelationships(family);

    @Test
    public void getMotherSholudReturnMotherName() {
        String mother = relationships.getMother("Asva");

        assertEquals("Satya", mother);
    }

    @Test
    public void getMotherSholudReturnUnknownIfMotherNotExist() {
        String mother = relationships.getMother("Lika");

        assertEquals("Unknown", mother);
    }

    @Test
    public void getMotherSholudReturnPersonNotFoundIfPersonNotExist() {
        String mother = relationships.getMother("Apollo");

        assertEquals("PERSON_NOT_FOUND", mother);
    }

    @Test
    public void getFatherSholudReturnFatherName() {
        String father = relationships.getFather("Vyas");

        assertEquals("Vyan", father);
    }

    @Test
    public void getFatherSholudReturnUnknownIfFatherNotExist() {
        String father = relationships.getFather("Arit");

        assertEquals("Unknown", father);
    }

    @Test
    public void getFatherSholudReturnPersonNotFoundIfPersonNotExist() {
        String mother = relationships.getMother("Luna");

        assertEquals("PERSON_NOT_FOUND", mother);
    }

    @Test
    public void getSonShouldReturnAllSons() {
        String sons = relationships.getSon("Vyan");
        List<String> sonsList = Arrays.asList(sons.split("\\s+"));

        assertTrue(sonsList.contains("Asva"));
        assertTrue(sonsList.contains("Vyas"));
        assertEquals(2, sonsList.size());
    }

    @Test
    public void getSonShouldReturnNoneIfNoSonsPresent() {
        String sons = relationships.getSon("Lika");

        assertTrue(sons.equals("NONE"));
    }

    @Test
    public void getSonSholudReturnPersonNotFoundIfPersonNotExist() {
        String sons = relationships.getSon("Luna");

        assertEquals("PERSON_NOT_FOUND", sons);
    }

    @Test
    public void getDaughterShouldReturnAllDaughters() {
        String daughters = relationships.getDaughter("Amba");
        List<String> daughtersList = Arrays.asList(daughters.split("\\s+"));

        assertTrue(daughtersList.contains("Dritha"));
        assertTrue(daughtersList.contains("Tritha"));
        assertEquals(2, daughtersList.size());
    }

    @Test
    public void getDaughterShouldRetuenNoneIfNoDaughtersPresent() {
        String daughters = relationships.getDaughter("Ish");

        assertTrue(daughters.equals("NONE"));
    }

    @Test
    public void getDaughterSholudReturnPersonNotFoundIfPersonNotExist() {
        String daughters = relationships.getSon("Apollo");

        assertEquals("PERSON_NOT_FOUND", daughters);
    }

    @Test
    public void getSiblingsSholudReturnAllSiblingOfGivenMember() {
        String siblings = relationships.getSiblings("Dritha");
        List<String> siblingsList = Arrays.asList(siblings.split("\\s+"));

        assertTrue(siblingsList.contains("Tritha"));
        assertTrue(siblingsList.contains("Vritha"));
        assertEquals(2, siblingsList.size());
    }

    @Test
    public void getSiblingsSholudReturnNoneIfNoSiblingsPresent() {
        String siblings = relationships.getSiblings("Vasa");

        assertEquals("NONE", siblings);
    }


    @Test
    public void getSiblingsSholudReturnPersonNotFoundIfPersonNotExist() {
        String siblings = relationships.getSiblings("Apollo");

        assertEquals("PERSON_NOT_FOUND", siblings);
    }

    @Test
    public void getPaternalUncleSholudReturnAllBrothersOfFather() {
        String paternalUncles = relationships.getPaternalUncle("Chika");
        List<String> paternalUnclesList = Arrays.asList(paternalUncles.split("\\s+"));

        assertTrue(paternalUnclesList.contains("Chit"));
        assertTrue(paternalUnclesList.contains("Ish"));
        assertTrue(paternalUnclesList.contains("Aras"));
        assertEquals(3, paternalUnclesList.size());
    }

    @Test
    public void getPaternalUncleSholudReturnNoneIfFatherHasNoBrother() {
        String paternalUncles = relationships.getPaternalUncle("Yodhan");

        assertEquals("NONE", paternalUncles);
    }

    @Test
    public void getPaternalUncleSholudReturnPersonNotFoundIfPersonNotExist() {
        String paternalUncles = relationships.getPaternalUncle("Sam");

        assertEquals("PERSON_NOT_FOUND", paternalUncles);
    }

    @Test
    public void getMaternalUncleSholudReturnAllBrothersOfMother() {
        String maternalUncles = relationships.getMaternalUncle("Atya");
        List<String> maternalUnclesList = Arrays.asList(maternalUncles.split("\\s+"));

        assertTrue(maternalUnclesList.contains("Chit"));
        assertTrue(maternalUnclesList.contains("Ish"));
        assertTrue(maternalUnclesList.contains("Vich"));
        assertTrue(maternalUnclesList.contains("Aras"));
        assertEquals(4, maternalUnclesList.size());
    }

    @Test
    public void getMaternalUncleSholudReturnNoneIfMotherHasNoBrother() {
        String maternalUncles = relationships.getMaternalUncle("Jnki");

        assertEquals("NONE", maternalUncles);
    }

    @Test
    public void getMaternalUncleSholudReturnPersonNotFoundIfPersonNotExist() {
        String maternalUncles = relationships.getMaternalUncle("Sam");

        assertEquals("PERSON_NOT_FOUND", maternalUncles);
    }

    @Test
    public void getPaternalAuntSholudReturnAllSistersOfFather() {
        String paternalAunts = relationships.getPaternalAunt("Kriya");
        List<String> paternalAuntsList = Arrays.asList(paternalAunts.split("\\s+"));

        assertTrue(paternalAuntsList.contains("Atya"));
        assertEquals(1, paternalAuntsList.size());
    }

    @Test
    public void getPaternalAuntSholudReturnNoneIfFatherHasNoSister() {
        String paternalAunts = relationships.getPaternalAunt("Satya");

        assertEquals("NONE", paternalAunts);
    }

    @Test
    public void getPaternalAuntSholudReturnPersonNotFoundIfPersonNotExist() {
        String paternalAunts = relationships.getPaternalAunt("Anna");

        assertEquals("PERSON_NOT_FOUND", paternalAunts);
    }

    @Test
    public void getMaternalAuntSholudReturnAllSistersOfMother() {
        String maternalAunts = relationships.getMaternalAunt("Yodhan");
        List<String> maternalAuntsList = Arrays.asList(maternalAunts.split("\\s+"));

        assertTrue(maternalAuntsList.contains("Tritha"));
        assertEquals(1, maternalAuntsList.size());
    }

    @Test
    public void getMaternalAuntSholudReturnNoneIfMotherHasNoSister() {
        String maternalAunts = relationships.getMaternalAunt("Lavnya");

        assertEquals("NONE", maternalAunts);
    }

    @Test
    public void getMaternalAuntSholudReturnPersonNotFoundIfPersonNotExist() {
        String maternalAunts = relationships.getMaternalAunt("Anna");

        assertEquals("PERSON_NOT_FOUND", maternalAunts);
    }

    @Test
    public void getSisterInLawSholudReturnSistersOfSpouse() {
        String sisterInLaw = relationships.getSisterInLaw("Jaya");
        List<String> sisterInLawsList = Arrays.asList(sisterInLaw.split("\\s+"));

        assertTrue(sisterInLawsList.contains("Tritha"));
        assertEquals(1, sisterInLawsList.size());
    }

    @Test
    public void getSisterInLawSholudReturnWivesOfSiblings() {
        String sisterInLaw = relationships.getSisterInLaw("Satya");
        List<String> sisterInLawsList = Arrays.asList(sisterInLaw.split("\\s+"));

        assertTrue(sisterInLawsList.contains("Amba"));
        assertTrue(sisterInLawsList.contains("Lika"));
        assertTrue(sisterInLawsList.contains("Chitra"));
        assertEquals(3, sisterInLawsList.size());
    }

    @Test
    public void getSisterInLawSholudReturnNoneIfSpouseHasNoSisterOrWivesOfSiblings() {
        String sisterInLaw = relationships.getSisterInLaw("Vyan");

        assertEquals("NONE", sisterInLaw);
    }

    @Test
    public void getSisterInLawSholudReturnPersonNotFoundIfPersonNotExist() {
        String sisterInLaw = relationships.getSisterInLaw("John");

        assertEquals("PERSON_NOT_FOUND", sisterInLaw);
    }

    @Test
    public void getBrotherInLawSholudReturnBrothersOfSpouse() {
        String brotherInLaw = relationships.getBrotherInLaw("Vyan");
        List<String> brotherInLawsList = Arrays.asList(brotherInLaw.split("\\s+"));

        assertTrue(brotherInLawsList.contains("Chit"));
        assertTrue(brotherInLawsList.contains("Ish"));
        assertTrue(brotherInLawsList.contains("Vich"));
        assertTrue(brotherInLawsList.contains("Aras"));
        assertEquals(4, brotherInLawsList.size());
    }

    @Test
    public void getBrotherInLawSholudReturnHusbandsOfSiblings() {
        String brotherInLaw = relationships.getBrotherInLaw("Tritha");
        List<String> brotherInLawsList = Arrays.asList(brotherInLaw.split("\\s+"));

        assertTrue(brotherInLawsList.contains("Jaya"));
        assertEquals(1, brotherInLawsList.size());
    }

    @Test
    public void getBrotherInLawSholudReturnNoneIfSpouseHasNoBrotherOrHusbandsOfSiblings() {
        String brotherInLaw = relationships.getBrotherInLaw("Jnki");

        assertEquals("NONE", brotherInLaw);
    }

    @Test
    public void getBrotherInLawSholudReturnPersonNotFoundIfPersonNotExist() {
        String brotherInLaw = relationships.getBrotherInLaw("Sammy");

        assertEquals("PERSON_NOT_FOUND", brotherInLaw);
    }

}