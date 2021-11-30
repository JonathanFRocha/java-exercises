package br.com.jonathanferreira.spring.forum.controller;

import br.com.jonathanferreira.spring.forum.controller.dto.TopicDto;
import br.com.jonathanferreira.spring.forum.controller.form.TopicForm;
import br.com.jonathanferreira.spring.forum.model.Topic;
import br.com.jonathanferreira.spring.forum.repository.CourseRepository;
import br.com.jonathanferreira.spring.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/topics")
public class TopicsController {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<TopicDto> List(@RequestParam(required = false) String course) {
        List<Topic> Topics;
        if(course == null){
            Topics = topicRepository.findAll();
        }else {
            Topics = topicRepository.findByCourseName(course);
        }
        return TopicDto.convert(Topics);
    }

    @PostMapping
    public ResponseEntity<TopicDto> register(@RequestBody TopicForm form, UriComponentsBuilder uriBuilder){
        Topic topic = form.Convert(courseRepository);
        topicRepository.save(topic);
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }
}
