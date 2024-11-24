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
    public int getForcaTotal() {
        switch (this.tamanho) {
            case "Pequeno":
                return 7;
            case "Médio":
                return 10;
            case "Grande":
                return 15;
            case "Gigante":
                return 20;
        }
        return super.getForcaTotal();
    }

    @Override
    public int getDefesaTotal() {
        switch (this.tamanho) {
            case "Pequeno":
                return 2;
            case "Médio":
                return 5;
            case "Grande":
                return 10;
            case "Gigante":
                return 15;
        }
        return super.getDefesaTotal();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Tamanho: " + this.tamanho);
        System.out.println("Velocidade: " + this.velocidade);
    }
}
