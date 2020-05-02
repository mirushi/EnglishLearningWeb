package com.comittedpeople.englishlearningweb.api.v1.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.comittedpeople.englishlearningweb.domain.DocVocabCategory;
	
@Mapper
public interface DocVocabCategoryMapper {

	DocVocabCategoryMapper INSTANCE = Mappers.getMapper(DocVocabCategoryMapper.class);
	
	@Mapping(source = "id", target = "id")
	DocVocabCategoryDTO docVocabCategorytoCategoryDTO(DocVocabCategory category);
	
}
