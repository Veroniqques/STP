package com.blog.blog.Service;

import com.blog.blog.Repository.ComRepository;
import com.blog.blog.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComService {
    @Autowired
    private ComRepository comRepository;

    public void create(Comment comment){
        comRepository.save(comment);
    }

    public List<Comment> findAll(){
        return comRepository.findAll();
    }

    public Optional<Comment> findById(Long id){
        return comRepository.findById(id);
    }

    public void updateComment(Comment comment, Long id){
        if (findById(id).isPresent()){
            comment.setId(id);
            comRepository.save(comment);
        }
    }
    public boolean deleteComment(Long id) {
        if (findById(id).isPresent()) {
            comRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void deleteAll(){
        comRepository.deleteAll();
    }

}
