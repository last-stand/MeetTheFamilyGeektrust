package com.example.family;
import java.util.TreeMap;

public class PopulateFamily {

    public static TreeMap<String, Member> populateFamily() {
        TreeMap<String, Member> familyTree =  new TreeMap<>();

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

        familyTree.put("King Shan", shan);
        familyTree.put("Queen Anga", anga);
        familyTree.put("Chit", chit);
        familyTree.put("Ish", ish);
        familyTree.put("Vich", vich);
        familyTree.put("Aras", aras);
        familyTree.put("Satya", satya);
        familyTree.put("Amba", amba);
        familyTree.put("Dritha", dritha);
        familyTree.put("Tritha", tritha);
        familyTree.put("Vritha", vritha);
        familyTree.put("Jaya", jaya);
        familyTree.put("Yodhan", yodhan);
        familyTree.put("Lika", lika);
        familyTree.put("Vila", vila);
        familyTree.put("Chika", chika);
        familyTree.put("Chitra", chitra);
        familyTree.put("Jnki", jnki);
        familyTree.put("Ahit", ahit);
        familyTree.put("Arit", arit);
        familyTree.put("Laki", laki);
        familyTree.put("Lavnya", lavnya);
        familyTree.put("Vyan", vyan);
        familyTree.put("Asva", asva);
        familyTree.put("Vyas", vyas);
        familyTree.put("Atya", atya);
        familyTree.put("Satvy", satvy);
        familyTree.put("Vasa", vasa);
        familyTree.put("Krpi", krpi);
        familyTree.put("Kriya", kriya);
        familyTree.put("Krithi", krithi);


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

        return familyTree;
    }
}
