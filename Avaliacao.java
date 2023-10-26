public class Avaliacao {
    private String autor;
    private int pontuacao;
    private String comentario;

    public Avaliacao (String autor, int pontuacao, String comentario) {
        this.autor = autor;
        this.pontuacao = pontuacao;
        this.comentario = comentario;
    }

    public String getAutor() {
        return autor;
    }
    public String getComentario() {
        return comentario;
    }
    public int getPontuacao() {
        return pontuacao;
    }

}
