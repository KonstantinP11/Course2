package com.example.course2.service;

import com.example.course2.dto.Question;
import com.example.course2.exception.NotEnoughQuestionException;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService underTest = new JavaQuestionService();
    private Question question = new Question("question", "answer");

    @Test
    void add_shouldAddQuestionToSetAndReturnQuestion() {
        Question result = underTest.add(question.getQuestion(), question.getAnswer());
        assertTrue(underTest.getAll().contains(question));
        assertEquals(question, result);
    }

    @Test
    void remove_shouldRemoveQuestionFromSetAndReturnQuestion() {
        Question result = underTest.remove(question);
        assertFalse(underTest.getAll().contains(question));
        assertEquals(question, result);
    }

    @Test
    void getAll_shouldReturnCollectionQuestions() {
        Question question1 = new Question("question1", "answer1");
        underTest.add(question);
        underTest.add(question1);
        Collection<Question> result = underTest.getAll();
        assertEquals(Set.of(question, question1), result);
    }

    @Test
    void getRandomQuestion_shouldThrowExceptionWhenCollectionEmpty() {
        assertThrows(NotEnoughQuestionException.class, () -> underTest.getRandomQuestion());
    }
    @Test
    void getRandomQuestion_shouldReturnQuestionWhenCollectionNotEmpty() {
        underTest.add(question);
        Question result = underTest.getRandomQuestion();
        assertEquals(question, result);
    }

}