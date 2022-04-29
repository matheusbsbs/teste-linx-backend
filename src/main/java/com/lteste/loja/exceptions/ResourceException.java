package com.lteste.loja.exceptions;

public class ResourceException  extends RuntimeException{

    private static final long serialVersionUID=1L;

    public ResourceException(Object id){
        super("Não encontrado.Id"+id);
    }
}
