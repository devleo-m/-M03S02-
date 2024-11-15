package br.com.fullstack.sujestoes.repositorios;

import br.com.fullstack.sujestoes.entidades.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SugestaoRepositorio extends JpaRepository<Sugestao, Long> {

    List<Sugestao> findByOrderByDataAtualizacaoDesc();
    List<Sugestao> findByTituloContainingIgnoreCaseOrderByDataAtualizacaoDesc(String titulo);

}