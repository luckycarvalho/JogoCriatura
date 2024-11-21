package ifma.criaturas;

public class Animal extends Criatura{
    String tamanho;
    double velocidade;

    public Animal(String nome, String tipo, String habitat, String tamanho, double velocidade) {
        super(nome, tipo, habitat);
        this.tamanho = tamanho;
        this.velocidade = velocidade;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Tamanho: " + this.tamanho);
        System.out.println("Velocidade: " + this.velocidade);
    }
}
