package br.com.fullstack.sujestoes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Comentários - Objeto para criação")
public record ComentarioRequisicaoDto(

        @NotBlank
        @Schema(description = "Texto do comentário", example = "Muito errado!!!")
        String texto

){}