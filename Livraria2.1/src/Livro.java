public class Livro {
    String titulo;
    String autor;
    String data;
    boolean statusLivro = true;
    String status;

    public Livro(String titulo, String autor, String data){
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        
    }

    

    public void statusLivro(){
        if(statusLivro == true){
            status = "Disponivel";
        }else{
            status = "Indisponivel";
        }
    }


    public boolean mudarStatus(){
        if(statusLivro == true){
            statusLivro = false;
            return false;
        }else{
            statusLivro = true;
            return true;
        }
    }

    
    public void exibirInformações(Livro livro){
        statusLivro();
        System.out.println(
            "________LIVRO____________"
            + "\nTitulo: " + titulo 
            + "\nAutor: " + autor 
            + "\nData de lançamenteo: " + data
            + "\nStatus: " + status
            + "\n________________________|\n");
        }
        
        public String toString(){
            statusLivro();
            return
            "\nTitulo: " + titulo
            +"\nAutor: " + autor
            +"\nData: " + data
            +"\nStatus: " + status
            +"\n________________________|";
        }



        public String getTitulo() {
            return titulo;
        }



        public String getAutor() {
            return autor;
        }



        public String getData() {
            return data;
        }

        
    }
    