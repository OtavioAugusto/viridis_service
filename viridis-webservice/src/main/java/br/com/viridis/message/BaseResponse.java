package br.com.viridis.message;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponse<S> {
	
	private String code;

	private String mensagem;

	private boolean sucesso;

	private Object entidade;
	
	public BaseResponse(String code, String mensagem) {
		this.code = code;
		this.mensagem = mensagem;
	}
	
	public BaseResponse(String code, String mensagem, String value) {
		this.code = code;
		this.mensagem = mensagem;
	}

	public BaseResponse(String code, String mensagem, boolean sucesso) {
		this.code = code;
		this.mensagem = mensagem;
		this.sucesso = sucesso;
	}

	public BaseResponse(String code, String mensagem, boolean sucesso, Object objeto) {
		this.code = code;
		this.mensagem = mensagem;
		this.sucesso = sucesso;
		this.entidade = objeto;
	}

	public BaseResponse(String code, String mensagem, S sucesso) {
		this.code = code;
		this.mensagem = mensagem;
	}

}
