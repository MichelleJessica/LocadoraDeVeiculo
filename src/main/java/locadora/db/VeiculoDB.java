package locadora.db;

import locadora.model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoDB {
    private static List<Veiculo> veiculos = new ArrayList<>();

    public Veiculo cadastrarVeiculo (Veiculo veiculo) {
        veiculos.add(veiculo);
        return veiculo;
    }

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public static Veiculo buscarVeiculo(String placa) {
        Optional<Veiculo> optional = veiculos
                .stream()
                .filter(candidato -> candidato.getPlaca().equals(placa))
                .findFirst();

        return optional.orElse(null);
    }
}
