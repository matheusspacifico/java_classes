package Hotel_Challenge;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Criação de alguns quartos
        Room room101 = new Room(101, 200.00);
        Room room102 = new Room(102, 250.00);
        Room room103 = new Room(103, 150.00);

        Room[] rooms = {room101, room102, room103};

        // Criação do hotel
        Hotel hotel = new Hotel(rooms);

        // Criação de alguns hóspedes
        Guest guest1 = new Guest("123-45-6789", "alice@example.com", "Alice Smith");
        Guest guest2 = new Guest("987-65-4321", "bob@example.com", "Bob Johnson");

        // Fazer reservas
        try {
            Reservation reservation1 = hotel.makeReservation(guest1, 101, LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 5));
            System.out.println("Reserva 1 criada com sucesso:");
            System.out.println(reservation1.asString());

            Reservation reservation2 = hotel.makeReservation(guest2, 102, LocalDate.of(2024, 10, 3), LocalDate.of(2024, 10, 7));
            System.out.println("Reserva 2 criada com sucesso:");
            System.out.println(reservation2.asString());

            // Verificar disponibilidade
            System.out.println("Quartos disponíveis em 2024-10-04:");
            Room[] availableRooms = hotel.getRoomsAvailableAt(LocalDate.of(2024, 10, 4));
            for (Room room : availableRooms) {
                System.out.println(room.asString());
            }

            // Cancelar uma reserva
            System.out.println("Cancelando a reserva 1...");
            hotel.cancelReservation(reservation1.getId());
            System.out.println("Reserva 1 cancelada com sucesso.");

            // Verificar disponibilidade novamente
            System.out.println("Quartos disponíveis em 2024-10-04 após o cancelamento:");
            availableRooms = hotel.getRoomsAvailableAt(LocalDate.of(2024, 10, 4));
            for (Room room : availableRooms) {
                System.out.println(room.asString());
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
