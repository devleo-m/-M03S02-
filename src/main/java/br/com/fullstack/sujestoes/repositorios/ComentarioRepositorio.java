package br.com.fullstack.sujestoes.repositorios;

import br.com.fullstack.sujestoes.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Long> {

    List<Comentario> findBySugestaoIdOrderByDataEnvioDesc(Long sugestaoId);

}
