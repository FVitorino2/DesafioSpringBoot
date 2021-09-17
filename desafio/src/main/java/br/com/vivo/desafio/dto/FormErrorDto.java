package br.com.vivo.desafio.dto;


public class FormErrorDto {
	
	private int status_code;
	private String message;
	private String campo;
	
	public FormErrorDto(int status_code, String message, String campo) {
		this.status_code = status_code;
		this.message = message;
		this.campo = campo;
		
	}

	public int getStatus_code() {
		return status_code;
	}

	public String getMessage() {
		return message;
	}

	public String getCampo() {
		return campo;
	}
	

}
