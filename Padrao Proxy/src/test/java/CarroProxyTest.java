

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CarroProxyTest {

    @BeforeEach
    void setUp() {
        DataBase.addCarro(new Carro(001, "Lancer", "Mitsubishi", 80000.0f));
        DataBase.addCarro(new Carro(002, "Jetta", "Volkswagen", 50000.0f));
    }

    @Test
    void retornaDadosCarro() {
        CarroProxy carro = new CarroProxy(001);

        assertEquals(Arrays.asList("Lancer", "Mitsubishi"), carro.receberDadosCarro());
    }

    @Test
    void retornaValorCarro() {
        Funcionario funcionario = new Funcionario("Natan", true);
        CarroProxy carro = new CarroProxy(002);

        assertEquals(Arrays.asList(50000.0f), carro.receberValor(funcionario));
    }

    @Test
    void retornaUserNaoAutorizado() {
        try {
            Funcionario funcionario = new Funcionario("Phellipe", false);
            CarroProxy carro = new CarroProxy(002);

            carro.receberValor(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}