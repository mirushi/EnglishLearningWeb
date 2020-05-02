package com.comittedpeople.englishlearningweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.comittedpeople.englishlearningweb.domain.DocVocabCategory;
import com.comittedpeople.englishlearningweb.repositories.DocVocabCategoryRepository;

@Component
public class Bootstrap implements CommandLineRunner {
	
	private DocVocabCategoryRepository docVocabCategoryRepository;
	
	public Bootstrap(DocVocabCategoryRepository docVocabCategoryRepository) {
		this.docVocabCategoryRepository = docVocabCategoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
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
