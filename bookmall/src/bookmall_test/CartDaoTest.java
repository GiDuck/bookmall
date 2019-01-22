package bookmall_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import bookmall.BookDao;
import bookmall.CartDao;
import bookmall.MemberDao;
import vo.BookVO;
import vo.CartVO;
import vo.MemberVO;

public class CartDaoTest {

	private CartDao cartDao;
	private MemberDao memberDao;
	private BookDao bookDao;

	@Before
	public void setUp() {

		cartDao = new CartDao();
		memberDao = new MemberDao();
		bookDao = new BookDao();

	}

	@Test
	public void testACreateCart() {

		MemberVO memberVO = new MemberVO();
		memberVO.setMem_name("김기덕");
		memberVO = memberDao.select(memberVO);

		BookVO bookVO = new BookVO();
		bookVO.setBk_isbn("000-11-000-22");
		bookVO = bookDao.select(bookVO);

		CartVO cart = new CartVO();
		cart.setCt_memNo(memberVO.getMem_uid());
		cart.setCt_bookNo(bookVO.getBk_no());
		cart.setCt_count(1);
		assertTrue("카트 삽입 실패", cartDao.insert(cart));

		bookVO = new BookVO();
		bookVO.setBk_isbn("000-11-000-23");
		bookVO = bookDao.select(bookVO);
		cart = new CartVO();
		cart.setCt_memNo(memberVO.getMem_uid());
		cart.setCt_bookNo(bookVO.getBk_no());
		cart.setCt_count(2);
		assertTrue("카트 삽입 실패", cartDao.insert(cart));

	}

	@Test
	public void testBReadCart() {
		CartVO cart = new CartVO();
		cart = new CartVO();
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_name("김기덕");
		memberVO = memberDao.select(memberVO);
		
		cart.setCt_memNo(memberVO.getMem_uid());
		List<CartVO> carts = cartDao.selectAll(cart);

		int count = 1;

		for (CartVO vo : carts) {

			System.out.print(count++ + ". ");
			System.out.print(vo.getBookVO().getBk_title() + " , ");
			System.out.print(vo.getCt_count() + "개 , ");
			System.out.println(vo.getBookVO().getBk_price());

		}

		System.out.println(" ==================== ");

	}

}
