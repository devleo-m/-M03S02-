package br.com.fullstack.sujestoes.controladores;


import br.com.fullstack.sujestoes.dto.ComentarioRequisicaoDto;
import br.com.fullstack.sujestoes.dto.ComentarioRespostaDto;
import br.com.fullstack.sujestoes.dto.SugestaoRequisicaoDto;
import br.com.fullstack.sujestoes.dto.SugestaoRespostaDto;
import br.com.fullstack.sujestoes.fachadas.SugestaoFachada;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("sugestoes")
public class SugestaoControlador {

    private final SugestaoFachada fachada;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SugestaoRespostaDto post(@Valid @RequestBody SugestaoRequisicaoDto dto) {
        log.info("POST /sugestao");
        return fachada.criar(dto);
    }

    @GetMapping
    public List<SugestaoRespostaDto> get(
            @Parameter(description = "Perquisar por título (que contenha o valor: `%{valor}%`)")
            @RequestParam(required = false) String titulo
    ) {
        log.info("GET /sugestao");
        return fachada.buscarTodos(titulo);
    }

    @GetMapping("{id}")
    public SugestaoRespostaDto getId(
            @Parameter(description = "ID da sugestão")
            @PathVariable Long id
    ) {
        log.info("GET /sugestao/id");
        return fachada.buscarPorId(id);
    }

    @PostMapping("{id}/comentarios")
    public ComentarioRespostaDto postComentario(
            @Parameter(description = "ID da sugestão")
            @PathVariable Long id,
            @Valid @RequestBody ComentarioRequisicaoDto dto
    ) {
        log.info("GET /sugestao/id/comentarios");
        return fachada.criarComentario(id, dto);
    }
}