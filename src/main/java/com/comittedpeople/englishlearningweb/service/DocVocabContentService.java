package com.comittedpeople.englishlearningweb.service;

import java.util.List;

import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabContentDTO;

public interface DocVocabContentService {
	
	List<DocVocabContentDTO> getAllVocabContent(Long lessonID);

}
