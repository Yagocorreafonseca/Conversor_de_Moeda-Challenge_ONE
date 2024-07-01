package Modelos;

import com.google.gson.annotations.SerializedName;

public class Moeda {
    private String nome1;
    private double cotacao1;
    private String nome2;
    private double cotacao2;
    private double quantidade;

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome1() {
        return nome1;
    }

    public void setNome1(String nome1) {
        this.nome1 = nome1;
    }

    public double getCotacao1() {
        return cotacao1;
    }

    public void setCotacao1(double cotacao1) {
        this.cotacao1 = cotacao1;
    }

    public String getNome2() {
        return nome2;
    }

    public void setNome2(String nome2) {
        this.nome2 = nome2;
    }

    public double getCotacao2() {
        return cotacao2;
    }

    public void setCotacao2(double cotacao2) {
        this.cotacao2 = cotacao2;
    }

    @Override
    public String toString() {
        return "A cotação atual é: " +
                "O valor de" + cotacao1 + " " + nome1 + "equivale a" + cotacao2 + " " + nome2 +
                ", logo " + quantidade + " equivale a" + quantidade*cotacao2;
    }
}
