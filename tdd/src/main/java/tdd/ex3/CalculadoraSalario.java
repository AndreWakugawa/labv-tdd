package tdd.ex3;

public class CalculadoraSalario {
    public double calcularSalarioLiquido(Funcionario funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        Cargo cargo = funcionario.getCargo();

        if (cargo == null) {
            throw new IllegalArgumentException("Cargo não pode ser nulo");
        }

        return switch (cargo) {
            case DESENVOLVEDOR -> salarioBase >= 3000 ? salarioBase * 0.8 : salarioBase * 0.9;
            case DBA, TESTADOR -> salarioBase >= 2000 ? salarioBase * 0.75 : salarioBase * 0.85;
            case GERENTE -> salarioBase >= 5000 ? salarioBase * 0.7 : salarioBase * 0.8;
        };
    }
}
