package com.example.family;
import java.util.TreeMap;

public class Family {

    private static final String PERSON_NOT_FOUND = "PERSON_NOT_FOUND";
    private static final String CHILD_ADDED = "CHILD_ADDITION_SUCCEEDED";
    private TreeMap<String, Member> familyMembers;

    public Family(TreeMap<String, Member> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public void addChildToFamily(String motherName, String name, Gender gender) {
        try {
            Member newMember = new Member(name, gender);
            Member mother = this.familyMembers.get(motherName);
            if(mother == null)
                throw new InvalidChildAdditionException(PERSON_NOT_FOUND);
            mother.addChild(newMember);
            this.familyMembers.put(name, newMember);
            System.out.println(CHILD_ADDED);
        }
        catch (InvalidChildAdditionException e) {
            System.out.println(e.getMessage());
        }
    }

    public Member get(String name) {
        return this.familyMembers.get(name);
    }

    public int getSize() {
        return this.familyMembers.size();
    }
}
