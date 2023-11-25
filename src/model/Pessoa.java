package model;

import application.Main;
import security.Verificavel;

public abstract class Pessoa implements Verificavel {
    
    private String nome; 
    private String cpf; 
    private String rg; 
    private Endereco endereco; 
    private String celular; 
    private String dataNascimento;

    public Pessoa(String nome, String cpf, String rg, Endereco endereco, String celular, String dataNascimento) {

        setNome(nome);
        setCpf(cpf);
        setRg(rg);
        setEndereco(endereco);
        setCelular(celular);
        setDataNascimento(dataNascimento);

    }

    @Override
    public boolean validar(String codigo) {
        
        // regex para validar se o cpf está no padrão xxxxxxxxxxx ou xxx.xxx.xxx-xx 
        return codigo.matches("^([0-9]{3}\\.?){3}-?[0-9]{2}$");

    }

    @Override
    public void solicitarNovo() {
        
        System.out.print("Informe novamente CPF: ");
        String cpf = Main.in.nextLine();

        this.setCpf(cpf);

    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {

        if (this.validar(cpf)) {

            this.cpf = cpf;
            return;

        }

        this.solicitarNovo();

    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
