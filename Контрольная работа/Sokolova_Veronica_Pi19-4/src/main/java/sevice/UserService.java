package sevice;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepo;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    UserRepo userRepo;

    public void create(User user){
        UserRepo.save(user);
    }

    public List<User> findAll(){
        return UserRepo.findAll();
    }

    public Optional<User> findById(Long id){
        return UserRepo.findById(id);
    }


    public boolean delete(Long id) {
        if (findById(id).isPresent()) {
            UserRepo.deleteById(id);
        }
        return false;
    }
}
