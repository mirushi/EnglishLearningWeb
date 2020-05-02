package com.comittedpeople.englishlearningweb.api.v1.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.comittedpeople.englishlearningweb.domain.DocVocabLesson;

@Mapper
public interface DocVocabLessonMapper {

	DocVocabLessonMapper INSTANCE = Mappers.getMapper(DocVocabLessonMapper.class);
	
	@Mapping(source = "id", target = "id")
	DocVocabLessonDTO docVocabLessonToLessonDTO(DocVocabLesson lesson);
}
