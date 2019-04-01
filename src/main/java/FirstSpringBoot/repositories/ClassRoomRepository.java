package FirstSpringBoot.repositories;

import FirstSpringBoot.models.ClassRoom;
import org.springframework.data.repository.CrudRepository;

public interface ClassRoomRepository extends CrudRepository<ClassRoom, String> {

}
