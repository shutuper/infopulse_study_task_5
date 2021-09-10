package com.company.jsonCounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class JsonCounterTest {

    @Test
    void countElementsInJson() {
        JsonCounter jsonCounter = new JsonCounter();
        Assertions.assertEquals(4, jsonCounter.countElementsInJson(new File("resources/example1.json"), TypeForCounting.OBJECT));
        Assertions.assertEquals(0, jsonCounter.countElementsInJson(new File("resources/example1.json"), TypeForCounting.ARRAY));
        Assertions.assertEquals(5, jsonCounter.countElementsInJson(new File("resources/example2.json"), TypeForCounting.OBJECT));
        Assertions.assertEquals(1, jsonCounter.countElementsInJson(new File("resources/example2.json"), TypeForCounting.ARRAY));
        Assertions.assertEquals(19, jsonCounter.countElementsInJson(new File("resources/example3.json"), TypeForCounting.OBJECT));
        Assertions.assertEquals(1, jsonCounter.countElementsInJson(new File("resources/example3.json"), TypeForCounting.ARRAY));
    }
}