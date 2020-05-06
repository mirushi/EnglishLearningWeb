package com.comittedpeople.englishlearningweb.bootstrap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.comittedpeople.englishlearningweb.domain.DocVocabCategory;
import com.comittedpeople.englishlearningweb.domain.DocVocabContent;
import com.comittedpeople.englishlearningweb.domain.DocVocabLesson;
import com.comittedpeople.englishlearningweb.repositories.DocVocabCategoryRepository;
import com.comittedpeople.englishlearningweb.repositories.DocVocabContentRepository;
import com.comittedpeople.englishlearningweb.repositories.DocVocabLessonRepository;

@Component
@Transactional
public class Bootstrap implements CommandLineRunner {
	
	private DocVocabCategoryRepository docVocabCategoryRepository;
	
	private DocVocabLessonRepository docVocabLessonRepository;
	
	private DocVocabContentRepository docVocabContentRepository;
	
	public Bootstrap(DocVocabCategoryRepository docVocabCategoryRepository, 
			DocVocabLessonRepository docVocabLessonRepository, DocVocabContentRepository docVocabContentRepository) {
		this.docVocabContentRepository = docVocabContentRepository;
		this.docVocabLessonRepository = docVocabLessonRepository;
		
		this.docVocabCategoryRepository = docVocabCategoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		setupVocabCategories();
		
		setupVocabLesson();
		
		setupVocabContent();
	}
	
	
	private void setupVocabContent() {
		
		DocVocabLesson lesson1 = docVocabLessonRepository.findById(1L).get();
		DocVocabLesson lesson2 = docVocabLessonRepository.findById(2L).get();
		DocVocabLesson lesson3 = docVocabLessonRepository.getOne(3L);
		DocVocabLesson lesson4 = docVocabLessonRepository.getOne(4L);
		DocVocabLesson lesson5 = docVocabLessonRepository.getOne(5L);
		DocVocabLesson lesson6 = docVocabLessonRepository.getOne(6L);
		
		DocVocabContent content1lesson1 = new DocVocabContent();
		content1lesson1.setContent("English");
		content1lesson1.setDescription("English is a noun");
		content1lesson1.setId(1L);
		content1lesson1.setLesson(lesson1);
		content1lesson1.setSpelling("/ˈɪŋɡlɪʃ/");
		content1lesson1.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/us_pron/e/eng/engli/english__us_1.mp3");
		
		DocVocabContent content2lesson1 = new DocVocabContent();
		content2lesson1.setContent("Happy");
		content2lesson1.setDescription("Happy is a state where you find yourself ... happy");
		content2lesson1.setId(2L);
		content2lesson1.setLesson(lesson1);
		content2lesson1.setSpelling("/ˈhæpi/");
		content2lesson1.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/h/hap/happy/happy__gb_1.mp3");
		
		DocVocabContent content1lesson2 = new DocVocabContent();
		content1lesson2.setContent("Success");
		content1lesson2.setDescription("Happy is a noun");
		content1lesson2.setId(3L);
		content1lesson2.setLesson(lesson2);
		content1lesson2.setSpelling("/ˈhæpi/");
		content1lesson2.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/s/suc/succe/success__gb_1.mp3");
		
		DocVocabContent content2lesson2 = new DocVocabContent();
		content2lesson2.setContent("Extraordinary");
		content2lesson2.setDescription("unexpected, surprising or strange");
		content2lesson2.setId(4L);
		content2lesson2.setLesson(lesson2);
		content2lesson2.setSpelling("/ɪkˈstrɔːdnri/");
		content2lesson2.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/e/ext/extra/extraordinary__gb_1.mp3");

		DocVocabContent content1lesson3 = new DocVocabContent();
		content1lesson3.setContent("inspire");
		content1lesson3.setDescription("to give somebody the desire, confidence or enthusiasm to do something well");
		content1lesson3.setId(5L);
		content1lesson3.setLesson(lesson3);
		content1lesson3.setSpelling("/ɪnˈspaɪə(r)/");
		content1lesson3.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/i/ins/inspi/inspire__gb_1.mp3");

		DocVocabContent content2lesson3 = new DocVocabContent();
		content2lesson3.setContent("innovate");
		content2lesson3.setDescription("to introduce new things, ideas or ways of doing something");
		content2lesson3.setId(6L);
		content2lesson3.setLesson(lesson3);
		content2lesson3.setSpelling("/ˈɪnəveɪt/");
		content2lesson3.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/i/inn/innov/innovate__gb_1.mp3");

		DocVocabContent content1lesson4 = new DocVocabContent();
		content1lesson4.setContent("brilliant");
		content1lesson4.setDescription("extremely clever or impressive");
		content1lesson4.setId(7L);
		content1lesson4.setLesson(lesson4);
		content1lesson4.setSpelling("/ˈbrɪliənt/");
		content1lesson4.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/b/bri/brill/brilliant__gb_1.mp3");
		
		DocVocabContent content2lesson4 = new DocVocabContent();
		content2lesson4.setContent("exceptional");
		content2lesson4.setDescription("unusually good");
		content2lesson4.setId(8L);
		content2lesson4.setLesson(lesson4);
		content2lesson4.setSpelling("/ɪkˈsepʃənl/");
		content2lesson4.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/e/exc/excep/exceptional__gb_1.mp3");
		
		DocVocabContent content1lesson5 = new DocVocabContent();
		content1lesson5.setContent("creative");
		content1lesson5.setDescription("involving the use of skill and the imagination to produce something new or a work of art");
		content1lesson5.setId(9L);
		content1lesson5.setLesson(lesson5);
		content1lesson5.setSpelling("/kriˈeɪtɪv/");
		content1lesson5.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/c/cre/creat/creative__gb_3.mp3");
		
		
		DocVocabContent content2lesson5 = new DocVocabContent();
		content2lesson5.setContent("fascinating");
		content2lesson5.setDescription("extremely interesting and attractive");
		content2lesson5.setId(10L);
		content2lesson5.setLesson(lesson5);
		content2lesson5.setSpelling("/ˈfæsɪneɪtɪŋ/");
		content2lesson5.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/f/fas/fasci/fascinating__gb_1.mp3");
		
		DocVocabContent content1lesson6 = new DocVocabContent();
		content1lesson6.setContent("marvellous");
		content1lesson6.setDescription("extremely good; wonderful");
		content1lesson6.setId(11L);
		content1lesson6.setLesson(lesson6);
		content1lesson6.setSpelling("/ˈmɑːvələs/");
		content1lesson6.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/m/mar/marve/marvellous__gb_1.mp3");
		
		DocVocabContent content2lesson6 = new DocVocabContent();
		content2lesson6.setContent("complete");
		content2lesson6.setDescription("including all the parts, etc. that are necessary; whole");
		content2lesson6.setId(12L);
		content2lesson6.setLesson(lesson6);
		content2lesson6.setSpelling("/kəmˈpliːt/");
		content2lesson6.setSpellingAudioURL("https://www.oxfordlearnersdictionaries.com/media/english/uk_pron/c/com/compl/complete__gb_2.mp3");
		
		
		//Sau khi thêm xong từ vựng thì ta cập nhật lại lesson với từ vựng mới.
		lesson1.setVocabs(new HashSet<>(Arrays.asList(content1lesson1,content2lesson1)));
		lesson2.setVocabs(new HashSet<>(Arrays.asList(content1lesson2, content2lesson2)));
		lesson3.setVocabs(new HashSet<>(Arrays.asList(content1lesson3, content2lesson3)));
		lesson4.setVocabs(new HashSet<>(Arrays.asList(content1lesson4, content2lesson4)));
		lesson5.setVocabs(new HashSet<>(Arrays.asList(content1lesson5, content2lesson5)));
		lesson6.setVocabs(new HashSet<>(Arrays.asList(content1lesson6, content2lesson6)));
		
		docVocabContentRepository.save(content1lesson1);
		docVocabContentRepository.save(content2lesson1);
		docVocabContentRepository.save(content1lesson2);
		docVocabContentRepository.save(content2lesson2);
		docVocabContentRepository.save(content1lesson3);
		docVocabContentRepository.save(content2lesson3);
		docVocabContentRepository.save(content1lesson4);
		docVocabContentRepository.save(content2lesson4);
		docVocabContentRepository.save(content1lesson5);
		docVocabContentRepository.save(content2lesson5);
		docVocabContentRepository.save(content1lesson6);
		docVocabContentRepository.save(content2lesson6);
		
		docVocabLessonRepository.save(lesson1);
		docVocabLessonRepository.save(lesson2);
		docVocabLessonRepository.save(lesson3);
		docVocabLessonRepository.save(lesson4);
		docVocabLessonRepository.save(lesson5);
		docVocabLessonRepository.save(lesson6);
		
		
		System.out.println("DocVocabContent loaded : " + docVocabContentRepository.count());
//		System.out.println("Lesson1 : " + lesson1.getTitle());
//		System.out.println("Lesson2: " + lesson2.getTitle());

	}
	
