package com.comittedpeople.englishlearningweb.api.v1.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.comittedpeople.englishlearningweb.api.v1.model.DocGrammarCategoryDTO;
import com.comittedpeople.englishlearningweb.domain.DocGrammarCategory;

public class DocGrammarCategoryMapperTest {

	private static final long _CHILD1ID = 2L;
	private static final long _PARENTID = 4L;
	private DocGrammarCategoryMapper categoryMapper = DocGrammarCategoryMapper.INSTANCE;
	
	@Test
	public void grammarCategoryToCategoryDTO() throws Exception{
		
		DocGrammarCategory parent = getDocGrammarCategory(_PARENTID, "Parent", "Parent Des");
		
		DocGrammarCategory child1 = getDocGrammarCategory(DocGrammarCategoryMapperTest._CHILD1ID, "Child 1", "Child 1 des");
		DocGrammarCategory child2 = getDocGrammarCategory(3L, "Child 2", "Child 2 des");
		
		DocGrammarCategory docGrammarCategory = getDocGrammarCategory(1L, "This Category Title", "This Category Description");
		
		docGrammarCategory.setParentCategory(parent);
		docGrammarCategory.setSubCategories(new HashSet<>(Arrays.asList(child1 ,child2)));
		
		//Khi
		DocGrammarCategoryDTO docGrammarCategoryDTO = categoryMapper.docGrammarCategorytoCategoryDTO(docGrammarCategory);
		
		//Thì
		assertEquals(Long.valueOf(1L), docGrammarCategoryDTO.getId());
		assertEquals("This Category Title", docGrammarCategoryDTO.getTitle());
		assertEquals("This Category Description", docGrammarCategoryDTO.getDescription());
		
		Long parentId = docGrammarCategoryDTO.getParentId();
		assertEquals(Long.valueOf(_PARENTID), parentId);
		
		List<DocGrammarCategoryDTO> subCategoriesDTO = docGrammarCategoryDTO.getChildCategories();
		
		Collections.sort(subCategoriesDTO, (d1, d2) -> {
			return d1.getId().intValue() - d2.getId().intValue();
		});
		
		DocGrammarCategoryDTO subCateDTO01 = subCategoriesDTO.get(0);
		DocGrammarCategoryDTO subCateDTO02 = subCategoriesDTO.get(1);
		
		assertEquals(Long.valueOf(DocGrammarCategoryMapperTest._CHILD1ID), subCateDTO01.getId());
		assertEquals("Child 1", subCateDTO01.getTitle());
		assertEquals("Child 1 des", subCateDTO01.getDescription());
		
		assertEquals(Long.valueOf(3L), subCateDTO02.getId());
		assertEquals("Child 2", subCateDTO02.getTitle());
		assertEquals("Child 2 des", subCateDTO02.getDescription());
		
	}
	
	private DocGrammarCategory getDocGrammarCategory(Long id, String title, String description) {
		DocGrammarCategory result = new DocGrammarCategory();
		result.setDescription(description);
		result.setId(id);
		result.setTitle(title);
		
		return result;
	}
	
}
