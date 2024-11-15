package br.com.fullstack.sujestoes.servicos;

import br.com.fullstack.sujestoes.entidades.Sugestao;

import java.util.List;

public interface SugestaoServico {
    Sugestao salvar(Sugestao sugestao);

    List<Sugestao> buscarTodos(String titulo);

    Sugestao buscarPorId(Long id);
}