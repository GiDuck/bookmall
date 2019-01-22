package bookmall_test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import bookmall.BookDao;
import bookmall.CartDao;
import bookmall.MemberDao;
import bookmall.OrderDao;
import junit.framework.TestCase;
import vo.BookVO;
import vo.CartVO;
import vo.MemberVO;
import vo.OrderBooksVO;
import vo.OrderVO;

public class OrderDaoTest {

	
	private OrderDao orderDao;
	private CartDao cartDao;
	private MemberDao memberDao;
	
	@Before
	public void setUp() {
		
		orderDao = new OrderDao();
		cartDao = new CartDao();
		memberDao = new MemberDao();
		
	}
	

	@Test
	public void testAOrderInsert() {
		
		List<CartVO> myCarts = new ArrayList<>();
		
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_name("김기덕");
		memberVO = memberDao.select(memberVO);
		
		OrderVO orderVO = new OrderVO();
		orderVO.setOd_no(0);
		orderVO.setOd_memNo(memberVO.getMem_uid());
		orderVO.setOd_date(new Date());
		orderVO.setOd_address("부산시 부산진구 부암동 어딘가");

		assertTrue("주문 등록 실패", orderDao.insert(orderVO));

		
		CartVO cartVO = new CartVO();
		cartVO.setCt_memNo(memberVO.getMem_uid());
		myCarts = cartDao.selectAll(cartVO);

		OrderVO vo = new OrderVO();
		vo.setOd_memNo(memberVO.getMem_uid());
		vo = orderDao.select(vo);
		
		
		assertTrue("booklist 넣기 실패", orderDao.insertBooksList(vo.getOd_no(), myCarts));
		assertTrue("cart 삭제 실패", cartDao.deleteAll(vo.getOd_no()));

		
		
		
	}
	
	@Test
	public void testBOrderSelect() {
		
		
		List<OrderVO> orders = orderDao.selectAllOrders();
		
		int count = 1;
		for(OrderVO vo : orders) {
			
			System.out.print( count ++ + ". ");
			System.out.print( vo.getMemberVO().getMem_name() + "/" );
			System.out.print( vo.getMemberVO().getMem_email() + " ");
			System.out.println( vo.getOd_address());
			
			List<OrderBooksVO> orderBooks = orderDao.selectAllOrderBooks(vo.getOd_no());
			int price = 0;
			for(OrderBooksVO odb : orderBooks) {
				
				
				price += (odb.getBooksVO().getBk_price() * odb.getOdb_count());
				System.out.print("\t\t" + odb.getBooksVO().getBk_title() + " , ");
				System.out.print(odb.getBooksVO().getBk_price() + " , ");
				System.out.println(odb.getOdb_count() + " 개");
			}
			
			System.out.println("총 가격.. " + price);
			System.out.println("========================================");
			

			
		}
		
	}

}
