package com.company.validator;

import java.lang.reflect.Field;

public class Validator<T> {

    public boolean validate(T t) throws IllegalAccessException {
        Class<T> currentClass = (Class<T>) t.getClass();
        for (Field field : currentClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Min.class) && (field.getAnnotation(Min.class).value() > (int) field.get(t))) {
                return false;
            } else if (field.isAnnotationPresent(AssertTrue.class) && !((boolean) field.get(t))) return false;
        }
        return true;
    }

}
