package br.com.fullstack.sujestoes.fachadas;


import br.com.fullstack.sujestoes.dto.ComentarioRequisicaoDto;
import br.com.fullstack.sujestoes.dto.ComentarioRespostaDto;
import br.com.fullstack.sujestoes.dto.SugestaoRequisicaoDto;
import br.com.fullstack.sujestoes.dto.SugestaoRespostaDto;
import br.com.fullstack.sujestoes.entidades.Comentario;
import br.com.fullstack.sujestoes.entidades.Sugestao;
import br.com.fullstack.sujestoes.servicos.ComentarioServico;
import br.com.fullstack.sujestoes.servicos.SugestaoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SugestaoFachadaImpl implements SugestaoFachada {

    private final SugestaoServico servico;
    private final ComentarioServico comentarioServico;

    @Override
    public SugestaoRespostaDto criar(SugestaoRequisicaoDto dto) {
        Sugestao sugestao = new Sugestao(dto);
        servico.salvar(sugestao);
        return new SugestaoRespostaDto(sugestao);
    }

    @Override
    public List<SugestaoRespostaDto> buscarTodos(String titulo) {
        return servico.buscarTodos(titulo).stream().map(SugestaoRespostaDto::new).toList();
    }

    @Override
    public SugestaoRespostaDto buscarPorId(Long id) {
        Sugestao sugestao = servico.buscarPorId(id);
        List<Comentario> comentarios = comentarioServico.buscarPorSugestaoId(id);
        return new SugestaoRespostaDto(sugestao, comentarios);
    }

    @Override
    public ComentarioRespostaDto criarComentario(Long id, ComentarioRequisicaoDto dto) {
        Sugestao sugestao = servico.buscarPorId(id);

        Comentario comentario = new Comentario(dto);
        comentario.setSugestao(sugestao);
        comentarioServico.criar(comentario);

        sugestao.setDataAtualizacao(LocalDateTime.now());
        servico.salvar(sugestao);

        return new ComentarioRespostaDto(comentario);
    }
}