

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private static Map<Integer, Carro> carros = new HashMap<>();

    public static Carro getCarro(Integer codigo) {
        return carros.get(codigo);
    }

    public static void addCarro(Carro carro) {
        carros.put(carro.getCodigo(), carro);
    }
}