package admin.floor.plan.repository;

import admin.floor.plan.model.Floor;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, UUID> {}
