import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca(ArrayList<Livro> livros, ArrayList<Usuario> usuarios) {
        this.livros = livros;
        this.usuarios = usuarios;
    }

    public Biblioteca() {

    }

    private void cadastrarLivro(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Digite o nome do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o nome de quem escreveu o livro:");
        String autor = scanner.nextLine();
        Livro livro = new Livro(titulo, autor);

        this.livros.add(livro);
    }

    private void cadastrarUsuario(Scanner scanner, int id) {
        scanner.nextLine();
        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();
        Usuario usuario = new Usuario(nome, id, new ArrayList<>());

        this.usuarios.add(usuario);
    }

    private void realizarEmprestimo(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Digite o isbn do livro:");
        String isbn = scanner.nextLine();
        System.out.println("Digite o id do usuário:");
        int idUsuario = scanner.nextInt();
        Usuario usuario = buscaUsuarioPorId(idUsuario);
        Livro livro = buscarLivroPorIsbn(isbn);

        if (Objects.nonNull(usuario) && Objects.nonNull(livro)) {
            if (usuario.getLivrosEmprestados().size() < 3) {
                if (livro.isDisponivel()) {
                    usuario.adicionarLivro(livro);
                    livro.setDisponivel(false);
                } else {
                    System.out.println("Livro indisponível.");
                }
            } else {
                System.out.println("Erro ao realizar empréstimo: usuário já possui 3 livros emprestados.");
            }
        } else {
            System.out.println("Erro ao realizar empréstimo: Livro ou usuário não cadastrado.");
        }
    }

    private void realizarDevolucao(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Digite o isbn do livro:");
        String isbn = scanner.nextLine();
        System.out.println("Digite o id do usuário:");
        int idUsuario = scanner.nextInt();
        Usuario usuario = buscaUsuarioPorId(idUsuario);
        Livro livro = buscarLivroPorIsbn(isbn);

        if (Objects.nonNull(usuario) && Objects.nonNull(livro)) {
            AtomicBoolean encontrado = new AtomicBoolean(false);
            usuario.getLivrosEmprestados().forEach(emprestado -> {
                if (isbn.equals(emprestado.getIsbn())) {
                    encontrado.set(true);
                }
            });
            if (encontrado.get()) {
                usuario.removerLivro(livro);
                livro.setDisponivel(true);
            } else {
                System.out.println("O livro não esta emprestado com esse usuário.");
            }

        } else {
            System.out.println("Erro ao realizar devolução: Livro ou usuário não cadastrado.");
        }

    }

    private void exibirLivrosDisponiveis() {
        System.out.println("Livros disponíveis: ");
        livros.forEach(livro -> {
            if (livro.isDisponivel()) {
                livro.exibirDetalhes();
            }
        });
    }

    private Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (isbn.equals(livro.getIsbn())) {
                return livro;
            }
        }

        return null;
    }

    private Usuario buscaUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }

        return null;
    }

    public void iniciar() {
        int opcao;
        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
        int proximoIdUsuario = 1;
        Scanner scanner = new Scanner(System.in);

        do {
            exibirMenu();
            opcao = getOpcao(scanner);
            switch (opcao) {
                case 1:
                    cadastrarLivro(scanner);
                    break;
                case 2:
                    cadastrarUsuario(scanner, proximoIdUsuario);
                    proximoIdUsuario++;
                    break;
                case 3:
                    realizarEmprestimo(scanner);
                    break;
                case 4:
                    realizarDevolucao(scanner);
                    break;
                case 5:
                    exibirLivrosDisponiveis();
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