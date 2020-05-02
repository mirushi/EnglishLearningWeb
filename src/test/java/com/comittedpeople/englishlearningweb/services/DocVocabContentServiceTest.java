package com.comittedpeople.englishlearningweb.services;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabContentDTO;
import com.comittedpeople.englishlearningweb.api.v1.model.DocVocabContentMapper;
import com.comittedpeople.englishlearningweb.domain.DocVocabContent;
import com.comittedpeople.englishlearningweb.repositories.DocVocabContentRepository;
import com.comittedpeople.englishlearningweb.service.DocVocabContentService;
import com.comittedpeople.englishlearningweb.service.DocVocabContentServiceImpl;

public class DocVocabContentServiceTest {

	DocVocabContentService docVocabContentService;
	
	@Mock
	DocVocabContentRepository docVocabContentRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		docVocabContentService = new DocVocabContentServiceImpl(DocVocabContentMapper.INSTANCE, docVocabContentRepository);
	}
	
	@Test
	public void getAllVocabByLesson() {
		List<DocVocabContent> vocabContent = Arrays.asList(new DocVocabContent(), new DocVocabContent(), new DocVocabContent());
		
		when(docVocabContentRepository.findByLessonId(anyLong())).thenReturn(vocabContent);
		
		List<DocVocabContentDTO> vocabContentDTOs = docVocabContentService.getAllVocabContent(1L);
		
		assertEquals(3, vocabContentDTOs.size());
	}
	
}
