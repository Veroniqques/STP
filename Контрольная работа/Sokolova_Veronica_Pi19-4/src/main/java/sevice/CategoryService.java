package sevice;

import entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CategoryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepository;

    public void create(Category category){
        categoryRepository.save(category);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }



    public boolean delete(Long id){
        if (findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

}
