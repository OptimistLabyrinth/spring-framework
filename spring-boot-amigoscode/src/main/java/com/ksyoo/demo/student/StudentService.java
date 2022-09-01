package com.ksyoo.demo.student;

import com.ksyoo.demo.exception.DuplicateEntity;
import com.ksyoo.demo.exception.EntityNotFound;
import com.ksyoo.demo.exception.RequestBodyIncomplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        List<Student> students = studentRepository.findAll();
        students.sort((a, b) -> (int) (a.getId() - b.getId()));
        return students;
    }

    public Student addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent())
            throw new DuplicateEntity("email taken by another student");
        return studentRepository.save(student);
    }

    public Student deleteStudent(Long id) {
        Student studentById = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("student not found"));
        studentRepository.delete(studentById);
        return studentById;
    }

    public Student updateStudent(Long studentId, StudentUpdateParam updateParam) {
        if (updateParam == null)
            throw new RequestBodyIncomplete("data for update missing");

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFound("student not found"));

        Optional<String> name = updateParam.getName();
        if (name.isPresent()) {
            String nameValue = name.get().trim();
            if (0 < nameValue.length() && !Objects.equals(student.getName(), nameValue)) {
                student.setName(nameValue);
            }
        }

        Optional<String> email = updateParam.getEmail();
        if (email.isPresent()) {
            String emailValue = email.get().trim();
            if (0 < emailValue.length() && !Objects.equals(student.getEmail(), emailValue)) {
                student.setEmail(emailValue);
            }
        }

        return studentRepository.save(student);
    }

}
