package ifma.criaturas;

public class Criatura {
    String nome;
   String tipo;
    String habitat;
    int vida = 100;

    public Criatura(String nome, String tipo, String habitat) {
        this.nome = nome;
        this.tipo = tipo;
        this.habitat = habitat;
    }

    public int getForcaTotal(){
        return 10;
    }
    public int getDefesaTotal(){
        return 5;
    }
    public boolean morreu(){return this.vida <= 0;}

    public void imprimir() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Habitat: " + this.habitat);
        System.out.println("Vida: " + this.vida);   }

    public void atacar(Criatura monstro_alvo) {

        int defesaInimigo = monstro_alvo.getDefesaTotal();;
        int ataque = this.getForcaTotal();

        int min = 1;
        int max = 50;
        int valorAleatorio = (int) (min + (max-min) * Math.random());

        int dano = ataque - defesaInimigo + valorAleatorio;
        monstro_alvo.vida -= dano;

        System.out.println("O " + monstro_alvo.nome + " tomou um dano de " + dano + " de " + this.nome);
    }

    public void defender(Criatura ataque) {
        int ataqueInimigo = ataque.getForcaTotal();
        int defesa = this.getDefesaTotal();
        int dano = ataqueInimigo - defesa;
        this.vida -= dano;
        System.out.println(this.nome + " reduziu " + ataqueInimigo + " do ataque de " + ataque.nome + " em " + dano + " de dano");
    }

    public String getTipoCompleto() {
        if(this instanceof Monstro) {
            return "Tipo: Monstro, Habitat: " + this.habitat;
        } else if (this instanceof Animal) {
            return "Tipo: Animal, Habitat: " + this.habitat;
        } else {
            return "Tipo desconhecido";
        }
    }
}
