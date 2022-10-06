package locadora.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluguel {
    private Veiculo veiculo;
    private LocalDateTime DataEmprestimo;
    private LocalDateTime DataDevolucao;
    private Double preço;
    private Boolean VeiculoAlugado;
    private List<CarroAluguel> itens = new ArrayList<>();
}
