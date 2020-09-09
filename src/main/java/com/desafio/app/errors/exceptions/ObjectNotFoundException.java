package com.desafio.app.errors.exceptions;

import java.util.HashMap;
import java.util.Map;


public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<>();

    public static final String FATOR_CALCULO_NAO_ENCONTRADO = "MSG-FATOR-CALCULO-NAO-ENCONTRADO";
    public static final String CONTAS_NAO_ENCONTRADAS = "MSG-CONTAS-NAO-ENCONTRADAS";
    public static final String CONTA_NAO_ENCONTRADA = "MSG-CONTA-NAO-ENCONTRADA";

    public ObjectNotFoundException(String msg) {
		super(msg);
	}

	public ObjectNotFoundException(String msg, Map<String, Object> map){
		this(msg);
		this.map = map;
	}

	public ObjectNotFoundException(String msg, Throwable cause){
		super(msg, cause);
	}

	public Map<String, Object> getMap(){
		return map;
	}
}