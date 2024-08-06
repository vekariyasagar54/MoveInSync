package admin.floor.plan.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Room {
  @Id
  private UUID roomId;
  private String floorId;
  private String roomName;
  private String roomType;
  private int capacity;
}
