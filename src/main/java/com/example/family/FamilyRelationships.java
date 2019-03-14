package com.example.family;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedHashSet;

public class FamilyRelationships {

    private static String NONE = "NONE";
    private static String PERSON_NOT_FOUND = "PERSON_NOT_FOUND";
    private Family family;

    FamilyRelationships(Family family) {
        this.family = family;
    }

    private boolean isMemberExist(Member member) {
        if(member == null)
            return false;
        return true;
    }

    public String getMother(String name) {
        Member member = family.get(name);
        if (!isMemberExist(member))
            return PERSON_NOT_FOUND;
        return member.getMother().getName();
    }

    public String getFather(String name) {
        Member member = family.get(name);
        if (!isMemberExist(member))
            return PERSON_NOT_FOUND;
        return member.getFather().getName();
    }

    public String getSpouse(String name) {
        Member member = family.get(name);
        if (!isMemberExist(member))
            return PERSON_NOT_FOUND;
        return member.getSpouse().getName();
    }

    public String getSon(String name) {
        Member member = family.get(name);
        if (!isMemberExist(member))
            return PERSON_NOT_FOUND;
        StringBuilder sb = new StringBuilder();
        for (Member child: member.getChildren()) {
            if (child.getGender() == Gender.MALE)
                sb.append(child.getName() + " ");
        }
        if(sb.length() > 0)
            return sb.toString().trim();
        return NONE;
    }

    public String getDaughter(String name) {
        Member member = family.get(name);
        if(!isMemberExist(member))
            return PERSON_NOT_FOUND;
        StringBuilder sb = new StringBuilder();
        for (Member child: member.getChildren()) {
            if (child.getGender() == Gender.FEMALE)
                sb.append(child.getName() + " ");
        }
        if(sb.length() > 0)
            return sb.toString().trim();
        return NONE;
    }

    public String getSiblings(String name) {
        Member member = family.get(name);
        if(!isMemberExist(member))
            return PERSON_NOT_FOUND;
        StringBuilder sb = new StringBuilder();
        LinkedHashSet<Member> siblings = member.getMother().getChildren();
        for (Member sibling: siblings) {
                sb.append(sibling.getName() + " ");
        }
        if(sb.length() > name.length() + 1) {
            return sb.toString().replace(name, "").trim();
        }
        return NONE;
    }

    private String getBrothersOf(Member member) {
        if(member.getName().equals("Unknown"))
            return NONE;
        String mom = member.getMother().getName();
        if(mom.equals("Unknown"))
            return NONE;
        String brothers = getSon(mom);
        String allBrothers = brothers.replace(member.getName(), "").trim();
        return allBrothers.length() == 0 ? NONE : allBrothers;
    }

    private String getSistersOf(Member member) {
        if(member.getName().equals("Unknown"))
            return NONE;
        String mom = member.getMother().getName();
        if(mom.equals("Unknown"))
            return NONE;
        String daughters = getDaughter(mom);
        String allDaughters = daughters.replace(member.getName(), "").trim();
        return allDaughters.length() == 0 ? NONE : allDaughters;
    }

    public String getPaternalUncle(String name) {
        Member member = family.get(name);
        if(!isMemberExist(member))
            return PERSON_NOT_FOUND;
        Member father = member.getFather();
        return getBrothersOf(father);
    }

    public String getPaternalAunt(String name) {
        Member member = family.get(name);
        if(!isMemberExist(member))
            return PERSON_NOT_FOUND;
        Member father = member.getFather();
        return getSistersOf(father);
    }

    public String getMaternalUncle(String name) {
        Member member = family.get(name);
        if(!isMemberExist(member))
            return PERSON_NOT_FOUND;
        Member mother = member.getMother();
        return getBrothersOf(mother);
    }

    public String getMaternalAunt(String name) {
        Member member = family.get(name);
        if(!isMemberExist(member))
            return PERSON_NOT_FOUND;
        Member mother = member.getMother();
        return getSistersOf(mother);
    }

    private String getSiblingsSpouses(String siblings) {
        StringBuilder sb = new StringBuilder();
        List<String> siblingList = Arrays.asList(siblings.split("\\s+"));
        for (String sibling : siblingList) {
            String spouse = family.get(sibling).getSpouse().getName();
            if (spouse != "Unknown")
                sb.append(spouse + " ");
        }
        return sb.toString().trim();
    }

    private String getSiblingsWives(Member member) {
        String brothers = getBrothersOf(member);
        if(isMemberPresent(brothers)) {
            return getSiblingsSpouses(brothers);
        }
        return brothers;
    }

    private String getSiblingsHusbands(Member member) {
        String sisters = getSistersOf(member);
        if(isMemberPresent(sisters)) {
            return getSiblingsSpouses(sisters);
        }
        return sisters;
    }

    public String getSisterInLaw(String name) {
        Member member = family.get(name);
        if(!isMemberExist(member))
            return PERSON_NOT_FOUND;
        StringBuilder sbSisterInLaws = new StringBuilder();
        String sisterOfSpouse = getSistersOf(member.getSpouse());
        String siblingsWives = getSiblingsWives(member);
        if(isMemberPresent(sisterOfSpouse)) {
            sbSisterInLaws.append(sisterOfSpouse);
        }
        if(isMemberPresent(siblingsWives)){
            sbSisterInLaws.append(" " + siblingsWives);
        }
        String sisterInLaw = sbSisterInLaws.toString().trim();
        return sisterInLaw.length() > 0 ? sisterInLaw : NONE;
    }

    private boolean isMemberPresent(String name) {
        return !name.equals(NONE) && !name.equals(PERSON_NOT_FOUND);
    }

    public String getBrotherInLaw(String name) {
        Member member = family.get(name);
        if(!isMemberExist(member))
            return PERSON_NOT_FOUND;
        StringBuilder sbBrotherInLaws = new StringBuilder();
        String brotherOfSpouse = getBrothersOf(member.getSpouse());
        String siblingsHusbands = getSiblingsHusbands(member);
        if(isMemberPresent(brotherOfSpouse)) {
            sbBrotherInLaws.append(brotherOfSpouse);
        }
        if(isMemberPresent(siblingsHusbands)){
            sbBrotherInLaws.append(" " + siblingsHusbands);
        }
        String sisterInLaw = sbBrotherInLaws.toString().trim();
        return sisterInLaw.length() > 0 ? sisterInLaw : NONE;
    }

}
