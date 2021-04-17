package com.tcehwasti.sdgpqlmongoex.repositories;

import com.tcehwasti.sdgpqlmongoex.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SubjectRepository  extends MongoRepository<Subject, String>{
    
}
