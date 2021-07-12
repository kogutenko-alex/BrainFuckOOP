package ua.kogutenko.testsBrainfuck.testAnalyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.kogutenko.Brainfuck.analizator.Analyzer;

class AnalyzerTest {

    @Test
    void isValidBrackets() {
        Assertions.assertEquals(true, Analyzer.isValidBrackets("[[][[]]]"));
    }

    @Test
    void findClosedBracket() {
        Assertions.assertEquals(10, Analyzer.findClosedBracket("--[--[-]+<]>---", 3));
    }
}