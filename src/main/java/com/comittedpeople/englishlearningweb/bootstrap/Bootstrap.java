package com.comittedpeople.englishlearningweb.bootstrap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.comittedpeople.englishlearningweb.domain.DocGrammarCategory;
import com.comittedpeople.englishlearningweb.domain.DocGrammarContent;
import com.comittedpeople.englishlearningweb.domain.DocGrammarExample;
import com.comittedpeople.englishlearningweb.domain.DocGrammarForm;
import com.comittedpeople.englishlearningweb.domain.DocGrammarNote;
import com.comittedpeople.englishlearningweb.domain.DocVocabCategory;
import com.comittedpeople.englishlearningweb.domain.DocVocabContent;
import com.comittedpeople.englishlearningweb.domain.DocVocabLesson;
import com.comittedpeople.englishlearningweb.repositories.DocGrammarCategoryRepository;
import com.comittedpeople.englishlearningweb.repositories.DocGrammarContentRepository;
import com.comittedpeople.englishlearningweb.repositories.DocGrammarExampleRepository;
import com.comittedpeople.englishlearningweb.repositories.DocGrammarFormRepository;
import com.comittedpeople.englishlearningweb.repositories.DocGrammarNoteRepository;
import com.comittedpeople.englishlearningweb.repositories.DocVocabCategoryRepository;
import com.comittedpeople.englishlearningweb.repositories.DocVocabContentRepository;
import com.comittedpeople.englishlearningweb.repositories.DocVocabLessonRepository;

@Component
@Transactional
public class Bootstrap implements CommandLineRunner {
	
	private DocVocabCategoryRepository docVocabCategoryRepository;
	
	private DocVocabLessonRepository docVocabLessonRepository;
	
	private DocVocabContentRepository docVocabContentRepository;
	
	private DocGrammarCategoryRepository docGrammarCategoryRepository;
	
	private DocGrammarExampleRepository docGrammarExampleRepository;
	
	private DocGrammarNoteRepository docGrammarNoteRepository;
	
	private DocGrammarContentRepository docGrammarContentRepository;
	
	private DocGrammarFormRepository docGrammarFormRepository;


	public Bootstrap(DocVocabCategoryRepository docVocabCategoryRepository,
			DocVocabLessonRepository docVocabLessonRepository, DocVocabContentRepository docVocabContentRepository,
			DocGrammarCategoryRepository docGrammarCategoryRepository,
			DocGrammarExampleRepository docGrammarExampleRepository, DocGrammarNoteRepository docGrammarNoteRepository,
			DocGrammarContentRepository docGrammarContentRepository,
			DocGrammarFormRepository docGrammarFormRepository) {
		super();
		this.docVocabCategoryRepository = docVocabCategoryRepository;
		this.docVocabLessonRepository = docVocabLessonRepository;
		this.docVocabContentRepository = docVocabContentRepository;
		this.docGrammarCategoryRepository = docGrammarCategoryRepository;
		this.docGrammarExampleRepository = docGrammarExampleRepository;
		this.docGrammarNoteRepository = docGrammarNoteRepository;
		this.docGrammarContentRepository = docGrammarContentRepository;
		this.docGrammarFormRepository = docGrammarFormRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		setupVocabCategories();
		
		setupVocabLesson();
		
		setupVocabContent();
		
		setupGrammarExample();
		
		setupGrammarNote();
//		
		setupGrammarForm();
//		
		setupGrammarContent();
//		
		setupGrammarCategory();
	}
	
	private void setupGrammarExample() {
		DocGrammarExample ex1 = getGrammarExample(1L, "Example 1", "Image 1");
		DocGrammarExample ex2 = getGrammarExample(2L, "Example 2", "Image 2");
		DocGrammarExample ex3 = getGrammarExample(3L, "Example 3", "Image 3");
		DocGrammarExample ex4 = getGrammarExample(4L, "Example 4", "Image 4");
		DocGrammarExample ex5 = getGrammarExample(5L, "Example 5", "Image 5");
		DocGrammarExample ex6 = getGrammarExample(6L, "Example 6", "Image 6");
		
		docGrammarExampleRepository.save(ex1);
		docGrammarExampleRepository.save(ex2);
		docGrammarExampleRepository.save(ex3);
		docGrammarExampleRepository.save(ex4);
		docGrammarExampleRepository.save(ex5);
		docGrammarExampleRepository.save(ex6);
	}
	
	private void setupGrammarNote() {
		DocGrammarNote note1 = getGrammarNote(1L, "Note 1");
		DocGrammarNote note2 = getGrammarNote(2L, "Note 2");
		DocGrammarNote note3 = getGrammarNote(3L, "Note 3");
		DocGrammarNote note4 = getGrammarNote(4L, "Note 4");
		DocGrammarNote note5 = getGrammarNote(5L, "Note 5");
		DocGrammarNote note6 = getGrammarNote(6L, "Note 6");
		
		docGrammarNoteRepository.save(note1);
		docGrammarNoteRepository.save(note2);
		docGrammarNoteRepository.save(note3);
		docGrammarNoteRepository.save(note4);
		docGrammarNoteRepository.save(note5);
		docGrammarNoteRepository.save(note6);
	}
	
