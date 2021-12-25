package br.com.jonathanferreira.spring.forum.controller;

import br.com.jonathanferreira.spring.forum.controller.dto.DetailedTopicDto;
import br.com.jonathanferreira.spring.forum.controller.dto.TopicDto;
import br.com.jonathanferreira.spring.forum.controller.form.TopicForm;
import br.com.jonathanferreira.spring.forum.controller.form.UpdateTopicForm;
import br.com.jonathanferreira.spring.forum.model.Topic;
import br.com.jonathanferreira.spring.forum.repository.CourseRepository;
import br.com.jonathanferreira.spring.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
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
    @Transactional
    public ResponseEntity<TopicDto> register(@Valid @RequestBody TopicForm form, UriComponentsBuilder uriBuilder){
        Topic topic = form.Convert(courseRepository);
        topicRepository.save(topic);
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedTopicDto> detail(@PathVariable int id){
        var optionalTopic = topicRepository.findById(id);
        if(optionalTopic.isPresent()){
            return ResponseEntity.ok(new DetailedTopicDto(optionalTopic.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDto> update(@Valid @RequestBody UpdateTopicForm form, @PathVariable int id){
        var optionalTopic = topicRepository.findById(id);
        if(optionalTopic.isPresent()){
            Topic topic = form.update(id, topicRepository);
            return ResponseEntity.ok(new TopicDto(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable int id){
        var optionalTopic = topicRepository.findById(id);
        if(optionalTopic.isPresent()){
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
