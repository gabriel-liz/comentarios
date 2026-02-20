package com.avaliacomentarios.comentarios.domain.service;

import com.avaliacomentarios.comentarios.api.client.ModeracaoClient;
import com.avaliacomentarios.comentarios.api.model.ComentarioInput;
import com.avaliacomentarios.comentarios.api.model.ComentarioOutput;
import com.avaliacomentarios.comentarios.api.model.ModeracaoRequest;
import com.avaliacomentarios.comentarios.api.model.ModeracaoResponse;
import com.avaliacomentarios.comentarios.domain.exception.ComentarioNaoEncontradoException;
import com.avaliacomentarios.comentarios.domain.exception.RejeitadoPelaModeracaoException;
import com.avaliacomentarios.comentarios.domain.model.Comentario;
import com.avaliacomentarios.comentarios.domain.repository.ComentarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final ModeracaoClient moderacaoClient;

    public ComentarioOutput criarComentario(ComentarioInput input){
        Comentario comentario = Comentario.builder()
                .texto(input.getTexto())
                .autor(input.getAutor())
                .build();

        ModeracaoRequest request = new ModeracaoRequest(comentario.getId(), input.getTexto());
        ModeracaoResponse response = moderacaoClient.comentarioModeracao(request);

        if(!response.aprovado()){
            throw new RejeitadoPelaModeracaoException(response.getMotivo());
        }
        Comentario comentarioSalvo = comentarioRepository.saveAndFlush(comentario);
        return mapToOutput(comentarioSalvo);
    }

    public ComentarioOutput getComentarioById(UUID id){
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(ComentarioNaoEncontradoException::new);
        return mapToOutput(comentario);
    }

    public Page<ComentarioOutput> todosComentarios(Pageable pageable) {
        return comentarioRepository.findAll(pageable)
                .map(this::mapToOutput);
    }

    private ComentarioOutput mapToOutput(Comentario comentario) {
        return ComentarioOutput.builder()
                .id(comentario.getId())
                .texto(comentario.getTexto())
                .autor(comentario.getAutor())
                .dataCriacao(comentario.getDataCriacao())
                .build();
    }
}
