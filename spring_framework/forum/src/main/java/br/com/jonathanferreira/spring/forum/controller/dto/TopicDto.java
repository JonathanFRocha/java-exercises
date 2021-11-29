package br.com.jonathanferreira.spring.forum.controller.dto;

import br.com.jonathanferreira.spring.forum.model.Topic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicDto {
    private Integer id;
    private String title;
    private String message;
    private LocalDateTime creationDate;

    public TopicDto() {
    }

    public TopicDto(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();
    }

    public static List<TopicDto> convert(List<Topic> topics) {
        return topics.stream().map(TopicDto::new).collect(Collectors.toList());
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
}
