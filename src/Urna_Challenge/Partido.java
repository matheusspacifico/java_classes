package Urna_Challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Partido {
    private final int numero;
    private final String nome;

    private final Map<Integer, Candidato> presidente;
    private final Map<Integer, Candidato> governador;
    private final Map<Integer, Candidato> senador;
    private final Map<Integer, Candidato> deputadoEstadual;
    private final Map<Integer, Candidato> deputadoFederal;

    public Partido(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        this.presidente = new HashMap<>();
        this.governador = new HashMap<>();
        this.senador = new HashMap<>();
        this.deputadoEstadual = new HashMap<>();
        this.deputadoFederal = new HashMap<>();
    }

    public void addCandidato(Candidato candidato) {
        Cargo cargo = candidato.getCargo();
        int numero = candidato.getNumero();

        if (cargo == Cargo.PRESIDENTE) presidente.put(numero, candidato);
        else if (cargo == Cargo.GOVERNADOR) governador.put(numero, candidato);
        else if (cargo == Cargo.SENADOR) senador.put(numero, candidato);
        else if (cargo == Cargo.DEPUTADO_ESTADUAL) deputadoEstadual.put(numero, candidato);
        else if (cargo == Cargo.DEPUTADO_FEDERAL) deputadoFederal.put(numero, candidato);
        else throw new IllegalArgumentException("Cargo invalido");
    }

    public Candidato getCandidato(Cargo cargo, int numCandidato){
        if (cargo == Cargo.PRESIDENTE) return presidente.get(numCandidato);
        else if (cargo == Cargo.GOVERNADOR) return governador.get(numCandidato);
        else if (cargo == Cargo.SENADOR) return senador.get(numCandidato);
        else if (cargo == Cargo.DEPUTADO_FEDERAL) return deputadoFederal.get(numCandidato);
        else if (cargo == Cargo.DEPUTADO_ESTADUAL) return deputadoEstadual.get(numCandidato);
        else throw new IllegalArgumentException("Cargo inválido!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return numero == partido.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public Map<Integer, Candidato> getCandidatosMap(Cargo cargo) {
        return switch (cargo) {
            case PRESIDENTE -> Map.copyOf(presidente);
            case GOVERNADOR -> Map.copyOf(governador);
            case SENADOR -> Map.copyOf(senador);
            case DEPUTADO_ESTADUAL -> Map.copyOf(deputadoEstadual);
            case DEPUTADO_FEDERAL -> Map.copyOf(deputadoFederal);
            default -> throw new IllegalArgumentException("Cargo inválido!");
        };
    }
}
