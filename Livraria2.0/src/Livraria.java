import java.util.ArrayList;
import java.util.Scanner;

public class Livraria implements Library{
    ArrayList<Livro> listaDeLivrosCadastrados = new ArrayList<>();
    ArrayList<Usuario> listaDeUsuariosCadastrados = new ArrayList<>();
    boolean sistema = true;

    @SuppressWarnings("resource")
    @Override
    public void inicio() {
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
        
        Scanner sc = new Scanner(System.in);
        int acao = sc.nextInt();
        sc.nextLine();
        Livro livro;
        Usuario usuario;



        switch (acao) {
            case 1:
                System.out.println("Qual o título do livro que será adicionado?");
                String titulo = sc.nextLine();
                System.out.println("Qual o nome do autor do livro que será adicionado?");
                String autor = sc.nextLine();
                System.out.println("Qual a data em que o livro foi publicado?");
                String data = sc.nextLine();
                livro = new Livro(titulo, autor, data);
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
                usuario = new Usuario(nome, id);
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

            usuario = new Usuario(nome, id);
            livro = new Livro(titulo, autor, data);            
            emprestarLivro(usuario, livro);
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
            usuario = new Usuario(nome, id);
            livro = new Livro(titulo, autor, data);

            devolverLivro(usuario, livro);

            break;

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
                System.out.println("lista do usuario : ");
                exibirListaDeLivrosDoUsuario(usuarioTeste3);
            }else{
                System.out.println("Usuario não encontrado D:");
            }
        }
        break;
        
        case 9:
        exibirLivrosDisponiveis();
        break;
    }

    
    }


    
    @Override
    public void funcionamento() {
        while (sistema == true) {
            inicio();
        }
    }

    @Override
    public void adicionarLivro(Livro livro) {
        listaDeLivrosCadastrados.add(livro);;
    }

    @Override
    public void removerLivro(Livro livro) {
        listaDeLivrosCadastrados.remove(livro);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        listaDeUsuariosCadastrados.add(usuario);
    }

    @Override
    public void emprestarLivro(Usuario usuario, Livro livro) {
        for(Usuario user : listaDeUsuariosCadastrados){
            if(user.nome.equals(usuario.nome) && user.id.equals(usuario.id)){
                for(Livro book : listaDeLivrosCadastrados){
                    if(book.titulo.equals(livro.titulo) && book.autor.equals(livro.autor)){
                        if(book.statusLivro==true){
                            user.emprestarLivro(book);
                            System.out.println("Livro emprestado com sucesso :)");
                        }else{
                            System.out.println("O livro não está disponível para empréstimo");
                        }
                    }else{
                        System.out.println("Livro não encontrado :(");
                    }
                }
            }else{
                System.out.println("Usuário não encontrado :(");
            }
        }
    }


    @Override
    public void devolverLivro(Usuario usuario, Livro livro) {
        for(Usuario user : listaDeUsuariosCadastrados){
            if(user.nome.equals(usuario.nome) && user.id.equals(usuario.id)){
                for(Livro book : listaDeLivrosCadastrados){
                    if(book.titulo.equals(livro.titulo) && book.autor.equals(livro.autor)){
                        if(book.statusLivro==false){
                            user.devolverLivro(book);
                            System.out.println("Livro devolvido");
                        }else{
                            System.out.println("O livro ainda não foi emprestado");
                        }
                    }else{
                        System.out.println("Livro não encontrado :(");
                    }
                }
            }else{
                System.out.println("Usuário não encontrado :(");
            }
       }
    }

    @Override
    public ArrayList<Livro> exibirListaDeLivros() {
        listaDeLivrosCadastrados.forEach(System.out::println);
        return listaDeLivrosCadastrados;
    }

    @Override
    public ArrayList<Usuario> exibirListaDeUsuarios() {
        listaDeUsuariosCadastrados.forEach(System.out::println);
        return listaDeUsuariosCadastrados;
    }

    @Override
    public ArrayList<Livro> exibirListaDeLivrosDoUsuario(Usuario usuario) {
        usuario.listaDeLivrosDoUsuario.forEach(System.out::println);
        return usuario.listaDeLivrosDoUsuario;
    }

    @Override
    public ArrayList<Livro> exibirLivrosDisponiveis() {
        for(Livro livro : listaDeLivrosCadastrados){
            if(livro.statusLivro == true){
                System.out.println(livro);
            }else if(livro.statusLivro == false){
                System.out.println("Este livro não foi emprestado");
            }else{
                System.out.println("Livro não encontrado");
            }
        }
        return listaDeLivrosCadastrados;
    }

}
