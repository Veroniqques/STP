package controllers;

import entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sevice.TaskService;

import java.util.List;
import java.util.Optional;

@RestController

public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public void createTask(@RequestBody Task task){
        taskService.create(task);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> findAll(){
        final List<Task> taskList = taskService.findAll();

        if (taskList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(taskList, HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Optional<Task>> findById(@PathVariable(name = "id") Long id ) {
        final Optional<Task> task = taskService.findById(id);

        if (task.isPresent()) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        if (taskService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

}
