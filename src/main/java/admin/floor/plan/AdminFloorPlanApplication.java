package admin.floor.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class AdminFloorPlanApplication {

  public static void main(String[] args) {
    System.out.println("AdminFloorPlanApplication Started");
    SpringApplication.run(AdminFloorPlanApplication.class, args);
  }

}