	private void setupVocabLesson() {
		DocVocabCategory cat01 = docVocabCategoryRepository.getOne(1L);
		DocVocabCategory cat02 = docVocabCategoryRepository.getOne(2L);
		DocVocabCategory cat03 = docVocabCategoryRepository.getOne(3L);
		
		DocVocabLesson lesson1Cat01 = new DocVocabLesson();
		lesson1Cat01.setId(1L);
		lesson1Cat01.setTitle("Contract (lesson of Category 1)");
		lesson1Cat01.setImageURL("https://upload.wikimedia.org/wikipedia/commons/8/8a/ContractLaw.jpg");
		lesson1Cat01.setCategory(cat01);
		
		DocVocabLesson lesson2Cat01 = new DocVocabLesson();
		lesson2Cat01.setId(2L);
		lesson2Cat01.setTitle("Lesson 2 of category 1");
		lesson2Cat01.setImageURL("https://upload.wikimedia.org/wikipedia/commons/8/8a/ContractLaw.jpg");
		lesson2Cat01.setCategory(cat01);
		
		DocVocabLesson lesson1Cat02 = new DocVocabLesson();
		lesson1Cat02.setId(3L);
		lesson1Cat02.setTitle("Contract (lesson of Category 2)");
		lesson1Cat02.setImageURL("https://upload.wikimedia.org/wikipedia/commons/8/8a/ContractLaw.jpg");
		lesson1Cat02.setCategory(cat02);
		
		DocVocabLesson lesson2Cat02 = new DocVocabLesson();
		lesson2Cat02.setId(4L);
		lesson2Cat02.setTitle("Lesson 2 of category 2");
		lesson2Cat02.setImageURL("https://upload.wikimedia.org/wikipedia/commons/8/8a/ContractLaw.jpg");
		lesson2Cat02.setCategory(cat02);
		
		DocVocabLesson lesson1Cat03 = new DocVocabLesson();
		lesson1Cat03.setId(5L);
		lesson1Cat03.setTitle("Contract (lesson of Category 3)");
		lesson1Cat03.setImageURL("https://upload.wikimedia.org/wikipedia/commons/8/8a/ContractLaw.jpg");
		lesson1Cat03.setCategory(cat03);
		
		DocVocabLesson lesson2Cat03 = new DocVocabLesson();
		lesson2Cat03.setId(6L);
		lesson2Cat03.setTitle("Lesson 2 of category 3");
		lesson2Cat03.setImageURL("https://upload.wikimedia.org/wikipedia/commons/8/8a/ContractLaw.jpg");
		lesson2Cat03.setCategory(cat03);
		
		docVocabLessonRepository.save(lesson1Cat01);
		docVocabLessonRepository.save(lesson2Cat01);
		docVocabLessonRepository.save(lesson1Cat02);
		docVocabLessonRepository.save(lesson2Cat02);
		docVocabLessonRepository.save(lesson1Cat03);
		docVocabLessonRepository.save(lesson2Cat03);
		
		System.out.println("DocVocabLesson loaded : " + docVocabLessonRepository.count());
//		System.out.println("Cat 1 : " + cat01.getTitle());
	}
	
	private void setupVocabCategories () {
		DocVocabCategory general = new DocVocabCategory();
		general.setTitle("General topic");
		general.setDescription("This is an general topic");
		
		DocVocabCategory toiecSixHundred = new DocVocabCategory();
		toiecSixHundred.setTitle("600 words TOIEC HCR");
		toiecSixHundred.setDescription("600 words TOIEC HCR");
		
		DocVocabCategory longManVocab = new DocVocabCategory();
		longManVocab.setTitle("Longman Vocabulary");
		longManVocab.setDescription("Subset of Longman Vocabulary");
		
		docVocabCategoryRepository.save(general);
		docVocabCategoryRepository.save(toiecSixHundred);
		docVocabCategoryRepository.save(longManVocab);
		
		System.out.println("DocVocabCategory loaded : " + docVocabCategoryRepository.count());
	}
	
}