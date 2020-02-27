package com.basic.restful.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.basic.restful.api.entity.Topic;
import com.basic.restful.api.service.TopicService;

/**
 * @author Akshay Phalphale
 */
@RestController
public class TopicController {

	@Autowired
	TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("topics/{id}")
	public Topic getTopic(@PathVariable Integer id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic, @PathVariable Integer id) {
		topicService.updateTopic(id, topic);
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable Integer id) {
		topicService.deleteTopic(id);
	}
}
