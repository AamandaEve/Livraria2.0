package Exceptions;

public class ListaVaziaException extends RuntimeException{
    public int num;

    public ListaVaziaException(String message){
        super(message);
    }

    public String getMessage(){
        return "A lista está vazia";
    }
}

//inputmissmatch
//