import java.util.ArrayList;

public interface Library {
    public void inicio();
    public void funcionamento();
    public void adicionarLivro(Livro livro);
    public void removerLivro(Livro livro);
    public void registrarUsuario(Usuario usuario);
    public void emprestarLivro(Usuario usuario, Livro livro);
    public void devolverLivro(Usuario usuario, Livro livro);
    public ArrayList<Livro> exibirListaDeLivros();
    public ArrayList<Usuario> exibirListaDeUsuarios();
    public ArrayList<Livro> exibirListaDeLivrosDoUsuario(Usuario usuario);
    public ArrayList<Livro> exibirLivrosDisponiveis();
}
