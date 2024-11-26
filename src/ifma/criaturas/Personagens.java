package ifma.criaturas;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar a lista de personagens do jogo,
 * incluindo criação inicial e adição de novos personagens.
 */
public class Personagens {
    private List<Animal> animais = new ArrayList<>();
    private List<Monstro> monstros = new ArrayList<>();
    private List<String> criaturas = new ArrayList<>();

    /**
     * Construtor padrão que inicializa os personagens iniciais.
     */
    public Personagens() {
        this.adicionarCriaturasIniciais();
        this.adicionarAnimaisIniciais();
        this.adicionarMonstrosIniciais();
    }

    /**
     * Inicializa os tipos de criaturas disponíveis.
     */
    private void adicionarCriaturasIniciais() {
        criaturas.add("Monstro");
        criaturas.add("Animal");
    }

    /**
     * Adiciona a lista de animais iniciais.
     */
    private void adicionarAnimaisIniciais() {
        animais.add(new Animal("Zezin", "Animal", "Cidade", "Medio", 10.0));
        animais.add(new Animal("Chica Lopes", "Animal", "Cidade", "Medio", 10.5));
        animais.add(new Animal("Leão", "Animal", "Savana", "Grande", 15.0));
        animais.add(new Animal("Mucura", "Animal", "Floresta", "Pequeno", 16.0));
    }

    /**
     * Adiciona a lista de monstros iniciais.
     */
    private void adicionarMonstrosIniciais() {
        monstros.add(new Monstro("Rei do Mar", "Monstro", "Mar", 15, 20, 10));
        monstros.add(new Monstro("Godzila", "Monstro", "Mar", 15, 20, 15));
    }

    /**
     * Retorna a lista de animais disponíveis.
     *
     * @return Lista de animais.
     */
    public List<Animal> getAnimais() {
        return this.animais;
    }

    /**
     * Retorna a lista de monstros disponíveis.
     *
     * @return Lista de monstros.
     */
    public List<Monstro> getMonstros() {
        return this.monstros;
    }

    /**
     * Retorna a lista de tipos de criaturas disponíveis.
     *
     * @return Lista de tipos de criaturas.
     */
    public List<String> getCriaturas() {
        return criaturas;
    }

    /**
     * Adiciona um novo animal à lista.
     *
     * @param nome Nome do animal.
     * @param tipo Tipo da criatura (sempre "Animal").
     * @param habitat Habitat do animal.
     * @param tamanho Tamanho do animal.
     * @param velocidade Velocidade do animal.
     */
    public void addAnimal(String nome, String tipo, String habitat, String tamanho, double velocidade) {
        animais.add(new Animal(nome, tipo, habitat, tamanho, velocidade));
    }

    /**
     * Adiciona um novo monstro à lista.
     *
     * @param nome Nome do monstro.
     * @param tipo Tipo da criatura (sempre "Monstro").
     * @param habitat Habitat do monstro.
     * @param forca Força do monstro.
     * @param resistencia Resistência do monstro.
     * @param dano Dano do monstro.
     */
    public void addMonstro(String nome, String tipo, String habitat, int forca, int resistencia, int dano) {
        monstros.add(new Monstro(nome, tipo, habitat, forca, resistencia, dano));
    }

    /**
     * Imprime a lista de tipos de criaturas disponíveis.
     */
    public void imprimirCriaturas() {
        System.out.println("[1;34m--- Tipos de Criaturas Disponíveis ---[0m");
        for (int i = 0; i < this.criaturas.size(); i++) {
            System.out.println("[1;32m" + i + " - " + criaturas.get(i) + "[0m");
        }
    }

    /**
     * Imprime a lista de animais disponíveis no terminal.
     * Caso a lista esteja vazia, informa o usuário.
     */
    public void imprimirAnimais() {
        if (animais.isEmpty()) {
            System.out.println("[1;31mNenhum animal disponível![0m");
            return;
        }
        System.out.println("[1;34m--- Lista de Animais ---[0m");
        int cont = 0;
        for (Animal animal : this.animais) {
            System.out.println("[1;33mOpção " + cont + ":[0m");
            animal.imprimir();
            System.out.println();
            cont++;
        }
    }

    /**
     * Imprime a lista de monstros disponíveis no terminal.
     * Caso a lista esteja vazia, informa o usuário.
     */
    public void imprimirMonstros() {
        if (monstros.isEmpty()) {
            System.out.println("[1;31mNenhum monstro disponível![0m");
            return;
        }
        System.out.println("[1;34m--- Lista de Monstros ---[0m");
        int cont = 0;
        for (Monstro monstro : this.monstros) {
            System.out.println("[1;33mOpção " + cont + ":[0m");
            monstro.imprimir();
            System.out.println();
            cont++;
        }
    }
}
