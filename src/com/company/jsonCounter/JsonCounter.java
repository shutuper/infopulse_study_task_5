package com.company.jsonCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JsonCounter {
    private ArrayList<String> readJSON(File jsonFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
            return (ArrayList<String>) reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int countElementsInJson(File jsonFile, TypeForCounting type) {
        if (type == TypeForCounting.ARRAY) {
            return counter(jsonFile, "[");
        } else if (type == TypeForCounting.OBJECT) {
            return counter(jsonFile, "{");
        } else throw new IllegalArgumentException("Type for counting can't be null!");

    }


    private int counter(File jsonFile, String toCount) {
        int result = toCount.equals("{") ? -1 : 0;
        String regex = "\\s*\".*\"\\s*:\\s*\\r\\s*".replace("r", toCount);
        Pattern pattern = Pattern.compile(regex);
        result += Objects.requireNonNull(readJSON(jsonFile)).stream().filter(x -> x.trim().equals(toCount) || pattern.matcher(x).matches()).count();
        return result;
    }


}
