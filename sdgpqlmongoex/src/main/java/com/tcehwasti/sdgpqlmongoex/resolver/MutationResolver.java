package com.tcehwasti.sdgpqlmongoex.resolver;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcehwasti.sdgpqlmongoex.model.Subject;
import com.tcehwasti.sdgpqlmongoex.model.Teacher;
import com.tcehwasti.sdgpqlmongoex.repositories.SubjectRepository;
import com.tcehwasti.sdgpqlmongoex.repositories.TeacherRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    private TeacherRepository teacherRepository;
    private SubjectRepository subjectRepository;

  @Autowired
  public MutationResolver(TeacherRepository teacherRepository,SubjectRepository subjectRepository) {
    this.teacherRepository = teacherRepository;
    this.subjectRepository = subjectRepository;
  }

  // first create teacher and then pass teacher id to subject
  public Teacher createTeacher(String name, Integer age) {
    Teacher teacher = new Teacher();
    teacher.setName(name);
    teacher.setAge(age);

    teacherRepository.save(teacher);

    return teacher;
  }

  public Subject createSubject(String title, String description, String teacherId) {
    Subject subject = new Subject();
    subject.setTeacherId(teacherId);
    subject.setTitle(title);
    subject.setDescription(description);

    subjectRepository.save(subject);

    return subject;
  }

  public boolean deleteSubject(String id) {
    subjectRepository.deleteById(id);
    return true;
  }

  public SubjectRepository updateSubject(String id, String title, String description) throws Exception {
    Optional<Subject> optSubject = subjectRepository.findById(id);

    if (optSubject.isPresent()) {
      Subject subject = optSubject.get();

      if (title != null)
        subject.setTitle(title);
      if (description != null)
        subject.setDescription(description);

      subjectRepository.save(subject);
      return subjectRepository;
    }

    throw new Exception("Not found Subject to update!");
  }
    
}
