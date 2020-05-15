package com.comittedpeople.englishlearningweb.controllers.v1;

import static org.hamcrest.CoreMatchers.sameInstance;

import java.lang.reflect.Field;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarContentDTO;
import com.comittedpeople.englishlearningweb.domain.DocGrammarContent;
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
	
	@DeleteMapping(value = "{grammarID}")
	public ResponseEntity deleteGrammarContent(@PathVariable Long grammarID) {
		boolean success = docGrammarContentService.deleteDocGrammarContent(grammarID);
		
		if (success) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping(value = "{grammarID}")
	public ResponseEntity<DocGrammarContentDTO> patchGrammarContent(@PathVariable Long grammarID, @RequestBody DocGrammarContentDTO grammarContent) {
		DocGrammarContentDTO docGrammarContent = docGrammarContentService.patchDocGrammarContent(grammarID, grammarContent);
		return new ResponseEntity<DocGrammarContentDTO>(docGrammarContent, HttpStatus.OK);
	}
		
	@PostMapping
	public ResponseEntity<DocGrammarContentDTO> postGrammarContent(@Valid @RequestBody DocGrammarContentDTO contentDTO){
		
		DocGrammarContentDTO newContent = docGrammarContentService.postDocGrammarContent(contentDTO);
		if (newContent == null)
			return new ResponseEntity<DocGrammarContentDTO>(newContent, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<DocGrammarContentDTO>(newContent, HttpStatus.CREATED);
	}
	
}
