package com.tcehwasti.sdgpqlmongoex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subjects")
public class Subject {
    
    @Id
    private String id;
    private String title;
    private String description;
    private String teacher_id;
  
    public Subject() {
    }
  
    public Subject(String title, String description, String teacher_id) {
      this.title = title;
      this.description = description;
      this.teacher_id = teacher_id;
    }
  
    public String getId() {
      return id;
    }
  
    public String getTitle() {
      return title;
    }
  
    public void setTitle(String title) {
      this.title = title;
    }
  
    public String getDescription() {
      return description;
    }
  
    public void setDescription(String description) {
      this.description = description;
    }
  
    public String getTeacherId() {
      return teacher_id;
    }
  
    public void setTeacherId(String teacher_id) {
      this.teacher_id = teacher_id;
    }
  
    @Override
    public String toString() {
      return "Subject [id=" + id + ", title=" + title + ", description=" + description + ", teacher_id=" + teacher_id + "]";
    }
}
