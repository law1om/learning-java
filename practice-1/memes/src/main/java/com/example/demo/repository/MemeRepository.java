package com.example.demo.repository;

import com.example.demo.entity.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemeRepository extends JpaRepository<Meme, Long> {
    Meme findByMinScoreLessThanEqualAndMaxScoreGreaterThanEqual(int min, int max);
}
