package com.example.family;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Family {

    private HashMap<String, Member> familyMembers;

    public Family(HashMap<String, Member> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public void addChildToFamily(String mother, String name, Gender gender) {
        try {
            Member newMember = new Member(name, gender);
            this.familyMembers.get(mother).addChild(newMember);
            this.familyMembers.put(name, newMember);
        }
        catch (InvalidChildAdditionException e) {
            System.out.println(e.getMessage());
        }
    }

    public Set<Member> getRelationship(String name, String relation){
        Set<Member> relatives = new HashSet<>();
        return relatives;
    }

    public Member get(String name) {
        return this.familyMembers.get(name);
    }

    public int getSize() {
        return this.familyMembers.size();
    }
}
