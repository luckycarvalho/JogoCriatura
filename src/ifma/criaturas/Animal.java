package ifma.criaturas;

/**
 * Representa um animal no sistema de batalhas. Os animais possuem atributos específicos,
 * como tamanho e velocidade, que influenciam em sua força, defesa e habilidade de esquiva.
 */
public class Animal extends Criatura {

    /** Tamanho do animal (PEQUENO, MEDIO, GRANDE, GIGANTE). */
    private String tamanho;

    /** Velocidade do animal, usada para calcular a chance de esquiva. */
    private double velocidade;

    /**
     * Construtor da classe Animal.
     *
     * @param nome      Nome do animal.
     * @param tipo      Tipo do animal (ex.: "Mamífero", "Réptil").
     * @param habitat   Habitat natural do animal (ex.: "Floresta", "Savanas").
     * @param tamanho   Tamanho do animal (PEQUENO, MEDIO, GRANDE, GIGANTE).
     * @param velocidade Velocidade do animal.
     */
    public Animal(String nome, String tipo, String habitat, String tamanho, double velocidade) {
        super(nome, tipo, habitat);
        this.tamanho = tamanho.toUpperCase();
        this.velocidade = velocidade;
    }

    /**
     * Retorna a velocidade do animal.
     *
     * @return A velocidade do animal.
     */
    public double getVelocidade() {
        return velocidade;
    }

    /**
     * Calcula e retorna a força total do animal com base no seu tamanho.
     *
     * <ul>
     * <li>PEQUENO: 7</li>
     * <li>MEDIO: 10</li>
     * <li>GRANDE: 15</li>
     * <li>GIGANTE: 20</li>
     * <li>Outros valores: valor padrão da classe base.</li>
     * </ul>
     *
     * @return A força total do animal.
     */
    @Override
    public int getForcaTotal() {
        return switch (this.tamanho) {
            case "PEQUENO" -> 7;
            case "MEDIO" -> 10;
            case "GRANDE" -> 15;
            case "GIGANTE" -> 20;
            default -> super.getForcaTotal();
        };
    }

    /**
     * Calcula e retorna a defesa total do animal com base no seu tamanho.
     *
     * <ul>
     * <li>PEQUENO: 2</li>
     * <li>MEDIO: 5</li>
     * <li>GRANDE: 10</li>
     * <li>GIGANTE: 15</li>
     * <li>Outros valores: valor padrão da classe base.</li>
     * </ul>
     *
     * @return A defesa total do animal.
     */
    @Override
    public int getDefesaTotal() {
        return switch (this.tamanho) {
            case "PEQUENO" -> 2;
            case "MEDIO" -> 5;
            case "GRANDE" -> 10;
            case "GIGANTE" -> 15;
            default -> super.getDefesaTotal();
        };
    }

    /**
     * Realiza uma ação de defesa contra um ataque.
     * Se o atacante também for um animal, existe uma chance de esquiva baseada na
     * diferença de velocidades entre o atacante e o defensor.
     *
     * @param ataque A criatura que está atacando o animal.
     */
    @Override
    public void defender(Criatura ataque) {
        int ataqueInimigo = ataque.getForcaTotal();
        int defesa = this.getDefesaTotal();
        int dano = ataqueInimigo - defesa;

        if (ataque instanceof Animal atacante) {
            Animal defensor = this;
            double chanceEsquiva = (defensor.getVelocidade() - atacante.getVelocidade()) / 10.0;

            if (Math.random() < chanceEsquiva) {
                dano = 0;
                System.out.println(this.getNome() + " defendeu!");
                System.out.println("Ataque esquivado!");
            }
        }

        this.vida -= dano;

        if (dano > 0) {
            System.out.println(this.getNome() + " defendeu!");
            System.out.println("Dano reduzido: " + dano);
        }
    }

    /**
     * Exibe as informações detalhadas do animal no console, incluindo os atributos
     * herdados de {@link Criatura} e os específicos desta classe.
     */
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Tamanho: " + this.tamanho);
        System.out.println("Velocidade: " + this.velocidade);
    }
}
