package com.example.family;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FunctionHandlerTest {

    private final Family family = new Family(PopulateFamily.populateFamily());
    private final FunctionHandler functionHandler = new FunctionHandler(family);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void executeShouldPrintPersonNotFoundIfPersonNotExist() {
        String input = "ADD_CHILD Pjali Srutak Male";

        functionHandler.execute(input);

        assertEquals("PERSON_NOT_FOUND\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintChildAdditionSucceededOnSuccess() {
        String input = "ADD_CHILD Satvy Srutak Male";

        functionHandler.execute(input);

        assertEquals("CHILD_ADDITION_SUCCEEDED\n", outContent.toString());
        assertEquals("Satvy", family.get("Srutak").getMother().getName());
    }

    @Test
    public void executeShouldPrintNoneIfNoSonExist() {
        String input = "GET_RELATIONSHIP Yodhan Son";

        functionHandler.execute(input);

        assertEquals("NONE\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNamesIfDaughterExist() {
        String input = "GET_RELATIONSHIP Vyan Son";

        functionHandler.execute(input);

        List<String> siblings = Arrays.asList(outContent.toString().split("\\s+"));
        assertEquals(siblings.get(0), "Asva");
        assertEquals(siblings.get(1), "Vyas");
    }

    @Test
    public void executeShouldPrintNoneIfNoDaughterExist() {
        String input = "GET_RELATIONSHIP Yodhan Daughter";

        functionHandler.execute(input);

        assertEquals("NONE\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNamesIfSonsExist() {
        String input = "GET_RELATIONSHIP Satya Daughter";

        functionHandler.execute(input);

        assertEquals("Atya\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNoneIfNoSiblingsExist() {
        String input = "GET_RELATIONSHIP Vasa Siblings";

        functionHandler.execute(input);

        assertEquals("NONE\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNamesIfSiblingsExist() {
        String input = "GET_RELATIONSHIP Chit Siblings";

        functionHandler.execute(input);

        List<String> siblings = Arrays.asList(outContent.toString().split("\\s+"));
        assertEquals(siblings.get(0), "Ish");
        assertEquals(siblings.get(1), "Vich");
        assertEquals(siblings.get(2), "Aras");
        assertEquals(siblings.get(3), "Satya");
    }

    @Test
    public void executeShouldPrintNoneIfNoPaternalUncleExist() {
        String input = "GET_RELATIONSHIP Ish Paternal-Uncle";

        functionHandler.execute(input);

        assertEquals("NONE\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNameIfPaternalUncleExist() {
        String input = "GET_RELATIONSHIP Vasa Paternal-Uncle";

        functionHandler.execute(input);

        assertEquals("Vyas\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNoneIfNoPaternalAuntExist() {
        String input = "GET_RELATIONSHIP Ish Paternal-Aunt";

        functionHandler.execute(input);

        assertEquals("NONE\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNameIfPaternalAuntExist() {
        String input = "GET_RELATIONSHIP Vasa Paternal-Aunt";

        functionHandler.execute(input);

        assertEquals("Atya\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNoneIfNoMaternalUncleExist() {
        String input = "GET_RELATIONSHIP Ish Maternal-Uncle";

        functionHandler.execute(input);

        assertEquals("NONE\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNameIfMaternalUncleExist() {
        String input = "GET_RELATIONSHIP Yodhan Maternal-Uncle";

        functionHandler.execute(input);

        assertEquals("Vritha\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNoneIfNoMaternalAuntExist() {
        String input = "GET_RELATIONSHIP Ish Maternal-Aunt";

        functionHandler.execute(input);

        assertEquals("NONE\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNameIfMaternalAuntExist() {
        String input = "GET_RELATIONSHIP Yodhan Maternal-Aunt";

        functionHandler.execute(input);

        assertEquals("Tritha\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNoneIfNoSisterInLawExist() {
        String input = "GET_RELATIONSHIP Lavnya Sister-In-Law";

        functionHandler.execute(input);

        assertEquals("NONE\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNameIfSisterInLawExist() {
        String input = "GET_RELATIONSHIP Ish Sister-In-Law";

        functionHandler.execute(input);

        List<String> sisterInLaws = Arrays.asList(outContent.toString().split("\\s+"));
        assertEquals(sisterInLaws.get(0), "Amba");
        assertEquals(sisterInLaws.get(1), "Lika");
        assertEquals(sisterInLaws.get(2), "Chitra");
    }

    @Test
    public void executeShouldPrintNoneIfNoBrotherInLawExist() {
        String input = "GET_RELATIONSHIP Vasa Brother-In-Law";

        functionHandler.execute(input);

        assertEquals("NONE\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintNameIfBrotherInLawExist() {
        String input = "GET_RELATIONSHIP Krpi Brother-In-Law";

        functionHandler.execute(input);

        assertEquals("Asva\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintInvalidInputIfWrongInputGiven() {
        String input = "BREAK_RELATIONSHIP Krpi Brother-In-Law";

        functionHandler.execute(input);

        assertEquals("INVALID INPUT\n", outContent.toString());
    }

    @Test
    public void executeShouldPrintInvalidInputIfWrongRelationIsGiven() {
        String input = "GET_RELATIONSHIP Krpi Brother-In-Law-School";

        functionHandler.execute(input);

        assertEquals("INVALID INPUT\n", outContent.toString());
    }
}