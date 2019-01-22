package bookmall_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import bookmall.BookDao;
import bookmall.CategoryDao;
import junit.framework.TestCase;
import vo.BookVO;
import vo.CategoryVO;

public class BookDaoTest {

	
	private BookDao bookDao;	
	private CategoryDao categoryDao;

	
	@Before
	public void setUp() {
		
		bookDao = new BookDao();
		categoryDao = new CategoryDao();
	}




	@Test
	public void testAInsertBooks() {

		
		
		CategoryVO ctgVO =  new CategoryVO();
		ctgVO.setCtg_name("인문");
		ctgVO = categoryDao.select(ctgVO);
		BookVO book = new BookVO(0, ctgVO.getCtg_no(), "정의란 무엇인가", 30000, "000-11-000-22");
		assertTrue("책 삽입 실패", bookDao.insert(book));
		
		book = new BookVO(0, ctgVO.getCtg_no(), "피자를 잘 굽는법", 55000, "000-11-000-23");
		assertTrue("책 삽입 실패", bookDao.insert(book));
		
		ctgVO =  new CategoryVO();
		ctgVO.setCtg_name("과학");
		ctgVO = categoryDao.select(ctgVO);
		book = new BookVO(0, ctgVO.getCtg_no(), "우주를 넘어서", 88000, "000-11-000-24");
		assertTrue("책 삽입 실패", bookDao.insert(book));
		
		
	
	}
	
	
	@Test
	public void testBSelectAllBooks() {
		

		
		List<BookVO> books = bookDao.selectAll();
		
		int count = 1;
		for(BookVO book : books) {
		
			System.out.print( count++ + ". ");
			System.out.print( book.getBk_title() + ", ");
			System.out.print( book.getCategoryVO().getCtg_name() + ", ");
			System.out.print( book.getBk_price() + ", ");
			System.out.println( book.getBk_isbn());
		
		}
		
		System.out.println("=========================");
		
		
	}

}
