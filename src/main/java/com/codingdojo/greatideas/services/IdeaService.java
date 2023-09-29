package com.codingdojo.greatideas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.greatideas.models.Idea;
//import com.codingdojo.greatideas.models.IdeaWithUserAndStateDTO;

import com.codingdojo.greatideas.models.User;
import com.codingdojo.greatideas.repositories.IdeaRepository;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;

@Service

public class IdeaService {

	// adding the Idea repository as a dependency
	private final IdeaRepository ideaRepository;
	

	@Autowired
	public IdeaService(IdeaRepository ideaRepository) {
		this.ideaRepository = ideaRepository;
		
	}

	
	// returns all the ideas
	public List<Idea> allIdeas() {
		return ideaRepository.findAll();
	}

	// creates a idea
	public Idea createIdea(Idea b) {
		return ideaRepository.save(b);
	}

	// retrieves a idea
	public Idea findIdea(Long id) {
		Optional<Idea> optionalIdea = ideaRepository.findById(id);
		if (optionalIdea.isPresent()) {
			return optionalIdea.get();
		} else {
			return null;
		}
	}

	public Idea updateIdea(Idea idea) {

		return ideaRepository.save(idea);
	}

	// to delete a idea, we simply pass in the idea ID and if our repository finds
	// it, the idea will be deleted
	public void deleteIdea(Long id) {
		Optional<Idea> optionalIdea = ideaRepository.findById(id);
		if (optionalIdea.isPresent()) {
			ideaRepository.deleteById(id);
		}
	}

}
