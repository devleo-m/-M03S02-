package br.com.fullstack.sujestoes.servicos;

import br.com.fullstack.sujestoes.entidades.Comentario;

import java.util.List;

public interface ComentarioServico {
    Comentario criar(Comentario comentario);

    List<Comentario> buscarPorSugestaoId(Long sugestaoId);
}