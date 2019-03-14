package com.example.family;

import java.util.HashSet;
import java.util.Set;

public class Member {
    public static final String CHILD_NOT_ADDED = "CHILD_ADDITION_FAILED";
    private static Member unknown = new Member("Unknown");
    private String name;
    private Gender gender;
    private Member mother;
    private Member father;
    private Member spouse;
    private Set<Member> children = new HashSet<>();

    private Member(String name) {
        this.name = name;
    }

    public Member(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.mother = unknown;
        this.father = unknown;
        this.spouse = unknown;
    }

    public String getName() {
        return this.name;
    }


    public Gender getGender() {
        return this.gender;
    }

    public Member getMother() {
        return this.mother;
    }

    public Member getFather() {
        return this.father;
    }

    public Member getSpouse() {
        return this.spouse;
    }

    public void setSpouse(Member member) {
        this.spouse = member;
        member.spouse = this;
    }

    public void addChild(Member member) {
        if (this.gender == Gender.FEMALE) {
            this.children.add(member);
            this.spouse.children.add(member);
            member.mother = this;
            member.father = this.spouse;
        }
        else {
            throw new InvalidChildAdditionException(CHILD_NOT_ADDED);
        }
    }

    public Set<Member> getChildren() {
        return children;
    }
}
