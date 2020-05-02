package com.comittedpeople.englishlearningweb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabLessonDTO;
import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabLessonMapper;
import com.comittedpeople.englishlearningweb.domain.DocVocabCategory;
import com.comittedpeople.englishlearningweb.domain.DocVocabLesson;
import com.comittedpeople.englishlearningweb.repositories.DocVocabLessonRepository;

public class DocVocabLessonServiceImpl implements DocVocabLessonService{

	@Autowired
	DocVocabLessonRepository repository;
	
	@Autowired
	DocVocabLessonMapper mapper;
	
	public DocVocabLessonServiceImpl(DocVocabLessonMapper mapper, DocVocabLessonRepository repository) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<DocVocabLessonDTO> getAllVocabLessonsDTOByCategoryID(Long categoryID) {
		return repository.findByCategoryId(categoryID)
				.stream()
				.map(mapper::docVocabLessonToLessonDTO)
				.collect(Collectors.toList());	
	}
}
