package tdd.ex2;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private int id;
    private String name;
    private int age;
    private List<Email> emails;
}