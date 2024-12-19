import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca(ArrayList<Livro> livros, ArrayList<Usuario> usuarios) {
        this.livros = livros;
        this.usuarios = usuarios;
    }

    public Biblioteca() {

    }

    private void cadastrarLivro(String titulo, String autor) {
        Livro livro = new Livro(titulo, autor);
        this.livros.add(livro);
    }

    private void cadastrarUsuario(String nome, int id) {
        Usuario usuario = new Usuario(nome, id, new ArrayList<>());
        this.usuarios.add(usuario);
    }

    private void realizarEmprestimo(String isbn, int idUsuario) {
        //buscar usuario e ver se possui menos de 3 livros emprestados
        //caso tenha menos adicionar o livro no usuario e marcar livro como indisponivel
        //se não mostrar alguma mensagem

    }

    private void realizarDevolucao(String isbn, int idUsuario) {
        //buscarUsuario e verificar se esse livro esta com ele
        //caso sim remover da lista de usuario e marcar livro como disponivel
        //se não mostrar alguma mensagem
    }

    private void exibirLivrosDisponiveis() {
        System.out.println("Livros disponíveis: ");
        //busca entre os livros apenas os disponíveis para exibir em tela
    }

    private Usuario buscaUsuarioPorId(int id) {
        // busca na lista de usuarios pelo id e retorna usuario
        return new Usuario("teste", 1, new ArrayList<>());
    }

    public void iniciar() {
        int opcao;
        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
        int idUsuario = 1;
        Scanner scanner = new Scanner(System.in);
        do {
            exibirMenu();
            opcao = getOpcao(scanner);
            switch (opcao) {
                case 1:
                    String titulo;
                    String autor;
                    scanner.nextLine();
                    System.out.println("Digite o nome do livro:");
                    titulo = scanner.nextLine();
                    System.out.println("Digite o nome de quem escreveu o livro:");
                    autor = scanner.nextLine();
                    cadastrarLivro(titulo, autor);
                    break;
                case 2:
                    String nome;
                    scanner.nextLine();
                    System.out.println("Digite o nome do usuário:");
                    nome = scanner.nextLine();
                    cadastrarUsuario(nome, idUsuario);
                    idUsuario++;
                    break;
                case 6:
                    livros.forEach(Livro::exibirDetalhes);
                    break;
                case 7:
                    usuarios.forEach(Usuario::exibirDetalhes);
                    break;
            }
        } while (opcao != 8);
        scanner.close();
    }

    private static int getOpcao(Scanner scanner) {
        int opcao;
        opcao = scanner.nextInt();

        return opcao;
    }

    private static void exibirMenu() {
        System.out.println("┌──────Biblioteca Catalisa──────┐");
        System.out.println("│                               │");
        System.out.println("│      Escolha uma opção:       │");
        System.out.println("│                               │");
        System.out.println("│ 1 - Cadastrar livro           │");
        System.out.println("│ 2 - Cadastrar usuário         │");
        System.out.println("│ 3 - Realizar empréstimo       │");
        System.out.println("│ 4 - Realizar devolução        │");
        System.out.println("│ 5 - Exibir livros disponíveis │");
        System.out.println("│ 6 - Exibir todos os livros    │");
        System.out.println("│ 7 - Exibir usuários           │");
        System.out.println("│ 8 - Sair                      │");
        System.out.println("└───────────────────────────────┘");
    }
}