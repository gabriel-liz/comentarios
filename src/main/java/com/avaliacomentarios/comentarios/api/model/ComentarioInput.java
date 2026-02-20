package com.avaliacomentarios.comentarios.api.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComentarioInput {
    private String texto;
    private String autor;
}
