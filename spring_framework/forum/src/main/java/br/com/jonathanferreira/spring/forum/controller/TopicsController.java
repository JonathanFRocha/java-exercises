package br.com.jonathanferreira.spring.forum.controller;

import br.com.jonathanferreira.spring.forum.controller.dto.TopicDto;
import br.com.jonathanferreira.spring.forum.model.Course;
import br.com.jonathanferreira.spring.forum.model.Topic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/topics")
public class TopicsController {

    @GetMapping
    public List<TopicDto> List() {
        var topic = new Topic("Spring", "Spring doubt", new Course("Spring", "Programming"));
        return TopicDto.convert(Arrays.asList(topic, topic, topic));
    }
}
