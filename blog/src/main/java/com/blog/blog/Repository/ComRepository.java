package com.blog.blog.Repository;

import com.blog.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComRepository extends JpaRepository<Comment, Long>  {
}
