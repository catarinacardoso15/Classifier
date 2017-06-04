package com.classifier.Domain;

/**
 * Created by Catarina Cardoso on 03/06/2017.
 */
public class Rule {
    private String nome;
    private int tipo;

    public Rule() {
    }

    public Rule(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "nome='" + nome + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
