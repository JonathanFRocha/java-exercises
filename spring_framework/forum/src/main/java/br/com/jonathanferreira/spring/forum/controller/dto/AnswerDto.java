package br.com.jonathanferreira.spring.forum.controller.dto;

import br.com.jonathanferreira.spring.forum.model.Answer;
import java.time.LocalDateTime;

public class AnswerDto {
    private Integer id;
    private String message;
    private LocalDateTime creationDate;
    private String authorName;


    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.creationDate = answer.getCreationDate();
        this.authorName = answer.getAuthor().getName();
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getAuthorName() {
        return authorName;
    }
}
