package br.com.fullstack.sujestoes.configs.excecoes;

public class NaoEncontradoExcecao extends RuntimeException {
    public NaoEncontradoExcecao(String mensagem) {
        super(mensagem);
    }
}
