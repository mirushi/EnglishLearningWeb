package com.comittedpeople.englishlearningweb.controllers.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabContentDTO;
import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabLessonDTO;
import com.comittedpeople.englishlearningweb.domain.DocVocabContent;
import com.comittedpeople.englishlearningweb.domain.DocVocabLesson;
import com.comittedpeople.englishlearningweb.service.DocVocabContentService;
import com.comittedpeople.englishlearningweb.service.DocVocabLessonService;
import com.comittedpeople.englishlearningweb.service.DocVocabLessonServiceImpl;

@Controller
@RequestMapping("/api/v1/vocabLessons")
public class DocVocabLessonController {
	
	private final DocVocabLessonService docVocabLessonService;
	
	private final DocVocabContentService docVocabContentService;
	
	public DocVocabLessonController (DocVocabLessonService docVocabLessonService, DocVocabContentService docVocabContentService) {
		this.docVocabLessonService = docVocabLessonService;
		this.docVocabContentService = docVocabContentService;
	}
	
	@GetMapping(value = "{lessonID}")
	public ResponseEntity<List<DocVocabContentDTO>> getAllDocVocabContent (@PathVariable Long lessonID){
		return new ResponseEntity<List<DocVocabContentDTO>> (docVocabContentService.getAllVocabContent(lessonID), HttpStatus.OK);
	}
}
