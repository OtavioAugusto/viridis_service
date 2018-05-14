package br.com.viridis;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.viridis.entity.Equipamento;
import br.com.viridis.entity.Manutencao;
import br.com.viridis.entity.Servico;
import br.com.viridis.message.BaseResponse;
import br.com.viridis.service.ManutencaoService;

public class ManutencaoServiceTest extends ViridisWebserviceApplicationTests {

	private MockMvc mockMvc;
	private MockHttpServletRequest request;

	@Autowired
	private ManutencaoService manutencaoService;

	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		this.mockMvc = MockMvcBuilders.standaloneSetup(manutencaoService).build();
	}

	@Test
	public void salvarManutencaoTest() throws Exception {

		Equipamento equipamento = new Equipamento();
		equipamento.setIdEquipamento(1L);
		
		Servico servico = new Servico();
		servico.setIdServico(2L);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse("23/11/2015");
		
		Manutencao manutencao = new Manutencao();
		manutencao.setDataManutencao(data);
		manutencao.setEquipamento(equipamento);
		manutencao.setServico(servico);
		
		BaseResponse<Manutencao> manutResul = new BaseResponse<Manutencao>();
		
		request.addParameter("hash-autenticacao-viridis", "da39a3ee5e6b4b0d3255bfef95601890afd80709");
		ManutencaoService mock = org.mockito.Mockito.mock(ManutencaoService.class);
		when(mock.salvar(manutencao, request)).thenReturn(manutResul);

	}
	
	@Test
	public void alterarManutencaoTest() throws Exception {

		Equipamento equipamento = new Equipamento();
		equipamento.setIdEquipamento(1L);
		
		Servico servico = new Servico();
		servico.setIdServico(2L);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse("23/11/2015");
		
		Manutencao manutencao = new Manutencao();
		manutencao.setDataManutencao(data);
		manutencao.setEquipamento(equipamento);
		manutencao.setServico(servico);
		
		BaseResponse<Manutencao> manutResul = new BaseResponse<Manutencao>();
		
		request.addParameter("hash-autenticacao-viridis", "da39a3ee5e6b4b0d3255bfef95601890afd80709");
		ManutencaoService mock = org.mockito.Mockito.mock(ManutencaoService.class);
		when(mock.alterar(manutencao, request)).thenReturn(manutResul);

	}

	@Test
	public void listarManutencoesTest() throws Exception {
		request.addParameter("hash-autenticacao-viridis", "da39a3ee5e6b4b0d3255bfef95601890afd80709");
		this.mockMvc.perform(get("/viridis/manutencao/listar", request)).andExpect(status().isOk());
	}

	@Test
	public void buscarManutencoesPorIdTest() throws Exception {
		request.addParameter("hash-autenticacao-viridis", "da39a3ee5e6b4b0d3255bfef95601890afd80709");
		this.mockMvc.perform(get("/viridis/manutencao/buscar/{id}", 1, request)).andExpect(status().isOk());
	}

}
