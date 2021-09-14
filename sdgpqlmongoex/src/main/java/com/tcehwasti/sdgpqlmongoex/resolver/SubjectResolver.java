package com.tcehwasti.sdgpqlmongoex.resolver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tcehwasti.sdgpqlmongoex.model.Subject;
import com.tcehwasti.sdgpqlmongoex.model.Teacher;
import com.tcehwasti.sdgpqlmongoex.repositories.TeacherRepository;


@Component
public class SubjectResolver implements GraphQLResolver<Subject>{
    
    @Autowired
  private TeacherRepository teacherRepository;

  public SubjectResolver(TeacherRepository teacherRepository) {
    this.teacherRepository = teacherRepository;
  }

  public Teacher getAuthor(Subject subject) {
    return teacherRepository.findById(subject.getTeacherId()).orElseThrow(null);
  }
}
