package ifma.criaturas;

/**
 * Representa um monstro no sistema de batalhas. Os monstros possuem atributos específicos
 * que determinam sua força, resistência e dano.
 */
public class Monstro extends Criatura {
    /** Força base do monstro. */
    private int forca;

    /** Resistência base do monstro, usada para calcular sua defesa. */
    private int resistencia;

    /** Dano adicional que o monstro pode causar em seus ataques. */
    private int dano;

    /**
     * Construtor da classe Monstro.
     *
     * @param nome        Nome do monstro.
     * @param tipo        Representa seu tipo, que no caso é Monstro
     * @param habitat     Habitat natural do monstro (ex.: "Floresta", "Montanhas").
     * @param forca       Força base do monstro.
     * @param resistencia Resistência base do monstro.
     * @param dano        Dano adicional causado pelo monstro.
     */
    public Monstro(String nome, String tipo, String habitat, int forca, int resistencia, int dano) {
        super(nome, tipo, habitat);
        this.forca = forca;
        this.resistencia = resistencia;
        this.dano = dano;
    }

    /**
     * Calcula e retorna a força total do monstro, que é a soma de sua força base
     * e seu dano adicional.
     *
     * @return A força total do monstro.
     */
    @Override
    public int getForcaTotal() {
        return this.forca + this.dano;
    }

    /**
     * Retorna a defesa total do monstro, que é equivalente à sua resistência base.
     *
     * @return A defesa total do monstro.
     */
    @Override
    public int getDefesaTotal() {
        return this.resistencia;
    }

    /**
     * Exibe as informações detalhadas do monstro no console, incluindo os atributos
     * herdados de {@link Criatura} e os específicos desta classe.
     */
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Força: " + this.forca);
        System.out.println("Resistência: " + this.resistencia);
        System.out.println("Dano: " + this.dano);
    }
}
