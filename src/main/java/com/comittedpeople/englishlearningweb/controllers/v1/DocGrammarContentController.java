package com.comittedpeople.englishlearningweb.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarContentDTO;
import com.comittedpeople.englishlearningweb.services.DocGrammarContentService;

@Controller
@RequestMapping("/api/v1/grammar")
public class DocGrammarContentController {

	private final DocGrammarContentService docGrammarContentService;

	public DocGrammarContentController(DocGrammarContentService docGrammarContentService) {
		this.docGrammarContentService = docGrammarContentService;
	}
	
	@GetMapping(value = "{grammarID}")
	public ResponseEntity<DocGrammarContentDTO> getGrammarContent (@PathVariable Long grammarID){
		return new ResponseEntity<DocGrammarContentDTO> 
		(docGrammarContentService.getDocGrammarContentByID(grammarID), HttpStatus.OK);
	}
}
