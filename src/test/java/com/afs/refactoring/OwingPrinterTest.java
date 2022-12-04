package com.afs.refactoring;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void should_print_owing_when_print_given_multiple_orders() {
        //given
        OwingPrinter owingPrinter = new OwingPrinter();

        //when
        owingPrinter.printOwing("Tom", Arrays.asList(new Order(100), new Order(200)));

        //then
        String expected = "*****************************" + System.lineSeparator() +
                "****** Customer totals ******" + System.lineSeparator() +
                "*****************************"  + System.lineSeparator() +
                "name: Tom" + System.lineSeparator() +
                "amount: 300" + System.lineSeparator();

        assertEquals(expected, outContent.toString());
    }
}
