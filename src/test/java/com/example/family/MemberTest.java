package com.example.family;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MemberTest {


    @Test
    public void setSpouseShouldSetMemberAsSpouseOfEachOther() {
        Member chit = new Member("Chit", Gender.MALE);
        Member amba = new Member("Amba", Gender.FEMALE);

        chit.setSpouse(amba);

        assertEquals(chit.getSpouse(), amba);
        assertEquals(amba.getSpouse(), chit);
    }

    @Test
    public void addChildShouldAddChildToMother() {
        Member chit = new Member("Chit", Gender.MALE);
        Member amba = new Member("Amba", Gender.FEMALE);
        amba.setSpouse(chit);
        Member dritha = new Member("Dritha", Gender.FEMALE);
        Member manu = new Member("Manu", Gender.MALE);

        amba.addChild(dritha);
        amba.addChild(manu);

        Set<Member> children = amba.getChildren();
        assertTrue(children.contains(dritha));
        assertTrue(children.contains(manu));
        assertEquals(2, children.size());
    }

    @Test(expected = InvalidChildAdditionException.class)
    public void addChildShouldThrowWrongAdditionExceptionWhileAddingChildToFather() {
        Member chit = new Member("Chit", Gender.MALE);
        Member amba = new Member("Amba", Gender.FEMALE);
        amba.setSpouse(chit);
        Member dritha = new Member("Dritha", Gender.FEMALE);

        chit.addChild(dritha);
    }
}