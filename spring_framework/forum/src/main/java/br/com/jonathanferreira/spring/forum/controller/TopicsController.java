package br.com.jonathanferreira.spring.forum.controller;

import br.com.jonathanferreira.spring.forum.controller.dto.DetailedTopicDto;
import br.com.jonathanferreira.spring.forum.controller.dto.TopicDto;
import br.com.jonathanferreira.spring.forum.controller.form.TopicForm;
import br.com.jonathanferreira.spring.forum.controller.form.UpdateTopicForm;
import br.com.jonathanferreira.spring.forum.model.Topic;
import br.com.jonathanferreira.spring.forum.repository.CourseRepository;
import br.com.jonathanferreira.spring.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/topics")
public class TopicsController {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    @Cacheable(value = "topicsList")
    public Page<TopicDto> List(
            @RequestParam(required = false) String course,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pagination
    ) {
//        Pageable pagination = PageRequest.of(page, qty, Sort.Direction.ASC, sorting);

        if (course == null) {
            var Topics = topicRepository.findAll(pagination);
            return TopicDto.convert(Topics);
        } else {
            var Topics = topicRepository.findByCourseName(course, pagination);
            return TopicDto.convert(Topics);
        }
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "topicsList", allEntries = true)
    public ResponseEntity<TopicDto> register(@Valid @RequestBody TopicForm form, UriComponentsBuilder uriBuilder) {
        Topic topic = form.Convert(courseRepository);
        topicRepository.save(topic);
        URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicDto(topic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedTopicDto> detail(@PathVariable int id) {
        var optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent()) {
            return ResponseEntity.ok(new DetailedTopicDto(optionalTopic.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "topicsList", allEntries = true)
    public ResponseEntity<TopicDto> update(@Valid @RequestBody UpdateTopicForm form, @PathVariable int id) {
        var optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent()) {
            Topic topic = form.update(id, topicRepository);
            return ResponseEntity.ok(new TopicDto(topic));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "topicsList", allEntries = true)
    public ResponseEntity<?> delete(@PathVariable int id) {
        var optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent()) {
            topicRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
