package model;

import java.util.Collections;
import java.util.List;

public class Bilhete<T> {
    
    private T numBilhete;
    private List<Passagem> listPassagem;
    private double preco;
    private CompanhiaAerea compAere;

    public Bilhete(T numBilhete, List<Passagem> listPassagem, double preco, CompanhiaAerea compAere) {
        this.numBilhete = numBilhete;
        this.listPassagem = listPassagem;
        this.preco = preco;
        this.compAere = compAere;
    }

    public void imprimirBilhete() {

        Collections.sort(listPassagem);

        System.out.println("Bilhete [numBilhete=" + numBilhete + ", preco=" + preco + ", compAere=" + compAere + "]");
        System.out.println("Passagens: ");
        for (Passagem passagem : listPassagem) {
            
            System.out.println(passagem);

        }

        System.out.println("\n");

    }

    public T getNumBilhete() {
        return numBilhete;
    }

    public void setNumBilhete(T numBilhete) {
        this.numBilhete = numBilhete;
    }

    public List<Passagem> getListPassagem() {
        return listPassagem;
    }

    public void setListPassagem(List<Passagem> listPassagem) {
        this.listPassagem = listPassagem;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CompanhiaAerea getCompAere() {
        return compAere;
    }

    public void setCompAere(CompanhiaAerea compAere) {
        this.compAere = compAere;
    }

}
