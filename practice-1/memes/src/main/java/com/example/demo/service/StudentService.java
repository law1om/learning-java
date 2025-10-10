package com.example.demo.service;

import com.example.demo.entity.Meme;
import com.example.demo.entity.Student;
import com.example.demo.repository.MemeRepository;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final MemeRepository memeRepository;

    public Student addStudent(Student student) {
        Meme meme = memeRepository.findByMinScoreLessThanEqualAndMaxScoreGreaterThanEqual(
                student.getScore(), student.getScore()
        );
        student.setMeme(meme);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
