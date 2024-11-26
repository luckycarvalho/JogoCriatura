package ifma.criaturas;

/**
 * A classe Criatura representa uma criatura genérica no sistema de batalhas.
 * Inclui atributos e métodos básicos, como nome, tipo, habitat, vida e ações
 * como atacar e defender.
 */
public class Criatura {
    /** Nome da criatura. */
    protected String nome;

    /** Tipo da criatura (ex.: Monstro, Animal, etc.). */
    protected String tipo;

    /** Habitat natural da criatura. */
    protected String habitat;

    /** Vida da criatura, inicializada com o valor padrão de 100. */
    protected int vida = 100;

    /**
     * Construtor da classe Criatura.
     *
     * @param nome    Nome da criatura.
     * @param tipo    Tipo da criatura (ex.: Monstro, Animal, etc.).
     * @param habitat Habitat natural da criatura.
     */
    public Criatura(String nome, String tipo, String habitat) {
        this.nome = nome;
        this.tipo = tipo;
        this.habitat = habitat;
    }

    /**
     * Retorna a força total da criatura. Este valor é fixo para Criatura básica.
     *
     * @return O valor fixo da força total (10).
     */
    public int getForcaTotal() {
        return 10;
    }

    /**
     * Retorna a defesa total da criatura. Este valor é fixo para Criatura básica.
     *
     * @return O valor fixo da defesa total (5).
     */
    public int getDefesaTotal() {
        return 5;
    }

    /**
     * Verifica se a criatura morreu.
     *
     * @return {@code true} se a vida da criatura for menor ou igual a zero,
     *         {@code false} caso contrário.
     */
    public boolean morreu() {
        return this.vida <= 0;
    }

    public int getVida() {
        return this.vida;
    }

    /**
     * Imprime as informações da criatura no console.
     */
    public void imprimir() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Habitat: " + this.habitat);
        System.out.println("Vida: " + this.vida);
    }

    /**
     * Realiza um ataque contra outra criatura.
     *
     * @param monstro_alvo A criatura que será atacada.
     */
    public void atacar(Criatura monstro_alvo) {
        int defesaInimigo = monstro_alvo.getDefesaTotal();
        int ataque = this.getForcaTotal();

        // valor aleatório entre 1 e 50
        int min = 1;
        int max = 50;
        int valorAleatorio = (int) (min + (max - min) * Math.random());

        //O valor aleatório é acrescentado ao dano com o obejtivo de variar o dano causado pela criatura
        int dano = ataque - defesaInimigo + valorAleatorio;
        //impede o dano de ser negativo
        dano = Math.max(dano, 0);
        monstro_alvo.vida -= dano;
        System.out.println(this.getNome() + " atacou " + monstro_alvo.getNome());
        System.out.println("Dano causado: " + dano);
    }

    /**
     * Realiza uma ação de defesa contra um ataque.
     *
     * @param ataque A criatura que está atacando.
     */
    public void defender(Criatura ataque) {
        int ataqueInimigo = ataque.getForcaTotal();
        int defesa = this.getDefesaTotal();
        int dano = ataqueInimigo - defesa;
        dano = Math.max(dano, 0);
        this.vida -= dano;

        System.out.println("Dano reduzido: " + dano);
    }

    /**
     * Retorna uma descrição completa do tipo da criatura, incluindo seu habitat.
     *
     * @return Uma string representando o tipo completo da criatura.
     */
    public String getTipoCompleto() {
        if (this instanceof Monstro) {
            return "Tipo: Monstro, Habitat: " + this.habitat;
        } else if (this instanceof Animal) {
            return "Tipo: Animal, Habitat: " + this.habitat;
        } else {
            return "Tipo desconhecido";
        }
    }

    public String getNome() {
        return this.nome;
    }
}

