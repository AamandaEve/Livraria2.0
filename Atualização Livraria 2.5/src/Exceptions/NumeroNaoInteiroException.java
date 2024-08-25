package Exceptions;

public class NumeroNaoInteiroException extends RuntimeException  {
    public int num;

    public NumeroNaoInteiroException(int num){
        this.num = num;
    }

    public String getMessage(){
        return String.format("Atributo %s não é um inteiro", num);
    }
}
