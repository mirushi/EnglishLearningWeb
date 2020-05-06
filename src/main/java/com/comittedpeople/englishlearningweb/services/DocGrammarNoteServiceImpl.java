package com.comittedpeople.englishlearningweb.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comittedpeople.englishlearningweb.api.v1.mapper.DocGrammarNoteMapper;
import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarNoteDTO;
import com.comittedpeople.englishlearningweb.domain.DocGrammarNote;
import com.comittedpeople.englishlearningweb.repositories.DocGrammarNoteRepository;

@Service
public class DocGrammarNoteServiceImpl implements DocGrammarNoteService {

	@Autowired
	DocGrammarNoteRepository noteRepository;
	
	@Autowired
	DocGrammarNoteMapper noteMapper;
	
	public DocGrammarNoteServiceImpl(DocGrammarNoteMapper noteMapper, DocGrammarNoteRepository noteRepository) {
		this.noteRepository = noteRepository;
		
		this.noteMapper = noteMapper;
	}
	
	@Override
	public List<DocGrammarNoteDTO> getAllDocGrammarNoteDTOByFormID(Long formID) {
		List<DocGrammarNote> grammarNote = noteRepository.findByDocGrammarFormId(formID);
		
		return grammarNote
				.stream()
				.map(noteMapper::docGrammarNotetoGrammarNoteDTO)
				.collect(Collectors.toList());
	}

}
