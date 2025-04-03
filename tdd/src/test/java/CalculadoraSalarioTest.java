import org.junit.jupiter.api.Test;
import tdd.ex3.CalculadoraSalario;
import tdd.ex3.Cargo;
import tdd.ex3.Funcionario;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraSalarioTest {
    private final CalculadoraSalario calculadora = new CalculadoraSalario();

    @Test
    void calcularSalarioLiquido_DesenvolvedorSalarioAlto_Desconto20() {
        Funcionario dev = new Funcionario();
        dev.setCargo(Cargo.DESENVOLVEDOR);
        dev.setSalarioBase(4000.0);

        assertEquals(3200.0, calculadora.calcularSalarioLiquido(dev));
    }

    @Test
    void calcularSalarioLiquido_DesenvolvedorSalarioBaixo_Desconto10() {
        Funcionario dev = new Funcionario();
        dev.setCargo(Cargo.DESENVOLVEDOR);
        dev.setSalarioBase(2000.0);

        assertEquals(1800.0, calculadora.calcularSalarioLiquido(dev));
    }

    @Test
    void calcularSalarioLiquido_DBA_SalarioAlto_Desconto25() {
        Funcionario dba = new Funcionario();
        dba.setCargo(Cargo.DBA);
        dba.setSalarioBase(3000.0);

        assertEquals(2250.0, calculadora.calcularSalarioLiquido(dba));
    }

    @Test
    void calcularSalarioLiquido_DBA_SalarioBaixo_Desconto15() {
        Funcionario dba = new Funcionario();
        dba.setCargo(Cargo.DBA);
        dba.setSalarioBase(1500.0);

        assertEquals(1275.0, calculadora.calcularSalarioLiquido(dba));
    }

    @Test
    void calcularSalarioLiquido_Testador_SalarioAlto_Desconto25() {
        Funcionario testador = new Funcionario();
        testador.setCargo(Cargo.TESTADOR);
        testador.setSalarioBase(2500.0);

        assertEquals(1875.0, calculadora.calcularSalarioLiquido(testador));
    }

    @Test
    void calcularSalarioLiquido_Testador_SalarioBaixo_Desconto15() {
        Funcionario testador = new Funcionario();
        testador.setCargo(Cargo.TESTADOR);
        testador.setSalarioBase(1800.0);

        assertEquals(1530.0, calculadora.calcularSalarioLiquido(testador));
    }

    @Test
    void calcularSalarioLiquido_Gerente_SalarioAlto_Desconto30() {
        Funcionario gerente = new Funcionario();
        gerente.setCargo(Cargo.GERENTE);
        gerente.setSalarioBase(6000.0);

        assertEquals(4200.0, calculadora.calcularSalarioLiquido(gerente));
    }

    @Test
    void calcularSalarioLiquido_Gerente_SalarioBaixo_Desconto20() {
        Funcionario gerente = new Funcionario();
        gerente.setCargo(Cargo.GERENTE);
        gerente.setSalarioBase(4000.0);

        assertEquals(3200.0, calculadora.calcularSalarioLiquido(gerente));
    }
}
