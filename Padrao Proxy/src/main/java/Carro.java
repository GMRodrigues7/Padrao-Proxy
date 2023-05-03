

import java.util.Arrays;
import java.util.List;

public class Carro implements ICarro {

    private Integer codigo;
    private String modelo;
    private String marca;
    private Float valor;


    public Carro(int codigo) {
        this.codigo = codigo;
        Carro objeto = DataBase.getCarro(codigo);
        this.modelo = objeto.modelo;
        this.marca = objeto.marca;
        this.valor = objeto.valor;

    }

    public Carro(Integer codigo, String modelo, String marca, Float valor ) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca = marca;
        this.valor = valor;

    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> receberDadosCarro() {
        return Arrays.asList(this.modelo, this.marca);
    }

    @Override
    public List<Float> receberValor(Funcionario funcionario) {
        return Arrays.asList(this.valor);
    }
}