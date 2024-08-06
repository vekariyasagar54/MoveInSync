package admin.floor.plan.service;

import admin.floor.plan.model.Booking;
import admin.floor.plan.model.Room;
import admin.floor.plan.repository.BookingRepository;
import admin.floor.plan.repository.RoomRepository;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
  
  private final RoomRepository roomRepository;
  private final BookingRepository bookingRepository;

  public List<Room> findAvailableRooms(LocalDateTime dateTime, int participants) {
    List<Room> rooms = roomRepository.findByRoomType("MEETING_ROOM");

    return rooms.stream()
        .filter(room -> room.getCapacity() >= participants)
        .filter(room -> isRoomAvailable(room.getRoomId().toString(), dateTime))
        .collect(Collectors.toList());
  }

  private boolean isRoomAvailable(String roomId, LocalDateTime dateTime) {
    LocalDateTime start = dateTime.minusHours(1);
    LocalDateTime end = dateTime.plusHours(1);

    List<Booking> bookings = bookingRepository.findByRoomIdAndDateTimeBetween(roomId, start, end);
    return bookings.isEmpty();
  }

  public Booking bookRoom(String roomId, LocalDateTime dateTime, int participants) {
    if (isRoomAvailable(roomId, dateTime)) {
      Booking booking = new Booking();
      booking.setRoomId(roomId);
      booking.setDateTime(dateTime.toInstant(ZoneOffset.UTC));
      booking.setParticipants(participants);

      return bookingRepository.save(booking);
    }
    throw new RuntimeException("Room is not available at the specified time.");
  }

  public Room recommendRoom(LocalDateTime dateTime, int participants) {
    List<Room> availableRooms = findAvailableRooms(dateTime, participants);

    return availableRooms.stream()
        .sorted((r1, r2) -> Integer.compare(r1.getCapacity(), r2.getCapacity()))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("No suitable room available"));
  }
}

