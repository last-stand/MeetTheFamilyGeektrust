package com.example.family;

import java.util.HashMap;

public class PopulateFamily {

    public static HashMap<String, Member> populateFamily() {
        HashMap<String, Member> familyMembers =  new HashMap<>();

        Member shan = new Member("King Shan", Gender.MALE);
        Member anga = new Member("Queen Anga", Gender.FEMALE);
        Member chit = new Member("Chit", Gender.MALE);
        Member ish = new Member("Ish", Gender.MALE);
        Member vich = new Member("Vich", Gender.MALE);
        Member aras = new Member("Aras", Gender.MALE);
        Member satya = new Member("Satya", Gender.FEMALE);
        Member amba = new Member("Amba", Gender.FEMALE);
        Member dritha = new Member("Dritha", Gender.FEMALE);
        Member tritha = new Member("Tritha", Gender.FEMALE);
        Member vritha = new Member("Vritha", Gender.MALE);
        Member jaya = new Member("Jaya", Gender.MALE);
        Member yodhan = new Member("Yodhan", Gender.MALE);
        Member lika = new Member("Lika", Gender.FEMALE);
        Member vila = new Member("Vila", Gender.FEMALE);
        Member chika = new Member("Chika", Gender.FEMALE);
        Member chitra = new Member("Chitra", Gender.FEMALE);
        Member jnki = new Member("Jnki", Gender.FEMALE);
        Member ahit = new Member("Ahit", Gender.MALE);
        Member arit = new Member("Arit", Gender.MALE);
        Member laki = new Member("Laki", Gender.MALE);
        Member lavnya = new Member("Lavnya", Gender.FEMALE);
        Member vyan = new Member("Vyan", Gender.MALE);
        Member asva = new Member("Asva", Gender.MALE);
        Member vyas = new Member("Vyas", Gender.MALE);
        Member atya = new Member("Atya", Gender.FEMALE);
        Member satvy = new Member("Satvy", Gender.FEMALE);
        Member vasa = new Member("Vasa", Gender.MALE);
        Member krpi = new Member("Krpi", Gender.FEMALE);
        Member kriya = new Member("Kriya", Gender.MALE);
        Member krithi = new Member("Krithi", Gender.FEMALE);

        familyMembers.put("King Shan", shan);
        familyMembers.put("Queen Anga", anga);
        familyMembers.put("Chit", chit);
        familyMembers.put("Ish", ish);
        familyMembers.put("Vich", vich);
        familyMembers.put("Aras", aras);
        familyMembers.put("Satya", satya);
        familyMembers.put("Amba", amba);
        familyMembers.put("Dritha", dritha);
        familyMembers.put("Tritha", tritha);
        familyMembers.put("Vritha", vritha);
        familyMembers.put("Jaya", jaya);
        familyMembers.put("Yodhan", yodhan);
        familyMembers.put("Lika", lika);
        familyMembers.put("Vila", vila);
        familyMembers.put("Chika", chika);
        familyMembers.put("Chitra", chitra);
        familyMembers.put("Jnki", jnki);
        familyMembers.put("Ahit", ahit);
        familyMembers.put("Arit", arit);
        familyMembers.put("Laki", laki);
        familyMembers.put("Lavnya", lavnya);
        familyMembers.put("Vyan", vyan);
        familyMembers.put("Asva", asva);
        familyMembers.put("Vyas", vyas);
        familyMembers.put("Atya", atya);
        familyMembers.put("Satvy", satvy);
        familyMembers.put("Vasa", vasa);
        familyMembers.put("Krpi", krpi);
        familyMembers.put("Kriya", kriya);
        familyMembers.put("Krithi", krithi);


        shan.setSpouse(anga);
        anga.addChild(chit);
        anga.addChild(ish);
        anga.addChild(vich);
        anga.addChild(aras);
        anga.addChild(satya);

        chit.setSpouse(amba);
        amba.addChild(dritha);
        amba.addChild(tritha);
        amba.addChild(vritha);
        dritha.setSpouse(jaya);
        dritha.addChild(yodhan);

        vich.setSpouse(lika);
        lika.addChild(vila);
        lika.addChild(chika);

        aras.setSpouse(chitra);
        chitra.addChild(jnki);
        chitra.addChild(ahit);
        jnki.setSpouse(arit);
        jnki.addChild(laki);
        jnki.addChild(lavnya);

        satya.setSpouse(vyan);
        satya.addChild(asva);
        satya.addChild(vyas);
        satya.addChild(atya);
        asva.setSpouse(satvy);
        satvy.addChild(vasa);

        vyas.setSpouse(krpi);
        krpi.addChild(kriya);
        krpi.addChild(krithi);

        return familyMembers;
    }
}
