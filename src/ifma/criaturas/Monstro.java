package ifma.criaturas;

public class Monstro extends Criatura {
    int forca;
    int resistencia;
    int dano;
    public Monstro (String nome, String tipo, String habitat, int forca, int resistencia, int dano) {
        super(nome, tipo, habitat);
        this.forca = forca;
        this.resistencia = resistencia;
        this.dano = dano;
    }

    @Override
    public int getForcaTotal() {
        return this.forca + this.dano;
    }

    @Override
    public int getDefesaTotal() {
        return this.resistencia;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Força: " + this.forca);
        System.out.println("Resistência: " + this.resistencia);
        System.out.println("Dano: " + this.dano);
    }
}
