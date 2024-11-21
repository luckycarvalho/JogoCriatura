package ifma.criaturas;

public class Criatura {
    public String nome;
   public String tipo;
    public String habitat;
    public int vida = 100;

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

    public void imprimir() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Habitat: " + this.habitat);
    }

    public void atacar(Criatura monstro_alvo) {
        int defesaInimigo = monstro_alvo.getDefesaTotal();;
        int ataque = this.getForcaTotal();
        double dano = ataque - defesaInimigo;
        monstro_alvo.vida -= dano * (Math.random() * (2.1 - 1.5));
        System.out.println("O " + monstro_alvo + " tomou um dano de " + dano + " de " + this.nome);
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
