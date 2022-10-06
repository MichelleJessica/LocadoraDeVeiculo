package locadora.db;

import locadora.model.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class AluguelDB {
    private static List<Aluguel> alugueis = new ArrayList<>();

    public Aluguel cadastrarAluguel (Aluguel aluguel) {
        alugueis.add(aluguel);
        return aluguel;
    }
}
