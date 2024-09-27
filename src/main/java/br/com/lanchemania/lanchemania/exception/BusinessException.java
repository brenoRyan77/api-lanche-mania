package br.com.lanchemania.lanchemania.exception;

public class BusinessException extends RuntimeException{

    private Object object;

    public <T> BusinessException(String mensagem, T complemento) {
        super(mensagem + " " + complemento);
        this.object = complemento;
        this.printStackTrace();
    }

    public Object getObject() {
        return object;
    }
}
