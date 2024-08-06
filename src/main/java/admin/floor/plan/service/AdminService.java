package admin.floor.plan.service;

import static java.util.UUID.randomUUID;

import admin.floor.plan.model.Floor;
import admin.floor.plan.model.FloorPlanRequest;
import admin.floor.plan.model.Room;
import admin.floor.plan.repository.FloorRepository;
import admin.floor.plan.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AdminService {

  private final FloorRepository floorRepository;
  private final RoomRepository roomRepository;

  public List<Floor> uploadFloorPlan(FloorPlanRequest request, String floorName) {

    Floor floor = Floor.builder().floorId(randomUUID()).floorName(floorName).build();
    floor.setFloorName(floorName);

    floorRepository.save(floor);
    return floorRepository.findAll();
  }

  // Method to add a room to a specific floor
  public Room addRoomToFloor(String floorId, String roomName, String roomType, int capacity) {
    Room room = new Room();
    room.setRoomId(randomUUID());
    room.setFloorId(floorId);
    room.setRoomName(roomName);
    room.setRoomType(roomType);
    room.setCapacity(capacity);

    return roomRepository.save(room);
  }

  public List<Floor> getAllFloors() {
    return floorRepository.findAll();
  }
}

