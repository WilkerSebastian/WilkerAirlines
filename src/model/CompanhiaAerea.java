package model;

public class CompanhiaAerea {
    
    private String codCompan;
    private String nomeComapnhia;
    
    public CompanhiaAerea(String codCompan, String nomeComapnhia) {
        this.codCompan = codCompan;
        this.nomeComapnhia = nomeComapnhia;
    }

    public String getCodCompan() {
        return codCompan;
    }

    public void setCodCompan(String codCompan) {
        this.codCompan = codCompan;
    }

    public String getNomeComapnhia() {
        return nomeComapnhia;
    }

    public void setNomeComapnhia(String nomeComapnhia) {
        this.nomeComapnhia = nomeComapnhia;
    }

    @Override
    public String toString() {
        return "CompanhiaAerea [codCompan=" + codCompan + ", nomeComapnhia=" + nomeComapnhia + "]";
    }

}
