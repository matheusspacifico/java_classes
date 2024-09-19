package Hotel_Challenge;

import java.time.LocalDate;

public class Hotel {

    private final Room[] rooms;
    private Reservation[] reservations;
    private int reservationCount;

    public Hotel(Room[] rooms) {
        this.rooms = rooms;

        this.reservations = new Reservation[10];
        this.reservationCount = 0;
    }

    public Reservation makeReservation(Guest guest, int roomNumber, LocalDate checkin, LocalDate checkout) {
        Room room = findRoomByNumber(roomNumber);
        if (room == null) {
            throw new IllegalArgumentException("Room number " + roomNumber + " does not exist.");
        }

        if (!isAvailableAt(room, checkin, checkout)) {
            throw new IllegalStateException("Room " + roomNumber + " is not available from " + checkin + " to " + checkout + ".");
        }

        if (reservationCount == reservations.length) {
            expandReservationsArray();
        }

        Reservation reservation = new Reservation(guest, room, checkin, checkout);
        reservations[reservationCount++] = reservation;
        return reservation;
    }

    public void cancelReservation(String reservationId) {
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i].getId().equals(reservationId)) {

                for (int j = i; j < reservationCount - 1; j++) {
                    reservations[j] = reservations[j + 1];
                }
                reservations[--reservationCount] = null;
                return;
            }
        }
        throw new IllegalArgumentException("Reservation ID " + reservationId + " does not exist.");
    }

    public Room[] getRoomsAvailableAt(LocalDate date) {
        Room[] availableRooms = new Room[rooms.length];
        int count = 0;
        for (Room room : rooms) {
            if (isAvailableAt(room, date, date.plusDays(1))) {
                availableRooms[count++] = room;
            }
        }
        Room[] result = new Room[count];
        System.arraycopy(availableRooms, 0, result, 0, count);
        return result;
    }

    private boolean isAvailableAt(Room room, LocalDate checkin, LocalDate checkout) {
        for (int i = 0; i < reservationCount; i++) {
            if (reservations[i].isReservedAt(checkin, room) || reservations[i].isReservedAt(checkout.minusDays(1), room)) {
                return false;
            }
        }
        return true;
    }

    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    private void expandReservationsArray() {
        Reservation[] newReservations = new Reservation[reservations.length * 2];
        System.arraycopy(reservations, 0, newReservations, 0, reservations.length);
        reservations = newReservations;
    }
}
