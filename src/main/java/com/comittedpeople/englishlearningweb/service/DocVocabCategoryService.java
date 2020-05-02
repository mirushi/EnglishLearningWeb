package com.comittedpeople.englishlearningweb.service;

import java.util.List;

import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabCategoryDTO;
import com.comittedpeople.englishlearningweb.domain.DocVocabCategory;

public interface DocVocabCategoryService {

	List<DocVocabCategoryDTO> getAllVocabCategoryDTOs();
}
