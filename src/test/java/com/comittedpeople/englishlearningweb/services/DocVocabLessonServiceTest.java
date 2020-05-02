package com.comittedpeople.englishlearningweb.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabCategoryMapper;
import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabLessonDTO;
import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabLessonMapper;
import com.comittedpeople.englishlearningweb.domain.DocVocabLesson;
import com.comittedpeople.englishlearningweb.repositories.DocVocabLessonRepository;
import com.comittedpeople.englishlearningweb.service.DocVocabCategoryServiceImpl;
import com.comittedpeople.englishlearningweb.service.DocVocabLessonService;
import com.comittedpeople.englishlearningweb.service.DocVocabLessonServiceImpl;

public class DocVocabLessonServiceTest {
	DocVocabLessonService docVocabLessonService;
	
	@Mock
	DocVocabLessonRepository docVocabLessonRepository;
	
	@BeforeEach
	public void setUp () throws Exception{
		MockitoAnnotations.initMocks(this);
		System.out.println("Before called");
		docVocabLessonService = new DocVocabLessonServiceImpl(DocVocabLessonMapper.INSTANCE, docVocabLessonRepository);
	}
	
	@Test
	public void getAllDocVocabLesson() throws Exception{
		
		System.out.println("Test DocVocabLesson called");
		
		//Giả sử.
		List<DocVocabLesson> lessons = Arrays.asList(new DocVocabLesson(), new DocVocabLesson(), new DocVocabLesson());
		
		when(docVocabLessonRepository.findByCategoryId(anyLong())).thenReturn(lessons);
		
		List<DocVocabLessonDTO> lessonDTOs = docVocabLessonService.getAllVocabLessonsDTOByCategoryID(1L);
		
		assertEquals(3, lessonDTOs.size());
	}
}
