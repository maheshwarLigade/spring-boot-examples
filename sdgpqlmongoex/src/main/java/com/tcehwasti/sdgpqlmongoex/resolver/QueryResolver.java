package com.tcehwasti.sdgpqlmongoex.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tcehwasti.sdgpqlmongoex.model.Subject;
import com.tcehwasti.sdgpqlmongoex.model.Teacher;
import com.tcehwasti.sdgpqlmongoex.repositories.SubjectRepository;
import com.tcehwasti.sdgpqlmongoex.repositories.TeacherRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    
    private TeacherRepository teacherRepository;
    private SubjectRepository subjectRepository;
  
    @Autowired
    public QueryResolver(TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
      this.teacherRepository = teacherRepository;
      this.subjectRepository = subjectRepository;
    }
  
    public Iterable<Teacher> findAllTeachers() {
      return teacherRepository.findAll();
    }
  
    public Iterable<Subject> findAllSubjects() {
      return subjectRepository.findAll();
    }
  
    public long countTeachers() {
      return teacherRepository.count();
    }
  
    public long countSubjects() {
      return subjectRepository.count();
    }
}
