import java.util.ArrayList;
import java.util.Objects;

public class Usuario {

    private String nome;
    private int id;
    private ArrayList<Livro> livrosEmprestados;

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public ArrayList<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public Usuario(String nome, int id, ArrayList<Livro> livrosEmprestados) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = livrosEmprestados;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Id: " + id);
        System.out.println("Livros emprestados:");
        if(Objects.nonNull(livrosEmprestados)) {
            exibirDetalhesLivros();
        }
        System.out.println();

    }

    private void exibirDetalhesLivros() {
        this.livrosEmprestados.forEach(Livro::exibirDetalhes);
    }

    public void adicionarLivro(Livro livro) {
        this.livrosEmprestados.add(livro);
    }

    public void removerLivro(Livro livro) {
        this.livrosEmprestados.remove(livro);
    }

    public String serializar() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append(";").append(id).append(";");
        if(Objects.nonNull(livrosEmprestados)) {
            for (Livro livro : livrosEmprestados) {
                if (Objects.nonNull(livro)) {
                    sb.append(livro.getTitulo()).append("~").append(livro.getAutor()).append("~").append(livro.getIsbn()).append("~").append(livro.isDisponivel()).append("|");
                }
            }
        }

        return sb.toString();
    }

    public static Usuario desserializar(String data) {
        String[] propriedades =  data.split(";");
        Usuario usuario = new Usuario(propriedades[0], Integer.parseInt(propriedades[1]));
        if (propriedades.length > 2) {
            usuario.livrosEmprestados = new ArrayList<>();
            String[] propriedadesLivros = propriedades[2].split("\\|");
            for( String propriedadeLivro : propriedadesLivros ) {
                usuario.livrosEmprestados.add(Livro.desserializar(propriedadeLivro));
            }
        }
        return usuario;
    }

}
