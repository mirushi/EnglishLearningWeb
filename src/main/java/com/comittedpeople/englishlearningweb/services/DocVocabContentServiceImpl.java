package com.comittedpeople.englishlearningweb.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comittedpeople.englishlearningweb.api.v1.mapper.DocVocabContentMapper;
import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabContentDTO;
import com.comittedpeople.englishlearningweb.repositories.DocVocabContentRepository;

@Service
public class DocVocabContentServiceImpl implements DocVocabContentService{

	@Autowired
	private DocVocabContentMapper mapper;
	
	@Autowired
	private final DocVocabContentRepository repository;
	
	public DocVocabContentServiceImpl(DocVocabContentMapper mapper, DocVocabContentRepository repository) {
		super();
		this.mapper = mapper;
		this.repository = repository;
	}
	
	@Override
	public List<DocVocabContentDTO> getAllVocabContentByLessonId(Long lessonID) {
		return repository.findByLessonId(lessonID)
				.stream()
				.map(mapper::docVocabContenttoContentDTO)
				.collect(Collectors.toList());
	}
}
