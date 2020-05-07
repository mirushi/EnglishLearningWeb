package com.comittedpeople.englishlearningweb.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comittedpeople.englishlearningweb.api.v1.mapper.DocGrammarContentMapper;
import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarContentDTO;
import com.comittedpeople.englishlearningweb.repositories.DocGrammarContentRepository;

@Service
public class DocGrammarContentServiceImpl implements DocGrammarContentService{

	@Autowired
	private DocGrammarContentMapper contentMapper;
	
	@Autowired
	private DocGrammarContentRepository contentRepository;
	
	public DocGrammarContentServiceImpl(DocGrammarContentMapper contentMapper,
			DocGrammarContentRepository contentRepository) {
		this.contentMapper = contentMapper;
		this.contentRepository = contentRepository;
	}

	@Override
	public List<DocGrammarContentDTO> getDocGrammarContentDTOsByDocGrammarCategoryID(Long categoryID) {
		return contentRepository.findByCategoryId(categoryID)
				.stream()
				.map(contentMapper::docGrammarContenttoContentDTO)
				.collect(Collectors.toList());
	}

	@Override
	public DocGrammarContentDTO getDocGrammarContentByID(Long grammarID) {
		return contentRepository.findById(grammarID).map(contentMapper::docGrammarContenttoContentDTO).get();
	}
}