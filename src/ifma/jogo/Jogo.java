package ifma.jogo;

import ifma.criaturas.Criatura;
import java.util.Scanner;

/**
 * Classe principal que gerencia o fluxo do jogo, incluindo tela inicial, batalha e turnos.
 */
public class Jogo {
    Menu menu = new Menu();
    Scanner input = new Scanner(System.in);
    Criatura jogador;
    Criatura inimigo;

    /**
     * Construtor do jogo, inicializa a tela inicial.
     */
    public Jogo() {
        this.telaInicial();
    }

    /**
     * Limpa o terminal para melhorar a visualização do jogo.
     */
    public void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Exibe a tela inicial e gerencia a navegação do menu principal.
     */
    public void telaInicial() {
        limparTela();
        System.out.println("\033[1;34m" + "=".repeat(40) + "\033[0m");
        System.out.println("\033[1;33mBem-vindo ao jogo de batalhas entre criaturas!\033[0m");
        System.out.println("\033[1;34m" + "=".repeat(40) + "\033[0m");
        System.out.println("\033[1;32m1. Criar Criatura");
        System.out.println("2. Escolher Criatura para Batalha");
        System.out.println("3. Sair\033[0m");
        int opcao = menu.obterEntradaValida("Escolha uma opção: ", 1, 3);

        switch (opcao) {
            case 1 -> {
                menu.criarCriatura();
                telaInicial();
            }
            case 2 -> {
                System.out.println("\033[1;36mDefinindo personagens...\033[0m");
                System.out.println("Jogador 1:");
                jogador = menu.escolherPersonagem();
                System.out.println("Jogador 2:");
                inimigo = menu.escolherPersonagem();
                batalha();
            }
            case 3 -> System.exit(0);
        }
    }

    /**
     * Executa o turno de um jogador ou inimigo.
     *
     * @param atacante Criatura que realizará a ação.
     * @param defensor Criatura que será alvo da ação.
     */
    private void executarTurno(Criatura atacante, Criatura defensor) {
        System.out.println("\033[1;31m--- Turno de " + atacante.getNome() + " ---\033[0m");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Passar");
        int opcao = menu.obterEntradaValida("Escolha sua ação: ", 1, 3);

        switch (opcao) {
            case 1 -> atacante.atacar(defensor);
            case 2 -> atacante.defender(defensor);
            case 3 -> System.out.println(atacante.getNome() + " passou o turno!");
        }
    }

    /**
     * Gerencia a lógica de batalha entre as criaturas selecionadas.
     */
    public void batalha() {
        Criatura vencedor = null;
        while (!jogador.morreu() && !inimigo.morreu()) {
            executarTurno(jogador, inimigo);
            if (inimigo.morreu()) {
                vencedor = jogador;
                break;
            }
            executarTurno(inimigo, jogador);
            if (jogador.morreu()) {
                vencedor = inimigo;
                break;
            }
            System.out.println("--Status--");
            System.out.println(jogador.getNome() + ": " + jogador.getVida() + " HP");
            System.out.println(inimigo.getNome() + ": " + inimigo.getVida() + " HP");
        }
        System.out.println("\033[1;32m--- FIM DA BATALHA ---\033[0m");
        System.out.println("O vencedor é " + vencedor.getNome() + "!");
        telaInicial();
    }
}
