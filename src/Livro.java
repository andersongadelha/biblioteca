import java.util.UUID;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getIsbn() {
        return isbn;
    }

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = UUID.randomUUID().toString();
        this.disponivel = true;
    }

    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Isbn: " + isbn);
        System.out.println("Disponível: " + disponivel);
        System.out.println();
    }

    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

}
