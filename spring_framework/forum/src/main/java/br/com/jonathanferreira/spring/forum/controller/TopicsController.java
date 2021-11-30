package br.com.jonathanferreira.spring.forum.controller;

import br.com.jonathanferreira.spring.forum.controller.dto.TopicDto;
import br.com.jonathanferreira.spring.forum.model.Topic;
import br.com.jonathanferreira.spring.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/topics")
public class TopicsController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public List<TopicDto> List(@RequestParam String course) {
        List<Topic> Topics;
        if(course == null){
            Topics = topicRepository.findAll();
        }else {
            Topics = topicRepository.findByCourseName(course);
        }
        return TopicDto.convert(Topics);

    }
}
