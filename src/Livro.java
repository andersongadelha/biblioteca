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

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
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

    public Livro(String titulo, String autor, String isbn, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = disponivel;
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

    public String serializar() {
        return titulo + "~" + autor + "~" + isbn + "~" + disponivel;
    }

    public static Livro desserializar(String data) {
        String[] propriedades = data.split("~");

        return new Livro(propriedades[0], propriedades[1], propriedades[2], Boolean.parseBoolean(propriedades[3]));
    }
}
