package br.com.lanchemania.lanchemania.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String mensagem) {
        super(mensagem);
        this.printStackTrace();
    }
}
