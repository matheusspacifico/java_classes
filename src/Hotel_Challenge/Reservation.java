package Hotel_Challenge;

import java.time.LocalDate;
import java.time.Period;

import static Hotel_Challenge.util.ReservationIdGenerator.generateId;

public class Reservation {
    private final String id;
    private final LocalDate checkin;
    private final LocalDate checkout;

    private final Room room;
    private final Guest guest;

    public Reservation(Guest guest, Room room, LocalDate checkin, LocalDate checkout) {
        this.guest = guest;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;

        this.id = generateId();
    }

    public double getPrice(){
        int days = Period.between(checkin, checkout).getDays();

        if (days == 0){
            return room.getPrice();
        }

        return room.getPrice() * days;
    }

    public boolean isReservedAt(LocalDate date, Room room){
        if (room != this.room){
            return false;
        }

        return (date.isEqual(checkin) || date.isAfter(checkin)) && date.isBefore(checkout);
    }

    public String asString(){

        return "----------------------------------------------------\n" +
                "Reservation: " + id + "\t" + "Room number: " + room.getNumber() + "\n" +
                "Guest name: " + guest.getName() + "\t" + "SSN: " + guest.getSsn() + "\t" + "E-mail: " + guest.getEmail() + "\n" +
                "Check-in: " + checkin + "\t" + "Check-out: " + checkout + "\n" +
                "Number of days: " + Period.between(checkin, checkout).getDays() + "\t" + "Room price: " + "R$" + room.getPrice() + "\n" +
                "TOTAL: " + "R$" + getPrice() + ";\n" +
                "----------------------------------------------------\n";
    }

    public String getId() {
        return id;
    }
}
