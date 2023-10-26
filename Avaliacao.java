public class Avaliacao {
    private Usuario autor;
    private int pontuacao;
    private String comentario;

    public Avaliacao (Usuario autor, int pontuacao, String comentario) {
        this.autor = autor;
        this.pontuacao = pontuacao;
        this.comentario = comentario;
    }

    public Usuario getAutor() {
        return autor;
    }
    public String getComentario() {
        return comentario;
    }
    public int getPontuacao() {
        return pontuacao;
    }

}
