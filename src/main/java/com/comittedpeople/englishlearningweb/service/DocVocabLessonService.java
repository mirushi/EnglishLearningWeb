package com.comittedpeople.englishlearningweb.service;

import java.util.List;

import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabLessonDTO;
import com.comittedpeople.englishlearningweb.domain.DocVocabContent;
import com.comittedpeople.englishlearningweb.domain.DocVocabLesson;

public interface DocVocabLessonService {

	List<DocVocabLessonDTO> getAllVocabLessonsDTOByCategoryID(Long categoryID);
}
