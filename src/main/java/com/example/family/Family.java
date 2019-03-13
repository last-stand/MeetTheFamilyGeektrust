package com.example.family;

import java.util.HashMap;

public class Family {
    private HashMap<String, Member> familyMembers;

    public Family(HashMap<String, Member> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public Member addNewMember(Member mother, String name, Gender gender) {
        Member newMember = new Member(name, gender);
        mother.addChild(newMember);
        familyMembers.put(name, newMember);
        return familyMembers.get(name);
    }

    public Member get(String name) {
        return familyMembers.get(name);
    }
}
