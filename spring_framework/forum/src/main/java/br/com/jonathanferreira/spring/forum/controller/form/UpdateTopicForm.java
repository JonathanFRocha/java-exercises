package br.com.jonathanferreira.spring.forum.controller.form;

import br.com.jonathanferreira.spring.forum.model.Topic;
import br.com.jonathanferreira.spring.forum.repository.TopicRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UpdateTopicForm {
    @NotNull
    @NotEmpty
    @Size(min=5)
    private String title;
    @NotNull @NotEmpty @Size(min=10)
    private String message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Topic update(int id, TopicRepository topicRepository) {
        var topic = topicRepository.getById(id);

        topic.setTitle(this.title);
        topic.setMessage(this.message);

        return topic;
    }
}
