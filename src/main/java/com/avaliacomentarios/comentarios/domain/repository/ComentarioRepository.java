package com.avaliacomentarios.comentarios.domain.repository;

import com.avaliacomentarios.comentarios.domain.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComentarioRepository extends JpaRepository<Comentario, UUID> {
}
