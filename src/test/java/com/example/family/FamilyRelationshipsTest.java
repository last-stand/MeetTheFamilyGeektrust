package com.example.family;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class FamilyRelationshipsTest {

    private final TreeMap<String, Member> familyMembers =  PopulateFamily.populateFamily();
    Family family = new Family(familyMembers);
    private final FamilyRelationships relationships = new FamilyRelationships(family);

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

        assertEquals(sonsList.get(0), "Asva");
        assertEquals(sonsList.get(1), "Vyas");
        assertEquals(2, sonsList.size());
    }

    @Test
    public void getSonShouldReturnNoneIfNoSonsPresent() {
        String sons = relationships.getSon("Lika");

        assertEquals("NONE", sons);
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

        assertEquals(daughtersList.get(0), "Dritha");
        assertEquals(daughtersList.get(1), "Tritha");
        assertEquals(2, daughtersList.size());
    }

    @Test
    public void getDaughterShouldRetuenNoneIfNoDaughtersPresent() {
        String daughters = relationships.getDaughter("Ish");

        assertEquals("NONE", daughters);
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

        assertEquals(siblingsList.get(0), "Tritha");
        assertEquals(siblingsList.get(1), "Vritha");
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

        assertEquals(paternalUnclesList.get(0), "Chit");
        assertEquals(paternalUnclesList.get(1), "Ish");
        assertEquals(paternalUnclesList.get(2), "Aras");
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

        assertEquals(maternalUnclesList.get(0), "Chit");
        assertEquals(maternalUnclesList.get(1), "Ish");
        assertEquals(maternalUnclesList.get(2), "Vich");
        assertEquals(maternalUnclesList.get(3), "Aras");
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

        assertEquals(paternalAuntsList.get(0), "Atya");
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

        assertEquals(maternalAuntsList.get(0),"Tritha");
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

        assertEquals(sisterInLawsList.get(0), "Tritha");
        assertEquals(1, sisterInLawsList.size());
    }

    @Test
    public void getSisterInLawSholudReturnWivesOfSiblings() {
        String sisterInLaw = relationships.getSisterInLaw("Satya");
        List<String> sisterInLawsList = Arrays.asList(sisterInLaw.split("\\s+"));

        assertEquals(sisterInLawsList.get(0), "Amba");
        assertEquals(sisterInLawsList.get(1), "Lika");
        assertEquals(sisterInLawsList.get(2), "Chitra");
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

        assertEquals(brotherInLawsList.get(0), "Chit");
        assertEquals(brotherInLawsList.get(1), "Ish");
        assertEquals(brotherInLawsList.get(2), "Vich");
        assertEquals(brotherInLawsList.get(3), "Aras");
        assertEquals(4, brotherInLawsList.size());
    }

    @Test
    public void getBrotherInLawSholudReturnHusbandsOfSiblings() {
        String brotherInLaw = relationships.getBrotherInLaw("Tritha");
        List<String> brotherInLawsList = Arrays.asList(brotherInLaw.split("\\s+"));

        assertEquals(brotherInLawsList.get(0), "Jaya");
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