package br.com.jonathanferreira.spring.forum.controller.dto;

import br.com.jonathanferreira.spring.forum.model.Topic;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

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

    public static Page<TopicDto> convert(Page<Topic> topics) {
        return topics.map(TopicDto::new);
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
