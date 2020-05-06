package com.comittedpeople.englishlearningweb.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarExampleDTO;
import com.comittedpeople.englishlearningweb.domain.DocGrammarExample;

@Mapper
public interface DocGrammarExampleMapper {
	
	DocGrammarExampleMapper INSTANCE = Mappers.getMapper(DocGrammarExampleMapper.class);
	
	@Mapping(source = "id", target = "id")
	DocGrammarExampleDTO docGrammarExampletoExampleDTO (DocGrammarExample grammarExample);
}
