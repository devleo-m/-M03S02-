package br.com.fullstack.sujestoes.entidades;


import br.com.fullstack.sujestoes.dto.SugestaoRequisicaoDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sugestoes")
public class Sugestao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataEnvio = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    @Column(nullable = false)
    private String titulo;

    @Column(length = 512)
    private String descricao;

    public Sugestao(SugestaoRequisicaoDto dto) {
        BeanUtils.copyProperties(dto, this);
    }
}
