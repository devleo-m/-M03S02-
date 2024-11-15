package br.com.fullstack.sujestoes.servicos;

import br.com.fullstack.sujestoes.configs.excecoes.NaoEncontradoExcecao;
import br.com.fullstack.sujestoes.entidades.Sugestao;
import br.com.fullstack.sujestoes.repositorios.SugestaoRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class SugestaoSercicoImpl implements SugestaoServico {

    private final SugestaoRepositorio repositorio;

    @Override
    public Sugestao salvar(Sugestao sugestao) {
        log.info("salva nova sugestao");
        return repositorio.save(sugestao);
    }

    @Override
    public List<Sugestao> buscarTodos(String titulo) {
        log.info("busca sugestao pelo titulo");
        if (StringUtils.isBlank(titulo)) {
            titulo = "";
        }
        return repositorio.findByTituloContainingIgnoreCaseOrderByDataAtualizacaoDesc(titulo);
    }

    @Override
    public Sugestao buscarPorId(Long id) {
        log.info("busca sugestao pelo id");
        return repositorio.findById(id).orElseThrow(
                () -> new NaoEncontradoExcecao("Sugestão não encontrada com ID: " + id)
        );
    }
}