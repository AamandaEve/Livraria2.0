package Exceptions;

public class ListaVaziaException {
    public int num;

    public ListaVaziaException(int num){
        this.num = num;
    }

    public String getMessage(){
        return "A lista está vazia";
    }
}
