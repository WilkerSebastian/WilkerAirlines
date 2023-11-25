package model;

public class Passageiro extends Pessoa {

    private String numPassaporte;

    public Passageiro(String nome, String cpf, String rg, Endereco endereco, String celular, String dataNascimento, String numPassaporte) {
        super(nome, cpf, rg, endereco, celular, dataNascimento);
        setNumPassaporte(numPassaporte);
    }

    public String getNumPassaporte() {
        return numPassaporte;
    }

    public void setNumPassaporte(String numPassaporte) {
        this.numPassaporte = numPassaporte;
    }

    @Override
    public String toString() {
        return "Passageiro [nome=" + getNome() + ", rg=" + getRg() + "]";
    }

}
