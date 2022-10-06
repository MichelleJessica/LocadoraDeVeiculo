package locadora.service;

import locadora.db.VeiculoDB;
import locadora.model.Veiculo;

import java.util.List;

public class VeiculoService {
    private VeiculoDB veiculoDB = new VeiculoDB();

    public Veiculo cadastrarVeiculo(String modelo, String marca, String placa, Integer disponivel) {

        if (modelo == null || modelo.isEmpty()) {
            return null;
        }
        if (marca == null || marca.isEmpty()) {
            return null;
        }
        if (placa == null || placa.isEmpty()) {
            return null;
        }
        if (disponivel == null || disponivel < 0 || disponivel > 1) {
            return null;
        }
        Veiculo veiculo = new Veiculo(modelo, marca, placa, disponivel);
        return veiculoDB.cadastrarVeiculo(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoDB.listarVeiculos();
    }

    public Veiculo buscarVeiculo(String placa) {
        return VeiculoDB.buscarVeiculo(placa);
    }

    public Veiculo veiculoDisponivel() {
        List<Veiculo> veiculos = veiculoDB.listarVeiculos();
        return veiculos
                .stream()
                .sorted((c1, c2) -> c2.getPlaca().compareTo(c1.getPlaca()))
                .findFirst()
                .get();
    }

}