	private void setupGrammarForm() {
		
		DocGrammarExample ex1 = docGrammarExampleRepository.getOne(1L);
		DocGrammarExample ex2 = docGrammarExampleRepository.getOne(2L);
		DocGrammarExample ex3 = docGrammarExampleRepository.getOne(3L);
		DocGrammarExample ex4 = docGrammarExampleRepository.getOne(4L);
		DocGrammarExample ex5 = docGrammarExampleRepository.getOne(5L);
		DocGrammarExample ex6 = docGrammarExampleRepository.getOne(6L);
		
		List<DocGrammarExample> docGrammarExamples1 = Arrays.asList(ex1, ex2);
		List<DocGrammarExample> docGrammarExamples2 = Arrays.asList(ex3, ex4);

		
		DocGrammarNote note1 = docGrammarNoteRepository.getOne(1L);
		DocGrammarNote note2 = docGrammarNoteRepository.getOne(2L);
		DocGrammarNote note3 = docGrammarNoteRepository.getOne(3L);
		DocGrammarNote note4 = docGrammarNoteRepository.getOne(4L);
		DocGrammarNote note5 = docGrammarNoteRepository.getOne(5L);
		DocGrammarNote note6 = docGrammarNoteRepository.getOne(6L);
		
		List<DocGrammarNote> grammarNotes1 = Arrays.asList(note1, note2);
		List<DocGrammarNote> grammarNotes2 = Arrays.asList(note3, note4);
		
		DocGrammarForm form = getGrammarForm(1L, "Forming the comparative", "Words of one syllable ending in e",
				"Add -r to the end of word", "Wide - Wider", docGrammarExamples1, grammarNotes1);
		

		DocGrammarForm form2 = getGrammarForm(2L, "Forming the comparative 2", "Words of one syllable ending in e",
				"Add -r to the end of word", "Wide - Wider", docGrammarExamples2, grammarNotes2);

		DocGrammarForm form3 = getGrammarForm(3L, "Forming the comparative 3", "Words of one syllable ending in e",
				"Add -r to the end of word", "Wide - Wider", Arrays.asList(ex5), Arrays.asList(note5));
		
		DocGrammarForm form4 = getGrammarForm(4L, "Forming the comparative 4", "Words of one syllable ending in e",
				"Add -r to the end of word", "Wide - Wider", Arrays.asList(ex6), Arrays.asList(note6));
		
		docGrammarFormRepository.save(form);
		docGrammarFormRepository.save(form2);
		docGrammarFormRepository.save(form3);
		docGrammarFormRepository.save(form4);
	}
	
	private void setupGrammarContent() {
		
		DocGrammarForm form = docGrammarFormRepository.getOne(1L);
		DocGrammarForm form2 = docGrammarFormRepository.getOne(2L);
		DocGrammarForm form3 = docGrammarFormRepository.getOne(3L);
		DocGrammarForm form4 = docGrammarFormRepository.getOne(4L);
		
		List<DocGrammarForm> grammarForms = Arrays.asList(form, form2);
		List<DocGrammarForm> grammarForms2 = Arrays.asList(form3, form4);
		
		DocGrammarContent content1 = getGrammarContent(1L, "Comparative", "When we compare things...", grammarForms);
		DocGrammarContent content2 = getGrammarContent(2L, "Comparative 2", "When we ...", grammarForms2);
		
		docGrammarContentRepository.save(content1);
		docGrammarContentRepository.save(content2);
	}
	
	private void setupGrammarCategory() {
		DocGrammarContent content1 = docGrammarContentRepository.getOne(1L);
		DocGrammarContent content2 = docGrammarContentRepository.getOne(2L);
		
		List<DocGrammarContent> contents = Arrays.asList(content1, content2);
		
		DocGrammarCategory category = getGrammarCategory(1L, "Adjective", "It's adjective", contents);
		
		docGrammarCategoryRepository.save(category);
		
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
	
	private DocGrammarCategory getGrammarCategory(Long id, String title, String description, List<DocGrammarContent> grammars) {
		DocGrammarCategory category = new DocGrammarCategory();
		
		for (DocGrammarContent content : grammars) {
			content.setCategory(category);
		}
		
		category.setId(id);
		category.setTitle(title);
		category.setDescription(description);
		category.setGrammars(new HashSet<DocGrammarContent>(grammars));
		
		return category;
	}
	
	private DocGrammarContent getGrammarContent(Long id, String title, String description, List<DocGrammarForm> forms) {
		DocGrammarContent grammarContent = new DocGrammarContent();
		
		for (DocGrammarForm form : forms) {
			form.setDocGrammarContent(grammarContent);
		}
		
		grammarContent.setTitle(title);
		grammarContent.setId(id);
		grammarContent.setDescription(description);
		grammarContent.setForms(new HashSet<>(forms));
		
		return grammarContent;
		
	}

	private DocGrammarForm getGrammarForm(Long ID, String title, String usage, String useCase, String how,
			List<DocGrammarExample> examples, List<DocGrammarNote> notes) {
		DocGrammarForm form = new DocGrammarForm();

		for (DocGrammarExample example : examples) {
			example.setDocGrammarForm(form);
		}
		for (DocGrammarNote note : notes) {
			note.setDocGrammarForm(form);
		}
		
		form.setExamples(new HashSet<DocGrammarExample>(examples));
		form.setHow(how);
		form.setId(ID);
		form.setNotes(new HashSet<DocGrammarNote>(notes));
		form.setTitle(title);
		form.setUsage(usage);
		form.setUseCase(useCase);

		return form;
	}

	private DocGrammarExample getGrammarExample(Long ID, String content, String imageURL) {
		DocGrammarExample res = new DocGrammarExample();

		res.setId(ID);
		res.setContent(content);
		res.setImageURL(imageURL);

		return res;

	}

	private DocGrammarNote getGrammarNote(Long id, String content) {
		DocGrammarNote result = new DocGrammarNote();
		result.setId(id);
		result.setContent(content);

		return result;
	}
	
}
