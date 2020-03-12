package com.spring.data.crud.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.crud.entity.Topic;
import com.spring.data.crud.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	List<Topic> listTopics = new ArrayList<Topic>(
			Arrays.asList(new Topic(101, "Java", "Java is a programming language"),
					new Topic(102, "OracleDB", "OracleDB is the best RDBMS")));

	public List<Topic> getAllTopics() {
		List<Topic> listTopics = new ArrayList<>();
		topicRepository.findAll().forEach(listTopics::add);
		return listTopics;
	}

	public Topic getTopic(Integer id) {
		return topicRepository.findById(id).get();
		//return listTopics.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		//listTopics.add(topic);
	}

	public void updateTopic(Integer id, Topic updateTopic) {
		topicRepository.save(updateTopic);
		/*
		 * int index = 0; for (Topic topic : listTopics) { if (topic.getId() == id & id
		 * != null) { listTopics.set(index, updateTopic); } index++; }
		 */	}

	public void deleteTopic(Integer id) {
		topicRepository.deleteById(id);
		/*
		 * if(id != null) { listTopics.removeIf(t -> t.getId() == id); }
		 */	
	}

}
