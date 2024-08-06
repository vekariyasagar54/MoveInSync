package admin.floor.plan.controller;

import admin.floor.plan.model.Booking;
import admin.floor.plan.model.Room;
import admin.floor.plan.service.RoomService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rooms")
public class RoomController {
  
  private final RoomService roomService;

  @GetMapping("/available")
  public List<Room> getAvailableRooms(@RequestParam int participants, @RequestParam String dateTime) {
    LocalDateTime date = LocalDateTime.parse(dateTime);
    return roomService.findAvailableRooms(date, participants);
  }

  @PostMapping("/book")
  public Booking bookRoom(@RequestParam String roomId, @RequestParam int participants,
      @RequestParam String dateTime) {
    LocalDateTime date = LocalDateTime.parse(dateTime);
    return roomService.bookRoom(roomId, date, participants);
  }

  @GetMapping("/recommend")
  public Room recommendRoom(@RequestParam int participants, @RequestParam String dateTime) {
    LocalDateTime date = LocalDateTime.parse(dateTime);
    return roomService.recommendRoom(date, participants);
  }
}

