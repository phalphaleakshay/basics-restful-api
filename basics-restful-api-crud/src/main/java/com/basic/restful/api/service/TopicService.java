package com.basic.restful.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.basic.restful.api.entity.Topic;

@Service
public class TopicService {

	List<Topic> listTopics = new ArrayList<Topic>(
			Arrays.asList(new Topic(101, "Java", "Java is a programming language"),
					new Topic(102, "OracleDB", "OracleDB is the best RDBMS")));

	public List<Topic> getAllTopics() {
		return listTopics;
	}

	public Topic getTopic(Integer id) {
		return listTopics.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public void addTopic(Topic topic) {
		listTopics.add(topic);
	}

	public void updateTopic(Integer id, Topic updateTopic) {
		int index = 0;
		for (Topic topic : listTopics) {
			if (topic.getId() == id & id != null) {
				listTopics.set(index, updateTopic);
			}
			index++;
		}
	}

	public void deleteTopic(Integer id) {
		List<Topic> duplicate = new ArrayList<>(listTopics);
		duplicate.stream().filter(t -> t.getId() == id).forEach(listTopics::remove);
	}

}
