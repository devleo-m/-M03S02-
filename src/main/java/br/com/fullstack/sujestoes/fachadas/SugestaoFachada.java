package br.com.fullstack.sujestoes.fachadas;


import br.com.fullstack.sujestoes.dto.ComentarioRequisicaoDto;
import br.com.fullstack.sujestoes.dto.ComentarioRespostaDto;
import br.com.fullstack.sujestoes.dto.SugestaoRequisicaoDto;
import br.com.fullstack.sujestoes.dto.SugestaoRespostaDto;
import jakarta.validation.Valid;

import java.util.List;

public interface SugestaoFachada {
    SugestaoRespostaDto criar(SugestaoRequisicaoDto dto);

    List<SugestaoRespostaDto> buscarTodos(String titulo);

    SugestaoRespostaDto buscarPorId(Long id);

    ComentarioRespostaDto criarComentario(Long id, ComentarioRequisicaoDto dto);
}