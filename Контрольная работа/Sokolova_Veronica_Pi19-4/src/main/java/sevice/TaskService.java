package sevice;


import entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.TaskRepo;

import java.util.List;
import java.util.Optional;

@Service

public class TaskService {
    @Autowired
    private TaskRepo taskRepository;

    public void create(Task task){
        taskRepository.save(task);
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }



    public boolean delete(Long id){
        if (findById(id).isPresent()) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

}
