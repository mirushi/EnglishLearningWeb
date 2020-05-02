package com.comittedpeople.englishlearningweb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabCategoryDTO;
import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabCategoryMapper;
import com.comittedpeople.englishlearningweb.repositories.DocVocabCategoryRepository;

public class DocVocabCategoryServiceImpl implements DocVocabCategoryService {

	@Autowired
	private DocVocabCategoryMapper mapper;
	
	@Autowired
	private final DocVocabCategoryRepository repository;
	
	public DocVocabCategoryServiceImpl(DocVocabCategoryMapper mapper, DocVocabCategoryRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public List<DocVocabCategoryDTO> getAllVocabCategoryDTOs() {
		return repository.findAll()
				.stream()
				.map(mapper::docVocabCategorytoCategoryDTO)
				.collect(Collectors.toList());
	}

}
