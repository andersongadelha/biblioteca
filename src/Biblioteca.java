import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca(ArrayList<Livro> livros, ArrayList<Usuario> usuarios) {
        this.livros = livros;
        this.usuarios = usuarios;
    }

    public void cadastrarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void realizarEmprestimo(String isbn, int idUsuario) {
        //buscar usuario e ver se possui menos de 3 livros emprestados
        //caso tenha menos adicionar o livro no usuario e marcar livro como indisponivel
        //se não mostrar alguma mensagem

    }

    public void realizarDevolucao(String isbn, int idUsuario) {
        //buscarUsuario e verificar se esse livro esta com ele
        //caso sim remover da lista de usuario e marcar livro como disponivel
        //se não mostrar alguma mensagem
    }

    public void exibirLivrosDisponiveis() {
        System.out.println("Livros disponíveis: ");
        //busca entre os livros apenas os disponíveis para exibir em tela
    }

    private Usuario buscaUsuarioPorId(int id) {
        // busca na lista de usuarios pelo id e retorna usuario
    }
}