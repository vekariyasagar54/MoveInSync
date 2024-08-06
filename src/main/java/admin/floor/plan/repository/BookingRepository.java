package admin.floor.plan.repository;

import admin.floor.plan.model.Booking;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
  List<Booking> findByRoomIdAndDateTimeBetween(String roomId, LocalDateTime start, LocalDateTime end);
}
