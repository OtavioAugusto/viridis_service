package br.com.viridis.service;

import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.viridis.entity.Manutencao;
import br.com.viridis.message.BaseResponse;
import br.com.viridis.message.CodeAndMessage;
import br.com.viridis.repository.ManutencaoRepository;
import br.com.viridis.security.AuthenticateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/viridis/manutencao")
public class ManutencaoService extends AuthenticateService{
	
	@Autowired
	private ManutencaoRepository manutencaoRepository;
	
	@ApiOperation(value = "Cadastrar uma nova ordem de manutenção", response = BaseResponse.class, notes = "Essa operação salva um novo registro com as informações de ordem de manutenção.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um BaseResponse com uma mensagem de sucesso", response = BaseResponse.class),
			@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um BaseResponse com a Exception", response = BaseResponse.class)

	})
	@PostMapping("/salvar")
	public BaseResponse<Manutencao> salvar(@RequestBody Manutencao entity, HttpServletRequest request){
		
		if (!this.authenticate(request)) {
            return new BaseResponse<>(CodeAndMessage.CODE_FAILURE_AUTHENTICATION, CodeAndMessage.FAILED_AUTHENTICATION);
        }

		try {
			
			this.manutencaoRepository.saveAndFlush(entity);
			
			return new BaseResponse<>(CodeAndMessage.CODE_SUCCESS, CodeAndMessage.REGISTRY_SUCCESSFULLY_SAVED, true);
			
		} catch (Exception e) {
			return new BaseResponse<>(CodeAndMessage.CODE_FAILED, e.getMessage());
		}
	}
	
	
	@ApiOperation(value = "Alterar uma ordem de manutenção existente", response = BaseResponse.class, notes = "Essa operação altera um registro existente com as informações de ordem de manutenção.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um BaseResponse com uma mensagem de sucesso", response = BaseResponse.class),
			@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um BaseResponse com a Exception", response = BaseResponse.class)

	})
	@PutMapping("/alterar")
	public BaseResponse<Manutencao> alterar(@RequestBody Manutencao entity, HttpServletRequest request){
		
		if (!this.authenticate(request)) {
            return new BaseResponse<>(CodeAndMessage.CODE_FAILURE_AUTHENTICATION, CodeAndMessage.FAILED_AUTHENTICATION);
        }

		try {
			
			this.manutencaoRepository.saveAndFlush(entity);
			
			return new BaseResponse<>(CodeAndMessage.CODE_SUCCESS, CodeAndMessage.REGISTRY_SUCCESSFULLY_UPDATED, true);
			
		} catch (Exception e) {
			return new BaseResponse<>(CodeAndMessage.CODE_FAILED, e.getMessage());
		}
	}
	
	
	@ApiOperation(value = "Listar todos os manutencaos", response = BaseResponse.class, notes = "Essa operação lista todos os registros existentes de manutencaos salvos no banco.")
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
			
			List<Manutencao> manutencoes = manutencaoRepository.findAll();

			return new BaseResponse<>(CodeAndMessage.CODE_SUCCESS, CodeAndMessage.REGISTRY_SUCCESSFULLY_LISTED, true, manutencoes);
			
		} catch (Exception e) {
			return new BaseResponse<>(CodeAndMessage.CODE_FAILED, e.getMessage());
		}
		
	}
	
	
	@ApiOperation(value = "Consultar um manutencao através do seu id", response = BaseResponse.class, notes = "Essa operação faz uma busca do registro existente de um manutencao no banco utilizando o id como parâmetro.")
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
        	
        	Manutencao manutencao = manutencaoRepository.getOne(id);
        	
        	return new BaseResponse<>(CodeAndMessage.CODE_SUCCESS, CodeAndMessage.REGISTRY_SUCCESSFULLY_LOCATED, true, manutencao);
        	
        } catch (Exception e) {
        	return new BaseResponse<>(CodeAndMessage.CODE_FAILED, e.getMessage());
		}
        
	}

}
