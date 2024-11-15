package br.com.fullstack.sujestoes.entidades;


import br.com.fullstack.sujestoes.dto.ComentarioRequisicaoDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataEnvio = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "sugestao_id", nullable = false)
    private Sugestao sugestao;

    @Column(nullable = false, length = 512)
    private String texto;

    public Comentario(ComentarioRequisicaoDto dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
