package Urna_Challenge;

import java.util.Objects;

public class Candidato {
    private final String nomeUrna;
    private final String nomeCompleto;
    private final int numero;
    private int votos;
    private final Cargo cargo;

    public Candidato(String nomeUrna, int numero, String nomeCompleto, Cargo cargo) {
        this.nomeUrna = nomeUrna;
        this.numero = numero;
        this.nomeCompleto = nomeCompleto;
        this.votos = 0;
        this.cargo = cargo;
    }

    public void receberVotos(){
        votos++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return numero == candidato.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }

    public int getNumero() {
        return numero;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getNomeUrna() {
        return nomeUrna;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public int getVotos() {
        return votos;
    }
}
