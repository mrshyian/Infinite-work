package com.rekrutacja.infinite;

import com.rekrutacja.infinite.firstTask.FirstTask;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SecondTask {

    @Test
    void simpleTestsWithPlusAtTheAnd() {
        assertEquals(FirstTask.StringScanner("33;44;11.14,22+"), 124);
    }

    @Test
    void simpleTestWithMinusAtTheAnd() {
        assertEquals(FirstTask.StringScanner("33;44;11.14,22-"), -58);
    }

    @Test
    void simpleTestWithoutMinusOrPlusAtTheAnd() {
        assertEquals(FirstTask.StringScanner("33;44;11.14,22"), 0);
    }

    @Test
    void simpleTestWhenStringIsNull() {
        assertEquals(FirstTask.StringScanner(null), 0);
    }

    @Test
    void simpleTestWhenStringIsEmpty() {
        assertEquals(FirstTask.StringScanner(""), 0);
    }

    @Test
    void simpleTestWhenStringHasTheNumbersWithWhiteSpaces() {
        assertEquals(FirstTask.StringScanner("  33;44  ; 11 .14,22+"), 124);
    }

    @Test
    void simpleTestWhenStringStartWithSeparator() {
        assertEquals(FirstTask.StringScanner(";;,144;11.14,22+"), 191);
    }

}