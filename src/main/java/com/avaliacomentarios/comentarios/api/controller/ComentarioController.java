package com.avaliacomentarios.comentarios.api.controller;

import com.avaliacomentarios.comentarios.api.model.ComentarioInput;
import com.avaliacomentarios.comentarios.api.model.ComentarioOutput;
import com.avaliacomentarios.comentarios.domain.service.ComentarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/comentarios")
@RequiredArgsConstructor
public class ComentarioController {

    private final ComentarioService comentarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioOutput criarComentario(@RequestBody ComentarioInput input) {
        return comentarioService.criarComentario(input);
    }

    @GetMapping("{id}")
    public ComentarioOutput getComentarioById(@PathVariable String id) {
        return comentarioService.getComentarioById(UUID.fromString(id));
    }

    @GetMapping
    public Page<ComentarioOutput> todosComentarios(Pageable pageable){
        return comentarioService.todosComentarios(pageable);
    }
}
