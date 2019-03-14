package com.example.family;

import javax.xml.soap.Node;
import java.util.Set;

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
        Set<Member> siblings = member.getMother().getChildren();
        for (Member sibling: siblings) {
                sb.append(sibling.getName() + " ");
        }
        if(sb.length() > name.length() + 1)
            return sb.toString().replace(name, "").trim();
        return NONE;
    }

    private String getBrothersOf(Member member) {
        String mom = member.getMother().getName();
        if(mom.equals("Unknown"))
            return NONE;
        String brothers = getSon(mom);
        String allBrothers = brothers.replace(member.getName(), "").trim();
        return allBrothers.length() == 0 ? NONE : allBrothers;
    }

    private String getSistersOf(Member member) {
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
}
