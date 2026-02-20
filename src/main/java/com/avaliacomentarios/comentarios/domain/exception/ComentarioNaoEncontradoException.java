package com.avaliacomentarios.comentarios.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ComentarioNaoEncontradoException extends RuntimeException {
}
