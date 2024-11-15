package br.com.fullstack.sujestoes.dto;


import br.com.fullstack.sujestoes.entidades.Comentario;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@Schema(description = "Comentários - Objeto de resposta")
public class ComentarioRespostaDto {

    @Schema(description = "ID do comentário", example = "1")
    private Long id;

    @Schema(description = "Data que o comentário foi enviada")
    private LocalDateTime dataEnvio;

    @Schema(description = "Texto do comentário", example = "Realmente!")
    private String texto;

    public ComentarioRespostaDto(Comentario comentario) {
        BeanUtils.copyProperties(comentario, this);
    }
}