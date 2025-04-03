package tdd.ex3;

public class CalculadoraSalario {
    public double calcularSalarioLiquido(Funcionario funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        Cargo cargo = funcionario.getCargo();

        switch (cargo) {
            case DESENVOLVEDOR:
                return salarioBase >= 3000 ? salarioBase * 0.8 : salarioBase * 0.9;
            case DBA:
            case TESTADOR:
                return salarioBase >= 2000 ? salarioBase * 0.75 : salarioBase * 0.85;
            case GERENTE:
                return salarioBase >= 5000 ? salarioBase * 0.7 : salarioBase * 0.8;
            default:
                throw new IllegalArgumentException("Cargo inválido");
        }
    }
}
