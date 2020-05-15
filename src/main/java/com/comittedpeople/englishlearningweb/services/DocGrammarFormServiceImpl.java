package com.comittedpeople.englishlearningweb.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comittedpeople.englishlearningweb.api.v1.mapper.DocGrammarFormMapper;
import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarFormDTO;
import com.comittedpeople.englishlearningweb.domain.DocGrammarContent;
import com.comittedpeople.englishlearningweb.domain.DocGrammarExample;
import com.comittedpeople.englishlearningweb.domain.DocGrammarForm;
import com.comittedpeople.englishlearningweb.domain.DocGrammarNote;
import com.comittedpeople.englishlearningweb.repositories.DocGrammarContentRepository;
import com.comittedpeople.englishlearningweb.repositories.DocGrammarFormRepository;

@Service
public class DocGrammarFormServiceImpl implements DocGrammarFormService{

	@Autowired
	DocGrammarFormMapper formMapper;
	
	@Autowired
	DocGrammarFormRepository formRepository;
	
	@Autowired
	DocGrammarContentRepository contentRepository;
	
	public DocGrammarFormServiceImpl(DocGrammarFormMapper formMapper,
			DocGrammarFormRepository formRepository, DocGrammarContentRepository contentRepository) {		
		this.formMapper = formMapper;
		this.formRepository = formRepository;
		this.contentRepository = contentRepository;
	}
	
	@Override
	public List<DocGrammarFormDTO> getDocGrammarFormDTOsByGrammarContentID(Long grammarContentID) {
		// TODO Auto-generated method stub
		return formRepository.findByDocGrammarContentId(grammarContentID)
				.stream()
				.map(formMapper::getDto)
				.collect(Collectors.toList());
	}

	@Override
	public DocGrammarFormDTO postDocGrammarFormDTOByGrammarContentID(Long grammarContentID, DocGrammarFormDTO formDTO) {
		// TODO Auto-generated method stub
		
		DocGrammarContent content = contentRepository.findById(grammarContentID).get();
		
		if (content == null)
			return null;
		
		//Tạo mới 1 form dựa trên content cho trước.
		DocGrammarForm form = formMapper.getEntity(formDTO);
		form.setDocGrammarContent(content);
		form = formRepository.save(form);
		
		//Add form vừa tạo vào content.
		content.getForms().add(form);
		contentRepository.save(content);
		
		return formMapper.getDto(form);
	}
	
}
