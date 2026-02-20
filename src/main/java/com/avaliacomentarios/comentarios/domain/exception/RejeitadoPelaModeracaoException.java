package com.avaliacomentarios.comentarios.domain.exception;

public class RejeitadoPelaModeracaoException extends  RuntimeException{
    public RejeitadoPelaModeracaoException(String mensagem){
        super(mensagem);
    }
}
