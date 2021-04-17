package com.tcehwasti.sdgpqlmongoex.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tcehwasti.sdgpqlmongoex.model.Teacher;

public interface TeacherRepository  extends MongoRepository<Teacher, String>{
    
}
