package com.comittedpeople.englishlearningweb.services;

import java.util.List;

import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarContentDTO;

public interface DocGrammarContentService {
	List<DocGrammarContentDTO> getDocGrammarContentDTOsByDocGrammarCategoryID (Long categoryID);
	DocGrammarContentDTO getDocGrammarContentByID (Long grammarID);
	DocGrammarContentDTO postDocGrammarContent(DocGrammarContentDTO contentDTO);
	DocGrammarContentDTO patchDocGrammarContent(Long grammarID, DocGrammarContentDTO contentDTO);
	boolean deleteDocGrammarContent(Long contentID);
}
