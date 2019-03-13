package com.example.family;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Family {
    private HashMap<String, Member> familyMembers;

    public Family(HashMap<String, Member> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public void addChild(Member mother, String name, Gender gender) {
        Member newMember = new Member(name, gender);
        mother.addChild(newMember);
        familyMembers.put(name, newMember);
    }

    public Set<Member> getRelationship(String name, String relation){
        Set<Member> relatives = new HashSet<>();
        return relatives;
    }

    public Member get(String name) {
        return familyMembers.get(name);
    }
}
