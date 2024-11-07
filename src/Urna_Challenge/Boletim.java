package Urna_Challenge;

import java.util.List;

public final class Boletim {

    public static String emitir(String nomeCargo, List<Candidato> candidatos, int brancos, int nulos) {
        StringBuilder boletim = new StringBuilder();
        boletim.append("================ JUSTIÇA ELEITORAL ==============\n");
        boletim.append("Boletim de Urna\n");
        boletim.append("------------------------------").append(nomeCargo).append("------------------------------\n");
        boletim.append("Nome\t\tNúmero\tVotos\n");

        List<Candidato> candidatosComVotos = candidatos.stream()
                .filter(c -> c.getVotos() > 0)
                .sorted((c1, c2) -> Integer.compare(c2.getVotos(), c1.getVotos()))
                .toList();

        int votosNominais = candidatosComVotos.stream().mapToInt(Candidato::getVotos).sum();

        candidatosComVotos.forEach(c -> {
            boletim.append(Utilitario.textoFixo(c.getNomeUrna(), 10))
                    .append("\t")
                    .append(c.getNumero())
                    .append("\t")
                    .append(c.getVotos()).append("\n");
        });

        int totalApurado = votosNominais + brancos + nulos;
        boletim.append("----------------------------------------------------------------------------\n");
        boletim.append("Total de votos Nominais: ").append(votosNominais).append("\n");
        boletim.append("Brancos: ").append(brancos).append("\n");
        boletim.append("Nulos: ").append(nulos).append("\n");
        boletim.append("Total apurado: ").append(totalApurado).append("\n");
        boletim.append("---------------------------------------------------------------------------\n");

        return boletim.toString();
    }
}
