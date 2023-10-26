public class Reserva {
    
    private Propriedade propriedade;
    private Usuario usuarioAutor;
    private int noites;
    private double precoTotal;

    public Reserva(Propriedade propriedade, Usuario usuarioAutor, int noites) {
        this.propriedade = propriedade;
        propriedade.setAlugada(true);
        this.usuarioAutor = usuarioAutor;
        this.noites = noites;
        this.precoTotal = propriedade.getPrecoPorNoite() * (double) noites;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }
    public Propriedade getPropriedade() {
        return propriedade;
    }
    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }
    public int getNoites() {
        return noites;
    }
}
