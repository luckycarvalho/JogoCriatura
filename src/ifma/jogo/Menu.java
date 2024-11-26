package ifma.jogo;
import ifma.criaturas.Animal;
import ifma.criaturas.Criatura;
import ifma.criaturas.Monstro;
import ifma.criaturas.Personagens;

import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por gerenciar o menu do jogo, incluindo a criação e seleção de criaturas.
 */
public class Menu {
    Personagens personagens = new Personagens();
    Scanner input = new Scanner(System.in);

    /**
     * Obtém uma entrada válida do usuário dentro de um intervalo definido.
     *
     * @param mensagem Mensagem exibida ao usuário.
     * @param min Valor mínimo permitido.
     * @param max Valor máximo permitido.
     * @return Entrada válida do usuário.
     */
    public int obterEntradaValida(String mensagem, int min, int max) {
        int opcao;
        do {
            System.out.print(mensagem);
            opcao = input.nextInt();
            if (opcao < min || opcao > max) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao < min || opcao > max);
        return opcao;
    }

    /**
     * Seleciona uma criatura com base no tipo e na lista disponível.
     *
     * @param criaturas Lista de criaturas disponíveis.
     * @param tipo Tipo de criatura (ex.: Monstro ou Animal).
     * @return A criatura selecionada.
     */
    private Criatura selecionarCriatura(List<? extends Criatura> criaturas, String tipo) {
        System.out.println(tipo + " disponíveis:");
        for (int i = 0; i < criaturas.size(); i++) {
            System.out.println(i + ". " + criaturas.get(i).getNome());
        }
        int opcao = obterEntradaValida("Digite o número do personagem: ", 0, criaturas.size() - 1);
        return criaturas.get(opcao);
    }

    /**
     * Permite ao usuário escolher um personagem para o jogo.
     *
     * @return A criatura escolhida pelo usuário.
     */
    public Criatura escolherPersonagem() {
        System.out.println();
        System.out.println("Escolha um tipo de criatura:");
        personagens.imprimirCriaturas();
        int numCriatura = obterEntradaValida("Digite o número da criatura: ", 0, personagens.getCriaturas().size() - 1);
        String criaturaEscolhida = personagens.getCriaturas().get(numCriatura);

        switch (criaturaEscolhida) {
            case "Monstro":
                return selecionarCriatura(personagens.getMonstros(), "Monstros");
            case "Animal":
                return selecionarCriatura(personagens.getAnimais(), "Animais");
        }
        throw new RuntimeException("Opção inválida!");
    }

    /**
     * Permite ao usuário criar uma nova criatura (Monstro ou Animal).
     */
    public void criarCriatura() {
        System.out.println();
        System.out.println("Escolha um tipo de criatura:");
        personagens.imprimirCriaturas();
        int numCriatura = obterEntradaValida("Digite o número da criatura: ", 0, personagens.getCriaturas().size() - 1);
        String criaturaEscolhida = personagens.getCriaturas().get(numCriatura);

        System.out.print("Digite o nome da criatura: ");
        String nome = input.next();

        System.out.print("Digite o habitat da criatura: ");
        String habitat = input.next();

        if (criaturaEscolhida.equals("Monstro")) {
            int forca = obterEntradaValida("Digite a força da criatura(max:10, min:1): ", 1, 10);
            int resistencia = obterEntradaValida("Digite a resistência da criatura(max:15, min:1): ", 1, 15);
            int dano = obterEntradaValida("Digite o dano da criatura(max:10, min:1): ", 1, 10);
            personagens.addMonstro(nome, "Monstro", habitat, forca, resistencia, dano);
        } else {
            System.out.print("Digite o tamanho da criatura(Pequeno/Medio/Grande/Gigante): ");
            String tamanho = input.next();
            double velocidade = obterEntradaValida("Digite a velocidade da criatura(max:20, min:1): ", 1, 20);
            personagens.addAnimal(nome, "Animal", habitat, tamanho, velocidade);
        }
    }
}

