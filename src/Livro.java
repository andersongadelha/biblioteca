public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

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
    }

    public void emprestar() {
        this.disponivel = false;
    }

    @Override
    public String toString() {// TODO: implementar getters para exibir no console
        return "\n Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }

    public void devolver() {
        this.disponivel = true;
    }

}
