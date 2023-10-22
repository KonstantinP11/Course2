package com.example.course2.service;

import com.example.course2.dto.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
@Service
public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
