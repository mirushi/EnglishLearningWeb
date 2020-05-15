package com.comittedpeople.englishlearningweb.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.comittedpeople.englishlearningweb.api.v1.mapper.DocGrammarFormMapper;
import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarFormDTO;
import com.comittedpeople.englishlearningweb.domain.DocGrammarExample;
import com.comittedpeople.englishlearningweb.domain.DocGrammarNote;
import com.comittedpeople.englishlearningweb.repositories.DocGrammarFormRepository;

public class DocGrammarFormServiceImpl implements DocGrammarFormService{

	@Autowired
	DocGrammarFormMapper formMapper;
	
	@Autowired
	DocGrammarFormRepository formRepository;
	
	public DocGrammarFormServiceImpl(DocGrammarFormMapper formMapper,
			DocGrammarFormRepository formRepository) {		
		this.formMapper = formMapper;
		this.formRepository = formRepository;
	}
	
	@Override
	public List<DocGrammarFormDTO> getDocGrammarFormDTOsByGrammarContentID(Long grammarContentID) {
		// TODO Auto-generated method stub
		return formRepository.findByDocGrammarContentId(grammarContentID)
				.stream()
				.map(formMapper::getDto)
				.collect(Collectors.toList());
	}
	
}
