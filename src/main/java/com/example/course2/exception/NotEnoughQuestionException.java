package com.example.course2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Недостаточно вопросов")
public class NotEnoughQuestionException extends RuntimeException {
}
