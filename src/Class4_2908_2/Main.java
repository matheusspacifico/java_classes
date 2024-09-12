package Class4_2908_2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Criando um novo agendamento para um dia específico com horário de trabalho
        LocalDate today = LocalDate.now();
        LocalTime workStart = LocalTime.of(9, 0); // Início do horário de trabalho às 09:00
        LocalTime workEnd = LocalTime.of(17, 0);  // Fim do horário de trabalho às 17:00

        Schedule schedule = new Schedule(today, workStart, workEnd);

        // Criando reuniões para adicionar ao agendamento
        Meeting meeting1 = new Meeting("Team Meeting", LocalTime.of(10, 0), LocalTime.of(11, 0));
        Meeting meeting2 = new Meeting("Client Call", LocalTime.of(11, 0), LocalTime.of(12, 0));
        Meeting meeting3 = new Meeting("Lunch Break", LocalTime.of(12, 30), LocalTime.of(13, 0));
        Meeting meeting4 = new Meeting("Project Review", LocalTime.of(14, 0), LocalTime.of(15, 0));
        Meeting meeting5 = new Meeting("End of Day Wrap-up", LocalTime.of(16, 0), LocalTime.of(16, 30));
        Meeting overlappingMeeting = new Meeting("Overlapping Meeting", LocalTime.of(10, 30), LocalTime.of(11, 30));
        Meeting outsideMeeting = new Meeting("Outside Working Hours", LocalTime.of(8, 0), LocalTime.of(9, 0));

        // Adicionando reuniões e verificando a saída
        System.out.println("\n--- Adding Meetings ---");
        schedule.addMeeting(meeting1); // Deveria adicionar com sucesso
        schedule.addMeeting(meeting2); // Deveria adicionar com sucesso
        schedule.addMeeting(meeting3); // Deveria adicionar com sucesso
        schedule.addMeeting(meeting4); // Deveria adicionar com sucesso
        schedule.addMeeting(meeting5); // Deveria adicionar com sucesso

        // Tentativa de adicionar uma reunião que se sobrepõe
        schedule.addMeeting(overlappingMeeting); // Deve falhar devido à sobreposição

        // Tentativa de adicionar uma reunião fora do horário de trabalho
        schedule.addMeeting(outsideMeeting); // Deve falhar por estar fora do horário de trabalho

        // Exibindo o agendamento atual como string
        System.out.println("\n--- Current Schedule ---");
        System.out.println(schedule.scheduleAsString());

        // Testando a remoção de uma reunião existente
        System.out.println("\n--- Removing a Meeting ---");
        schedule.removeMeeting(meeting3); // Deve remover com sucesso

        // Tentativa de remover uma reunião que não está agendada
        schedule.removeMeeting(outsideMeeting); // Deve falhar pois não está agendada

        // Exibindo o agendamento atualizado
        System.out.println("\n--- Updated Schedule ---");
        System.out.println(schedule.scheduleAsString());

        // Exibindo a porcentagem de tempo gasto em reuniões
        System.out.println("\n--- Percentage of Time Spent in Meetings ---");
        System.out.printf("Percentage: %.2f%%\n", schedule.percentageSpentInMeetings());
    }
}
