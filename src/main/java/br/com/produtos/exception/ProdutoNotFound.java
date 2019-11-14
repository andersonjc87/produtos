package br.com.produtos.exception;

public class ProdutoNotFound extends Exception {

    private static final long serialVersionUID = 1L;

    public ProdutoNotFound(String msg) {
        super(msg);
    }

    public ProdutoNotFound(String msg, Throwable cause) {
        super(msg, cause);
    }

}
