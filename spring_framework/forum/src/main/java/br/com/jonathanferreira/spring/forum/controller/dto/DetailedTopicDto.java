package br.com.jonathanferreira.spring.forum.controller.dto;

import br.com.jonathanferreira.spring.forum.model.StatusTopic;
import br.com.jonathanferreira.spring.forum.model.Topic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetailedTopicDto {
    private Integer id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private String authorName;
    private StatusTopic status;
    private List<AnswerDto> answers;

    public DetailedTopicDto() {
    }

    public DetailedTopicDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();
        this.authorName = topic.getAuthor().getName();
        this.status = topic.getStatus();
        this.answers = new ArrayList<>();
        this.answers.addAll(topic.getAnswers().stream().map(AnswerDto::new).collect(Collectors.toList()));
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public StatusTopic getStatus() {
        return status;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }
}
