import java.util.ArrayList;
import java.util.Scanner;

public class Livraria {
    ArrayList<Livro> listaDeLivrosCadastrados = new ArrayList<>();
    ArrayList<Usuario> listaDeUsuariosCadastrados = new ArrayList<>();

    boolean sistema = true;

    public void inicio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("        BEM VINDO A LIVRARIA!");
        System.out.println("    O que você gostaria de fazer?");
        System.out.println("1 - Adicionar livro"
                + "\n2 - Remover livro"
                + "\n3 - Registrar usuário"
                + "\n4 - Emprestar livro"
                + "\n5 - Devolver livro"
                + "\n6 - Exibir todos os livros"
                + "\n7 - Exibir lista de usuários"
                + "\n8 - Exibir livros emprestados ao usuário"
                + "\n9 - Exibir os livros disponíveis para empréstimo"
                + "\n0 - Sair");
        int acao = sc.nextInt();
        sc.nextLine();

        switch (acao) {
            case 1:
                System.out.println("Qual o título do livro que será adicionado?");
                String titulo = sc.nextLine();
                System.out.println("Qual o nome do autor do livro que será adicionado?");
                String autor = sc.nextLine();
                System.out.println("Qual a data em que o livro foi publicado?");
                String data = sc.nextLine();

                Livro livro = new Livro(titulo, autor, data);
                adicionarLivro(livro);
                System.out.println("Livro adicionado com sucesso!");
                break;
            case 2:
                System.out.println("Qual o título do livro que você deseja remover?");
                titulo = sc.nextLine();
                var iterator = listaDeLivrosCadastrados.iterator();
                while (iterator.hasNext()) {
                    Livro tituloLivro = iterator.next();
                    if (tituloLivro.getTitulo().equals(titulo)) {
                        iterator.remove();
                        System.out.println("Livro removido com sucesso!");
                        return;
                    }
                }
                System.out.println("Livro não encontrado");
                break;
            case 3:
                System.out.println("Digite o nome do usuário");
                String nome = sc.nextLine();
                System.out.println("Digite o ID do usuário");
                String id = sc.nextLine();
                Usuario usuario = new Usuario(nome, id);
                registrarUsuario(usuario);
                System.out.println("Usuário cadastrado com sucesso!");
                break;
            case 4:
                System.out.println("Qual o titulo do livro que será emprestado?");
                titulo = sc.nextLine();
                System.out.println("Qual o autor do livro que será emprestado?");
                autor = sc.nextLine();
                System.out.println("Qual a data do livro que será emprestado?");
                data = sc.nextLine();
                System.out.println("Para qual usuário o livro será emprestado?");
                nome = sc.nextLine();
                System.out.println("Para qual o ID do usuário?");
                id = sc.nextLine();

                Livro livroTeste = new Livro(titulo, autor, data);
                Usuario usuarioTeste = new Usuario(nome, id);

                for(Livro percorrer : listaDeLivrosCadastrados){
                    if(percorrer.autor.equals(autor) && percorrer.titulo.equals(titulo)){
                        for(Usuario percorrer2 : exibirListaDeUsuarios()){
                            if(percorrer2.nome.equals(nome) && percorrer2.id.equals(id)){
                                emprestarLivro(usuarioTeste, livroTeste);
                                System.out.println("Livro emprestado com sucesso!");
                            }else{
                                System.out.println("Não foi possível encontrar este usuário :(");
                            }
                        }
                    }else{
                        System.out.println("Não foi possivel encontrar este livro :(");
                    }
                }
                    break;
                case 5:
                    System.out.println("Qual o nome do usuario que irá devoler o livro?");
                    nome = sc.nextLine();
                    System.out.println("Qual o id do usuário que irá devolver o livro");
                    id = sc.nextLine();
                    System.out.println("Qual o titulo do livro a ser devolvido?");
                    titulo = sc.nextLine();
                    System.out.println("Qual o autor do livro a ser devolvido?");
                    autor = sc.nextLine();
                    System.out.println("Qual a data do livro a ser devolvido?");
                    data = sc.nextLine();

                    Livro livroTeste2 = new Livro(titulo, autor, data);
                    Usuario usuarioTeste2 = new Usuario(nome, id);

                    for(Usuario percorrerUsuario : listaDeUsuariosCadastrados){
                        if(nome.equals(percorrerUsuario.nome) && id.equals(percorrerUsuario.id)){
                            for(Livro percorreLivro : listaDeLivrosCadastrados){
                                if(titulo.equals(percorreLivro.titulo) && autor.equals(percorreLivro.autor)){
                                    devolverLivro(usuarioTeste2,livroTeste2);
                                    System.out.println("Livro devolvido :D");
                                }else{
                                    System.out.println("Livro não encontrado D:");
                                }
                            }
                        }else{
                            System.out.println(percorrerUsuario.nome + "Usuário não encontrado D:");
                        }
                    }
                case 6:
                    System.out.println("\n    Lista de Livros: ");
                    exibirListaDeLivros();
                    break;
                case 7:
                    System.out.println("\n    Lista de Usuários: ");
                    exibirListaDeUsuarios();
                    break;
                case 8:
                System.out.println("Qual o nome do usuario?");
                nome = sc.nextLine();
                System.out.println("Qual o id do usuário?");
                id = sc.nextLine();

                for(Usuario usuarioTeste3 : listaDeUsuariosCadastrados){
                    if(nome.equals(usuarioTeste3.nome) && id.equals(usuarioTeste3.id)){
                        exibirlistaDeLivrosDoUsuario(usuarioTeste3);
                    }else{
                        System.out.println("Usuario não encontrado D:");
                    }
                }
                    break;
                    
                case 9:
                 exibirLivrosDisponiveis();
                
                   

        }
    }

    public void funcionamento() {
        while (sistema == true) {
            inicio();
        }
    }

    public void adicionarLivro(Livro livro) {
        listaDeLivrosCadastrados.add(livro);
    }

    public void removerLivro(Livro livro) {
        listaDeLivrosCadastrados.remove(livro);
    }

    public void registrarUsuario(Usuario usuario) {
        listaDeUsuariosCadastrados.add(usuario);
    }

    public void emprestarLivro(Usuario usuario, Livro livro) {
        if (livro.statusLivro == true) {
            usuario.listaDeLivrosDoUsuario.add(livro);
            livro.mudarStatus();
        } else {
            System.out.println("O livro está indisponivel para empréstimo");
        }
    }

    public void devolverLivro(Usuario usuario, Livro livro) {
        if (usuario.listaDeLivrosDoUsuario.contains(livro)) {
            usuario.listaDeLivrosDoUsuario.remove(livro);
            livro.mudarStatus();
        } else {
            System.out.println("O livro não consta nos empréstimos do usuário");
        }
    }

    public ArrayList<Livro> exibirListaDeLivros() {
        
        listaDeLivrosCadastrados.forEach(System.out::println);
        return listaDeLivrosCadastrados;
    }

    public ArrayList<Usuario> exibirListaDeUsuarios() {
        
        listaDeUsuariosCadastrados.forEach(System.out::println);
        return listaDeUsuariosCadastrados;
    }

    public ArrayList<Livro> exibirlistaDeLivrosDoUsuario(Usuario usuario) {
        usuario.listaDeLivrosDoUsuario.forEach(System.out::println);
        return usuario.listaDeLivrosDoUsuario;
    }

    public ArrayList<Livro> exibirLivrosDisponiveis() {
        
        listaDeLivrosCadastrados.stream().filter(a -> a.statusLivro == true).map(a -> "____________________"
                + "\nLivro: " + a.titulo
                + "\nAutor: " + a.autor).forEach(System.out::println);
        return listaDeLivrosCadastrados;
    }

}
