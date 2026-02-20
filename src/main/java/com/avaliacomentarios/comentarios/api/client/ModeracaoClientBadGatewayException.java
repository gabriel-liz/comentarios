package com.avaliacomentarios.comentarios.api.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ModeracaoClientBadGatewayException extends RuntimeException {

}
