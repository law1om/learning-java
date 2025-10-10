package com.example.demo.controller;

import com.example.demo.entity.Meme;
import com.example.demo.repository.MemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/memes")
@CrossOrigin
@RequiredArgsConstructor
public class MemeController {

    private final MemeRepository memeRepository;

    @GetMapping
    public List<Meme> getAllMemes() {
        return memeRepository.findAll();
    }

    @GetMapping("/random")
    public Meme getRandomMeme() {
        List<Meme> memes = memeRepository.findAll();
        if (memes.isEmpty()) return null;
        return memes.get(new Random().nextInt(memes.size()));
    }
    @PostMapping
    public Meme addMeme(@RequestBody Meme meme) {
        return memeRepository.save(meme);
    }

}
