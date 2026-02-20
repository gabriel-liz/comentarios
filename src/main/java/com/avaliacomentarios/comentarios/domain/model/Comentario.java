package com.avaliacomentarios.comentarios.domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comentario {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();
    private String texto;
    private String autor;
    @Builder.Default
    private OffsetDateTime dataCriacao = OffsetDateTime.now();
}
