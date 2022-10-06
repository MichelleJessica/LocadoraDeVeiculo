package locadora.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String modelo;
    private String marca;
    private String placa;
    private Integer disponivel;
}
