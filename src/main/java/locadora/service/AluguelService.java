package locadora.service;

import locadora.db.AluguelDB;
import locadora.model.Aluguel;
import locadora.model.CarroAluguel;
import locadora.model.Veiculo;

import java.util.List;

public class AluguelService {
    private AluguelDB aluguelDB = new AluguelDB();
    private AluguelService aluguelService = new AluguelService();

    public Aluguel cadastrarAluguel(Veiculo veiculo, List<CarroAluguel> carro) {
        return null;
    }
}