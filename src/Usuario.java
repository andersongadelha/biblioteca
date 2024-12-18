import java.util.ArrayList;

public class Usuario {

    private String nome;
    private int id;
    private ArrayList<Livro> livrosEmprestados;

    public Usuario(String nome, int id, ArrayList<Livro> livrosEmprestados) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = livrosEmprestados;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Id: " + id);
        System.out.println("Livros emprestados: " + livrosEmprestados);
    }

    public void adicionarLivro(Livro livro) {
        this.livrosEmprestados.add(livro);
    }

    public void removerLivro(Livro livro) {
        this.livrosEmprestados.remove(livro);
    }
    
}
