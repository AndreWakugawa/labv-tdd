package tdd.ex3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Funcionario {
    private String nome;
    private String email;
    private double salarioBase;
    private Cargo cargo;
}