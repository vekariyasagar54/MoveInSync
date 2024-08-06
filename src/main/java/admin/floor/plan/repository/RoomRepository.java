package admin.floor.plan.repository;

import admin.floor.plan.model.Room;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
  List<Room> findByRoomType(String roomType);
}

