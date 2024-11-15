package br.com.fullstack.sujestoes.servicos;


import br.com.fullstack.sujestoes.entidades.Comentario;
import br.com.fullstack.sujestoes.repositorios.ComentarioRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ComentarioSercicoImpl implements ComentarioServico {

    private final ComentarioRepositorio repositorio;

    @Override
    public Comentario criar(Comentario comentario) {
        log.info("Salva novo comentario");
        return repositorio.save(comentario);
    }

    @Override
    public List<Comentario> buscarPorSugestaoId(Long sugestaoId) {
        log.info("busca comentario por id");
        return repositorio.findBySugestaoIdOrderByDataEnvioDesc(sugestaoId);
    }
}