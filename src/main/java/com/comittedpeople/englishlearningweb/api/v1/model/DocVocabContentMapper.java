package com.comittedpeople.englishlearningweb.api.v1.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.comittedpeople.englishlearningweb.domain.DocVocabContent;

@Mapper
public interface DocVocabContentMapper {

	DocVocabContentMapper INSTANCE = Mappers.getMapper(DocVocabContentMapper.class);
	
	@Mapping (source = "id", target = "id")
	DocVocabContentDTO docVocabContenttoContentDTO (DocVocabContent docVocabContent);
}
