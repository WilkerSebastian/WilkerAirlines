package model;

import application.Main;

public class Passagem implements Comparable<Passagem> {
    
    private String numero;
    private Voo vooIda;
    private Voo vooVolta;
    private Passageiro passageiro;
    private String assento;
    
    public Passagem(String numero, Voo vooIda, Voo vooVolta, Passageiro passageiro, String assento) {
        this.numero = numero;
        this.vooIda = vooIda;
        this.vooVolta = vooVolta;
        this.passageiro = passageiro;
        this.assento = assento;
    }

    public Passagem(String numero, Voo vooIda, Passageiro passageiro, String assento) {
        this(numero, vooIda, null, passageiro, assento);
    }

    public boolean verificarCapacidade() {

        // usando filter com lambda para ver quantos passagens com voo de ida tem já registrados
        int idaRegistrados = Main.passagens.stream().filter(pa -> pa.getVooIda().getNumVoo() == this.vooIda.getNumVoo()).toList().size();

        if (this.vooIda.getCapacidade() - idaRegistrados > 0) {

            if (this.vooVolta == null)
                return true;

            // usando filter com lambda para ver quantos passagens com voo de volta tem já registrados
            int voltaRegistrados = Main.passagens.stream().filter(pa -> pa.getVooIda().getNumVoo() == this.vooIda.getNumVoo()).toList().size();

            if (this.vooVolta.getCapacidade() - voltaRegistrados > 0)
                return true;

        }

        System.out.println("Voo sem disponibilidade");
        return false;

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Voo getVooIda() {
        return vooIda;
    }

    public void setVooIda(Voo vooIda) {
        this.vooIda = vooIda;
    }

    public Voo getVooVolta() {
        return vooVolta;
    }

    public void setVooVolta(Voo vooVolta) {
        this.vooVolta = vooVolta;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    @Override
    public String toString() {
        return "Passagem [numero=" + numero + ", vooIda=" + vooIda + ", vooVolta=" + vooVolta + ", passageiro="
                + passageiro + ", assento=" + assento + "]";
    }

    @Override
    public int compareTo(Passagem passagem) {

        return this.getPassageiro().getNome().compareTo(passagem.getPassageiro().getNome());

    }   

}
