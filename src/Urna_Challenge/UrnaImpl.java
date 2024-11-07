package Urna_Challenge;

import java.util.*;
import java.util.stream.Collectors;

import static Urna_Challenge.Utilitario.carregarCandidatos;
import static Urna_Challenge.Utilitario.textoFixo;

public class UrnaImpl implements Urna {
    private int nulos;
    private int brancos;

    private final Map<Integer, Partido> partidos;

    public UrnaImpl() {
        this.partidos = new HashMap<>();
        this.nulos = 0;
        this.brancos = 0;
        carregar();
    }

    @Override
    public void carregar() {
        List<String> candidatos = carregarCandidatos();
        candidatos.remove(0);

        for (String candidato : candidatos) {
            String[] info = candidato.split(";");

            String nomeCandidato = info[0];
            String nomeUrna = info[1];

            Cargo cargo = switch (info[2].toUpperCase()){
                case "PRESIDENTE" -> Cargo.PRESIDENTE;
                case "GOVERNADOR" -> Cargo.GOVERNADOR;
                case "SENADOR" -> Cargo.SENADOR;
                case "DEPUTADO FEDERAL" -> Cargo.DEPUTADO_FEDERAL;
                case "DEPUTADO ESTADUAL" -> Cargo.DEPUTADO_ESTADUAL;
                default -> throw new IllegalStateException("Cargo inválido: " + info[2]);
            };

            int numeroCandidato = Integer.parseInt(info[3]);
            int numeroPartido = Integer.parseInt(info[3].substring(0, 2));
            String nomePartido = info[4];

            Partido partido = partidos.computeIfAbsent(numeroPartido, n -> new Partido(numeroPartido, nomePartido));

            Candidato _candidato = new Candidato(nomeUrna, numeroCandidato, nomeCandidato, cargo);

            partido.addCandidato(_candidato);
        }

        imprimirPartidos();
        imprimirCandidatos();
    }

    @Override
    public void votar() {
        Scanner scanner = new Scanner(System.in);

        for (Cargo cargo : Cargo.values()){
            boolean votoConfirmado = false;

            while (!votoConfirmado) {
                switch (cargo) {
                    case DEPUTADO_FEDERAL -> System.out.print("Deputado Federal [4 ");
                    case DEPUTADO_ESTADUAL -> System.out.print("Deputado Estadual [5 ");
                    case SENADOR -> System.out.print("Senador [3 ");
                    case GOVERNADOR -> System.out.print("Governador [2 ");
                    case PRESIDENTE -> System.out.print("Presidente [2 ");
                }
                System.out.print("números | BRANCO]: ");

                String candidatoNum = scanner.nextLine();

                if (candidatoNum.equals("BRANCO")) {
                    brancos++;
                    System.out.println("Voto BRANCO confirmado.");
                    votoConfirmado = true;
                } else {
                    if (!partidos.containsKey(Integer.parseInt(candidatoNum.substring(0, 2)))) {
                        System.out.println("Partido inexistente. Registrando voto NULO...");
                        nulos++;
                        votoConfirmado = true;
                        continue;
                    }
                    Partido partido = partidos.get(Integer.parseInt(candidatoNum.substring(0, 2)));

                    Candidato candidato = partido.getCandidato(cargo, Integer.parseInt(candidatoNum));

                    if (candidato != null){
                        System.out.printf("Nome: %s\tPartido: %s (%d)%n", candidato.getNomeUrna(), partido.getNome(), candidato.getNumero());
                        System.out.print("[CORRIGE | CONFIRMA]: ");
                        String res = scanner.nextLine();
                        switch (res) {
                            case "CORRIGE" -> {
                                continue;
                            }
                            case "CONFIRMA" -> {
                                candidato.receberVotos();
                                votoConfirmado = true;
                                break;
                            }
                            default -> System.out.println("Opção inválida! Tente novamente.");
                        }
                    } else {
                        System.out.println("Candidato inexistente. Registrando voto NULO...");
                        nulos++;
                        votoConfirmado = true;
                    }
                }
            }
        }
    }

    @Override
    public void imprimir() {
        for (Cargo cargo : Cargo.values()) {
            List<Candidato> candidatos = partidos.values().stream()
                    .flatMap(partido -> partido.getCandidatosMap(cargo).values().stream())
                    .collect(Collectors.toList());
            String boletimCargo = Boletim.emitir(cargo.name(), candidatos, brancos, nulos);
            System.out.print(boletimCargo);
        }
    }

    private void imprimirPartidos() {
        StringBuilder sb = new StringBuilder("-------------------PARTIDOS-------------------\n");
        sb.append(textoFixo("Número", 20)).append(textoFixo("Nome", 10)).append("\n");

        partidos.values().forEach(partido -> sb.append(textoFixo(String.valueOf(partido.getNumero()), 20))
                .append(textoFixo(partido.getNome(), 10)).append("\n"));

        sb.append("-------------------PARTIDOS-------------------\n");

        System.out.println(sb.toString());
    }

    private void imprimirCandidatos() {
        StringBuilder sb = new StringBuilder();

        partidos.values().forEach(partido -> {
            sb.append("\n------------------- PARTIDO: ").append(partido.getNome())
                    .append(" -------------------\n");

            for (Cargo cargo : Cargo.values()) {
                sb.append("\n---------------------- CANDIDATOS A ")
                        .append(cargo.toString().replace('_', ' '))
                        .append(" ---------------------\n");
                sb.append(textoFixo("Nome", 30))
                        .append(textoFixo("Cargo", 20))
                        .append(textoFixo("Número", 10))
                        .append("Partido\n");

                Map<Integer, Candidato> candidatos = partido.getCandidatosMap(cargo);

                candidatos.values()
                        .forEach(candidato -> sb.append(textoFixo(candidato.getNomeUrna(), 30))
                                .append(textoFixo(cargo.toString(), 20))
                                .append(textoFixo(String.valueOf(candidato.getNumero()), 10))
                                .append(partido.getNome()) // Nome do partido
                                .append("\n"));
            }
        });

        System.out.println(sb.toString());
    }

}
