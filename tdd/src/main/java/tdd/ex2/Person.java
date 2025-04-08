package tdd.ex2;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Person {
    private int id;
    private String name;
    private int age;
    private List<Email> emails;
}