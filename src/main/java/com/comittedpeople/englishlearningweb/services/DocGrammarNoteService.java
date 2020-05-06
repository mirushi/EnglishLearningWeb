package com.comittedpeople.englishlearningweb.services;

import java.util.List;

import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarNoteDTO;

public interface DocGrammarNoteService {

	List<DocGrammarNoteDTO> getAllDocGrammarNoteDTOByFormID (Long formID);
}
