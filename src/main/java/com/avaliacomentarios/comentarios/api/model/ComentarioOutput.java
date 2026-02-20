package com.avaliacomentarios.comentarios.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComentarioOutput {
    private UUID id;
    private String texto;
    private String autor;
    private OffsetDateTime dataCriacao;
}
