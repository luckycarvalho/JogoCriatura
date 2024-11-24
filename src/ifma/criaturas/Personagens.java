package ifma.criaturas;

import java.util.ArrayList;
import java.util.List;

public class Personagens {
    private List<Animal> animais = new ArrayList<>();
    private List<Monstro> monstros = new ArrayList<>();
    private List<String> criaturas = new ArrayList<>();

    public Personagens() {
        this.adicionarAnimais();
        this.adicionarMosntros();
        this.adicionarCriaturas();
    }

    private void adicionarCriaturas() {
        criaturas.add("Monstro");
        criaturas.add("Animal");
    }

    private void adicionarAnimais() {
        animais.add(new Animal("Zezin", "Animal", "Cidade", "Médio", 10.0));
        animais.add(new Animal("Chica Lopes", "Animal", "Cidade", "Médio", 10.5));
        animais.add(new Animal("Leão", "Animal", "Savana", "Grande", 15.0));
        animais.add(new Animal("Mucura", "Animal", "floresta", "Pequeno", 16.0));
    }

    private void adicionarMosntros() {
        monstros.add(new Monstro("Rei do Mar", "Monstro", "Mar", 15, 20, 10));
        monstros.add(new Monstro("Godzila", "Monstro", "Mar", 15, 20, 15));
    }

    public List<Animal> getAnimais() {
        return this.animais;
    }
    public List<Monstro> getMonstros() {
        return this.monstros;
    }
    public List<String> getCriaturas(){return criaturas;}


    public void imprimirCriaturas() {
        for(int i = 0; i < this.criaturas.size(); i++) {
            System.out.println(i + "-" + criaturas.get(i));
        }
    }

    public void imprimirAnimais(){
        int cont = 0;
        for(Animal animal : this.animais){
            System.out.println("Opção " + cont +":");
            animal.imprimir();
            System.out.println();
            cont++;
        }
    }

    public void imprimirMonstros() {
        int cont = 0;
        for(Monstro monstro : this.monstros){
            System.out.println("Opção " + cont +":");
            monstro.imprimir();
            System.out.println();
            cont++;
        }
    }
}
