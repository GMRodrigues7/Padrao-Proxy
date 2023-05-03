

import java.util.List;

public class CarroProxy implements ICarro {

    private Carro carro;

    private Integer codigo;

    public CarroProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> receberDadosCarro() {
        if (this.carro == null) {
            this.carro = new Carro(this.codigo);
        }
        return this.carro.receberDadosCarro();
    }

    @Override
    public List<Float> receberValor(Funcionario funcionario) {
        if (!funcionario.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.carro == null) {
            this.carro = new Carro(this.codigo);
        }
        return this.carro.receberValor(funcionario);
    }
}