package br.com.viridis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.viridis.service.EquipamentoService;

public class EquipamentoServiceTest extends ViridisWebserviceApplicationTests{
	
	private MockMvc mockMvc;
	private MockHttpServletRequest request;
	
	@Autowired
	private EquipamentoService equipamentoService;
	
	@Before
	public void setUp(){
		request = new MockHttpServletRequest();
		this.mockMvc = MockMvcBuilders.standaloneSetup(equipamentoService).build();
	}
	
	
	@Test
	public void listarEquipamentosTest() throws Exception{
		request.addParameter("hash-autenticacao-viridis", "da39a3ee5e6b4b0d3255bfef95601890afd80709");
		this.mockMvc.perform(MockMvcRequestBuilders.get("/viridis/equipamentos/listar", request)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void buscarEquipamentosPorIdTest() throws Exception{
		request.addParameter("hash-autenticacao-viridis", "da39a3ee5e6b4b0d3255bfef95601890afd80709");
		this.mockMvc.perform(MockMvcRequestBuilders.get("/viridis/equipamentos/buscar/{id}", 1, request)).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
