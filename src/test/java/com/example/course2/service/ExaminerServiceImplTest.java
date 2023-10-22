package com.example.course2.service;

import com.example.course2.dto.Question;
import com.example.course2.exception.NotEnoughQuestionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl underTest;
    int amount = 2;

    @Test
    void getQuestions_shouldThrowExceptionWhenNotEnoughQuestions() {
        when(questionService.getAll()).thenReturn(Collections.emptySet());
        assertThrows(NotEnoughQuestionException.class,
                () -> underTest.getQuestions(amount));
    }

    @Test
    void getQuestions_shouldReturnUniqueQuestionsCollection() {
        Question question = new Question("question", "answer");
        Question question1 = new Question("question1", "answer1");
        Set<Question> questions = Set.of(question, question1);

        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(question, question1);

        Collection<Question> result = underTest.getQuestions(amount);
        assertEquals(questions, result);
        assertEquals(amount, result.stream().distinct().count());
    }
}