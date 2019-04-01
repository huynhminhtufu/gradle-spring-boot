package FirstSpringBoot.controllers;

import FirstSpringBoot.models.ClassRoom;
import FirstSpringBoot.repositories.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
public class ClassRoomController {
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @GetMapping("/classroom")
    Iterable<ClassRoom> readAll() {
        return classRoomRepository.findAll();
    }

    @GetMapping("/classroom/{id}")
    ClassRoom read(@PathVariable String id) {
        return classRoomRepository.findById(id).orElseThrow(() -> new RuntimeException(("Not Found!")));
    }

    @PostMapping("/classroom")
    ClassRoom create(@RequestBody ClassRoom newClassRoom) {
        if (classRoomRepository.findById(newClassRoom.getId()).isPresent()) {
            return null;
        }

        return classRoomRepository.save(newClassRoom);
    }

    @PutMapping("/classroom/{id}")
    ClassRoom update(@RequestBody ClassRoom updatingClassRoom, @PathVariable String id) {
        return classRoomRepository.findById(id)
                .map(classRoom -> {
                    classRoom.setName(updatingClassRoom.getName());
                    classRoom.setTeacher(updatingClassRoom.getTeacher());
                    classRoom.setAmount(updatingClassRoom.getAmount());

                    return classRoomRepository.save(classRoom);
                })
                .orElseGet(() -> {
                    updatingClassRoom.setId(id);

                    return classRoomRepository.save(updatingClassRoom);
                });
    }

    @DeleteMapping("/classroom/{id}")
    void delete(@PathVariable String id) {
        classRoomRepository.deleteById(id);
    }
}
