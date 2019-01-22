package bookmall_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import bookmall.CategoryDao;
import junit.framework.TestCase;
import vo.CategoryVO;

public class CategoryDaoTest{

	private CategoryDao categoryDao;
	
	@Before
	public void setUpBeforeRun() {
		
		categoryDao = new CategoryDao();
		
	}
	
	@Test
	public void testACreateCategory() {
		
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCtg_name("인문");
		assertTrue("카테고리 삽입 실패", categoryDao.insert(categoryVO));
		
		categoryVO.setCtg_name("과학");
		assertTrue("카테고리 삽입 실패", categoryDao.insert(categoryVO));
		
		categoryVO.setCtg_name("외국어");
		assertTrue("카테고리 삽입 실패", categoryDao.insert(categoryVO));
			
	}
	
	
	@Test
	public void testBReadCategory() {
	
		List<CategoryVO> categories = categoryDao.selectAll();
		
		int count = 1;
		for(CategoryVO ctg : categories) {
			
			System.out.print(count ++ + ". ");
			System.out.println(ctg.getCtg_name());
			
		}
		
		System.out.println("=========================");		
		
		
		
	}
	
	

}
