import java.util.ArrayList;

public class Usuario {
    String nome;
    String id;
    ArrayList<Livro> listaDeLivrosDoUsuario = new ArrayList<>();

    public Usuario(String nome, String id){
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    

    public void emprestarLivro(Livro livro){
        listaDeLivrosDoUsuario.add(livro);
    }
    public void devolverLivro(Livro livro){
        listaDeLivrosDoUsuario.remove(livro);
    }
    
    public void exibirInformacoesUsuario(){
        System.out.println(
            "Nome: " + nome
            +"\nID: " + id
            +"\nQuantidade de livros emprestrados: " + (listaDeLivrosDoUsuario.size())
        );
    }

    public String toString(){
        return 
        "___________________"
        +"\nNome: " + nome
        +"\nID: " + id
        +"\n___________________|";
    }


}
