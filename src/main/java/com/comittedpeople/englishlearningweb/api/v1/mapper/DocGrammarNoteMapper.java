package com.comittedpeople.englishlearningweb.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarNoteDTO;
import com.comittedpeople.englishlearningweb.domain.DocGrammarNote;

@Mapper
public interface DocGrammarNoteMapper {

	DocGrammarNoteMapper INSTANCE = Mappers.getMapper(DocGrammarNoteMapper.class);
	
	@Mapping(source = "id", target = "id")
	DocGrammarNoteDTO docGrammarNotetoGrammarNoteDTO (DocGrammarNote grammarNote);
}
