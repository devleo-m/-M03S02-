package br.com.fullstack.sujestoes.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Sugestões - Objeto para criação")
public record SugestaoRequisicaoDto (

        @NotBlank
        @Schema(description = "Título da sugestão", example = "Satisfeito com a Empresa")
        String titulo,

        @Schema(description = "Descrição da sugestão", example = "A melhor empresa do mundo! MAASSSSS...")
        String descricao

){}