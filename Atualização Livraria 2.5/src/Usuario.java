import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String dataDeNascimento;
    private int id;

    ArrayList<Livro> listaDeLivrosDoUsuario = new ArrayList<>();

    public Usuario(String nome, String dataDeNascimento, int id){
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }
    public Usuario(String nome, String dataDeNascimento){
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }
    public Usuario(String nome, int id){
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public String getDataDeNascimento() {
        return nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }



    public void emprestarLivro(Livro livro){
        listaDeLivrosDoUsuario.add(livro);
        livro.mudarStatus();
    }
    public void devolverLivro(Livro livro){
        listaDeLivrosDoUsuario.remove(livro);
        livro.mudarStatus();
    }
    
    public void exibirInformacoesUsuario(){
        System.out.println(
            "\nID: " + id
            +"Nome: " + nome
            +"\nID: " + dataDeNascimento
            +"\nQuantidade de livros emprestrados: " + (listaDeLivrosDoUsuario.size())
        );
    }

    public String toString(){
        return 
        "___________________"
        +"\nID: " + id
        +"\nNome: " + nome
        +"\nID: " + dataDeNascimento
        +"\n___________________|";
    }


}
