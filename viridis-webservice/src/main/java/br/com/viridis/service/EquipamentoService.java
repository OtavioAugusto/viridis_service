package br.com.viridis.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.viridis.entity.Equipamento;
import br.com.viridis.message.BaseResponse;
import br.com.viridis.message.CodeAndMessage;
import br.com.viridis.repository.EquipamentoRepository;
import br.com.viridis.security.AuthenticateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@EnableWebMvc
@RestController
@RequestMapping("/viridis/equipamentos")
public class EquipamentoService extends AuthenticateService{
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	@ApiOperation(value = "Listar todos os equipamentos", response = BaseResponse.class, notes = "Essa operação lista todos os registros existentes de equipamentos salvos no banco.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um BaseResponse com uma mensagem de sucesso", response = BaseResponse.class),
			@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um BaseResponse com a Exception", response = BaseResponse.class)

	})
	@GetMapping("/listar")
	public Object listar(HttpServletRequest request) {

		if (!this.authenticate(request)) {
			return new BaseResponse<>(CodeAndMessage.CODE_FAILURE_AUTHENTICATION, CodeAndMessage.FAILED_AUTHENTICATION, false);
		}

		try {
			
			List<Equipamento> equipamentos = equipamentoRepository.findAll();
			
			return new BaseResponse<>(CodeAndMessage.CODE_SUCCESS, CodeAndMessage.REGISTRY_SUCCESSFULLY_LISTED, true, equipamentos);
			
		} catch (Exception e) {
			return new BaseResponse<>(CodeAndMessage.CODE_FAILED, e.getMessage());
		}
		
	}
	
	@ApiOperation(value = "Consultar um equipamento através do seu id", response = BaseResponse.class, notes = "Essa operação faz uma busca do registro existente de um equipamento no banco utilizando o id como parâmetro.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um BaseResponse com uma mensagem de sucesso", response = BaseResponse.class),
			@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um BaseResponse com a Exception", response = BaseResponse.class)

	})
	@GetMapping("/buscar/{id}")
    public Object buscar(@PathVariable("id") Long id, HttpServletRequest request) {

        if (!this.authenticate(request)) {
            return new BaseResponse<>(CodeAndMessage.CODE_FAILURE_AUTHENTICATION, CodeAndMessage.FAILED_AUTHENTICATION);
        }

        try {
        	
        	Equipamento equipamento = equipamentoRepository.getOne(id);
        	
        	return new BaseResponse<>(CodeAndMessage.CODE_SUCCESS, CodeAndMessage.REGISTRY_SUCCESSFULLY_LOCATED, true, equipamento);
        	
        } catch (Exception e) {
        	return new BaseResponse<>(CodeAndMessage.CODE_FAILED, e.getMessage());
		}
        
	}

}
