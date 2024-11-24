package ifma.jogo;
import ifma.criaturas.Animal;
import ifma.criaturas.Criatura;
import ifma.criaturas.Monstro;
import ifma.criaturas.Personagens;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Personagens personagens = new Personagens();
    Scanner input = new Scanner(System.in);

    public Criatura escolherPersonagem() {

        System.out.println("Escolha um tipo de criatura:");
        personagens.imprimirCriaturas();
        System.out.print("Digite o número da criatura: ");
        int numCriatura = input.nextInt();
        
        //Verifica se o usuário digitou um número inválido
        while ((personagens.getCriaturas().size() - 1) < numCriatura || numCriatura < 0) {
            System.out.println("Opção inválida!");
            System.out.print("Digite o número da criatura: ");
            numCriatura = input.nextInt();
        }
        String criaturaEscolhida = personagens.getCriaturas().get(numCriatura);
        int opcao;
        switch (criaturaEscolhida) {
            case "Monstro":
                List<Monstro> monstros = personagens.getMonstros();

                System.out.println("Monstros disponíveis:");
                personagens.imprimirMonstros();
                System.out.print("Digite o número do personagem: ");
                opcao = input.nextInt();

                while (opcao > (monstros.size() - 1) || opcao < 0) {
                    System.out.println("Opção inválida!");
                    System.out.print("Digite o número do personagem: ");
                    opcao = input.nextInt();
                }
                return monstros.get(opcao);
                
            case "Animal":
                List<Animal> animais = personagens.getAnimais();

                System.out.println("Animais disponíveis:");
                personagens.imprimirAnimais();
                System.out.print("Digite o número do personagem: ");
                opcao = input.nextInt();

                while (opcao > (animais.size() - 1) || opcao < 0) {
                    System.out.println("Opção inválida!");
                    System.out.print("Digite o número do personagem: ");
                    opcao = input.nextInt();
                }
                return animais.get(opcao);
        }
        throw new RuntimeException("Opção inválida!");
    }
}
