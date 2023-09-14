package com.prodapt.learningspring.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.prodapt.learningspring.controller.ClassroomDbConnect;

@Component
public class Classroom {
  
  private ClassroomDbConnect DbConnect = new ClassroomDbConnect();
  private List<Student> students;
  private static int idCounter = 1;

  public Classroom() {
    students = new ArrayList<>();
  }
  
  public List<Student> getStudents() {
	  students = DbConnect.retrieveStudentList();
	  rank();
	  return students;   
//    return Collections.unmodifiableList(students);
  }
  
  public void deleteStudent(int id) {
	  DbConnect.deleteStudent(id);
  }

  private void rank() {
    Collections.sort(students, (s1, s2) -> -Integer.compare(s1.getScore(), s2.getScore()));
    for (int i = 0; i < students.size(); i++)
      students.get(i).setRank(i + 1);
    for (int i = 1; i < students.size(); i++) {
      if (students.get(i).getScore() == students.get(i-1).getScore())
        students.get(i).setRank(students.get(i-1).getRank());
    }
  }

  public void add(Student student) {
    student.setId(idCounter++);
    students.add(student);
    rank();
  }
  
  public void remove(int idx) {
    students.remove(idx);
    rank();
  }
  
  public void updateData(Student student) {
	  DbConnect.updateStudent(student.getId(), student.getName(), student.getScore());
  }
  
  public void replace(int id, Student current) {
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getId() == id) {
        students.get(i).setName(current.getName());
        students.get(i).setScore(current.getScore());
      }
    }
    rank();
  }
  
  public Optional<Student> getById(int id) {
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getId() == id)
        return Optional.of(students.get(i));
    }
    return Optional.empty();
  }


}
