package tdd.ex3;

import lombok.Data;

@Data
public class Funcionario {
    private String nome;
    private String email;
    private double salarioBase;
    private Cargo cargo;
}