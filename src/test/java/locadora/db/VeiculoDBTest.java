package locadora.db;

import locadora.model.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class VeiculoDBTest {
    private VeiculoDB veiculoDB = new VeiculoDB();

    @Test
    public void testCadastrarVeiculo() {
        Veiculo veiculo
                = new Veiculo("hatch", "fiat", "AAA2022", 1);
        Veiculo retorno = veiculoDB.cadastrarVeiculo(veiculo);

        Assertions.assertEquals("hatch", retorno.getModelo());
        Assertions.assertEquals("fiat", retorno.getMarca());
        Assertions.assertEquals("AAA2022", retorno.getPlaca());
        Assertions.assertEquals(1, retorno.getDisponivel());
    }

    @Test
    public void testListarVeiculos() {
        Veiculo veiculo
                = new Veiculo("hatch", "fiat", "AAA2022", 1);
        veiculoDB.cadastrarVeiculo(veiculo);

        List<Veiculo> retorno = veiculoDB.listarVeiculos();
        Assertions.assertTrue(retorno.size() > 0);
    }


    @Test
    public void testBuscarVeiculo() {
        Veiculo veiculo
                = new Veiculo("hatch", "fiat", "AAA2022", 1);
        veiculoDB.cadastrarVeiculo(veiculo);

        Veiculo retorno = veiculoDB.buscarVeiculo("AAA2022");
        Assertions.assertEquals("AAA2022", retorno.getPlaca());
        Assertions.assertEquals("hatch", retorno.getModelo());
        Assertions.assertEquals("fiat", retorno.getMarca());
        Assertions.assertEquals(1, retorno.getDisponivel());
    }

    @Test
    public void testBuscaVeiculoNaoExiste() {
        Veiculo retorno = veiculoDB.buscarVeiculo("ZZZ2000");
        Assertions.assertNull(retorno);
    }

}
