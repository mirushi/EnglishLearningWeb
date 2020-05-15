package com.comittedpeople.englishlearningweb.services;

import java.util.List;

import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarFormDTO;

public interface DocGrammarFormService {

	List<DocGrammarFormDTO> getDocGrammarFormDTOsByGrammarContentID (Long grammarContentID);
	
	DocGrammarFormDTO postDocGrammarFormDTOByGrammarContentID (Long grammarContentID, DocGrammarFormDTO formDTO);
	
}
