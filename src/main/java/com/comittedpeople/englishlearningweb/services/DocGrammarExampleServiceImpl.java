package com.comittedpeople.englishlearningweb.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comittedpeople.englishlearningweb.api.v1.mapper.DocGrammarExampleMapper;
import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarExampleDTO;
import com.comittedpeople.englishlearningweb.repositories.DocGrammarExampleRepository;

@Service
public class DocGrammarExampleServiceImpl implements DocGrammarExampleService{

	@Autowired
	DocGrammarExampleRepository exampleRepository;
	
	@Autowired
	DocGrammarExampleMapper exampleMapper;
	
	public DocGrammarExampleServiceImpl (DocGrammarExampleMapper exampleMapper,
			DocGrammarExampleRepository exampleRepository) {
		this.exampleRepository = exampleRepository;
		this.exampleMapper = exampleMapper;
	}
	
	@Override
	public List<DocGrammarExampleDTO> getDocGrammarExampleDTOsByFormID(Long formID) {
		return exampleRepository.findByDocGrammarFormId(formID)
				.stream()
				.map(exampleMapper::docGrammarExampletoExampleDTO)
				.collect(Collectors.toList());
	}
}
