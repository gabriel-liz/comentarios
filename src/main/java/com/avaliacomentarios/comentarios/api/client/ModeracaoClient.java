package com.avaliacomentarios.comentarios.api.client;

import com.avaliacomentarios.comentarios.api.model.ModeracaoRequest;
import com.avaliacomentarios.comentarios.api.model.ModeracaoResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface ModeracaoClient {
    @PostExchange("/api/moderacao")
    ModeracaoResponse comentarioModeracao(@RequestBody ModeracaoRequest request);
}
