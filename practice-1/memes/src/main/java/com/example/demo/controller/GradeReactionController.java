package com.example.demo.controller;

import com.example.demo.entity.GradeReaction;
import com.example.demo.entity.Student;
import com.example.demo.repository.GradeReactionRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class GradeReactionController {

    @Autowired
    private GradeReactionRepository gradeReactionRepository;

    @Autowired
    private StudentRepository studentRepository;

    // === Простой HTML интерфейс ===
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("reactions", gradeReactionRepository.findAll());
        return "index";
    }

    // === Добавление реакции с картинкой ===
    @PostMapping(value = "/reaction", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addReaction(@RequestParam("description") String description,
                              @RequestParam("image") MultipartFile image) throws IOException {
        String uploadDir = "uploads/";
        File folder = new File(uploadDir);
        if (!folder.exists()) folder.mkdirs();

        String filePath = uploadDir + image.getOriginalFilename();
        image.transferTo(new File(filePath));

        GradeReaction reaction = new GradeReaction(description, filePath);
        gradeReactionRepository.save(reaction);

        return "redirect:/";
    }

    // === Добавление студента ===
    @PostMapping("/student")
    public String addStudent(@RequestParam String name,
                             @RequestParam int score,
                             @RequestParam Long reactionId) {
        GradeReaction reaction = gradeReactionRepository.findById(reactionId).orElse(null);
        Student student = new Student(name, score, null, reaction);
        studentRepository.save(student);
        return "redirect:/";
    }

    // === Удаление студента ===
    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }
}
