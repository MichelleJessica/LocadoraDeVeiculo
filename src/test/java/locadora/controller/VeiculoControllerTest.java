package locadora.controller;

import locadora.model.Veiculo;
import locadora.service.VeiculoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class VeiculoControllerTest {

    @InjectMocks
    private VeiculoController veiculoController;

    @Mock
    private VeiculoService veiculoService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(veiculoController).build();
    }

    @Test
    public void testListarVeiculos() throws Exception {
        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(new Veiculo("hatch", "fiat", "AAA2022",1));
        veiculos.add(new Veiculo("sedan", "chevrolet", "ABC2022", 1));

        Mockito.when(veiculoService.listarVeiculos()).thenReturn(veiculos);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/veiculo"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals("[{\"modelo\":\"hatch\",\"marca\":\"fiat\",\"placa\":\"AAA2022\",\"disponivel\":1}," +
                "{\"modelo\":\"sedan\",\"marca\":\"chevrolet\",\"placa\":\"ABC2022\",\"disponivel\":1}]", resposta);
    }

    @Test
    public void testCadastrarVeiculo() throws Exception {

        String content = "{" +
                "\"modelo\":\"hatch\"," +
                "\"marca\":\"hyundai\"," +
                "\"placa\":\"DEF2022\"," +
                "\"disponivel\":1" +
                "}";

        Veiculo veiculo = new Veiculo("hatch", "hyundai", "DEF2022", 1);
        Mockito
                .when(veiculoService.cadastrarVeiculo("hatch", "hyundai", "DEF2022", 1))
                .thenReturn(veiculo);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/veiculo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals(content, resposta);
    }

    @Test
    public void testCadastrarVeiculoErro() throws Exception {

        String content = "{" +
                "\"modelo\":\"sedan\"," +
                "\"marca\":fiat," +
                "\"placa\":\"BBB2022\"," +
                "\"disponivel\":1" +
                "}";

        Mockito
                .when(veiculoService.cadastrarVeiculo(null, "fiat", null, 1))
                .thenReturn(null);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/veiculo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resposta = result.getResponse().getContentAsString();
        Assertions.assertEquals("", resposta);

    }
}
