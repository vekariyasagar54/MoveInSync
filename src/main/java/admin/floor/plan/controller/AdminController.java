package admin.floor.plan.controller;

import admin.floor.plan.model.Floor;
import admin.floor.plan.model.FloorPlanRequest;
import admin.floor.plan.model.Room;
import admin.floor.plan.service.AdminService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

  private final AdminService adminService;

  // Endpoint to upload a floor plan
  @PostMapping("/floor-plan/upload")
  public List<Floor> uploadFloorPlan(@RequestBody FloorPlanRequest request, @RequestParam("floorName") String floorName) {
    return adminService.uploadFloorPlan(request, floorName);
  }

  // Endpoint to add a room to a floor
  @PostMapping("/floors/{floorId}/rooms")
  public Room addRoomToFloor(@PathVariable String floorId, @RequestParam String roomName, @RequestParam String roomType,
      @RequestParam int capacity) {
    return adminService.addRoomToFloor(floorId, roomName, roomType, capacity);
  }

  // Endpoint to get all floors with rooms
  @GetMapping("/floors")
  public List<Floor> getAllFloors() {
    return adminService.getAllFloors();
  }
}
