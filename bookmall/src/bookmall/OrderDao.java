package bookmall;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall_test.MemberDaoTest;
import util.DbManager;
import vo.BookVO;
import vo.CartVO;
import vo.MemberVO;
import vo.OrderBooksVO;
import vo.OrderVO;

public class OrderDao implements DbQuery<OrderVO> {

	private DbManager dbManager;
	private Statement stmt;
	private PreparedStatement pstmt;
	private String query;
	private ResultSet rs;

	@Override
	public boolean insert(OrderVO vo) {

		dbManager = DbManager.getInstance();
		try {
			query = "INSERT INTO BOOKMALL.TBL_ORDER VALUES (?, ?, ?, ?)";
			pstmt = dbManager.getConnection().prepareStatement(query);
			pstmt.setInt(1, vo.getOd_no());
			pstmt.setInt(2, vo.getOd_memNo());
			pstmt.setString(3, vo.getOd_address());
			pstmt.setDate(4, new java.sql.Date(vo.getOd_date().getTime()));
			pstmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean insertBooksList(int orderNo, List<CartVO> myCarts) {

		dbManager = DbManager.getInstance();
		try {
			query = "INSERT INTO BOOKMALL.TBL_ORDER_BOOKS VALUES (?, ?, ?)";

			for (CartVO vo : myCarts) {

				pstmt = dbManager.getConnection().prepareStatement(query);
				pstmt.setInt(1, orderNo);
				pstmt.setInt(2, vo.getCt_bookNo());
				pstmt.setInt(3, vo.getCt_count());

				pstmt.executeUpdate();
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public List<OrderVO> selectAllOrders() {

		dbManager = DbManager.getInstance();
		List<OrderVO> orders = new ArrayList<>();
		try {

			query = "SELECT * FROM TBL_MEMBER MEMBER, TBL_ORDER ORDERS WHERE MEMBER.MEM_UID = ORDERS.OD_MEMNO";

			stmt = dbManager.getConnection().createStatement();
			rs = stmt.executeQuery(query);

			for (;rs.next();) {

				OrderVO vo = new OrderVO();
				vo.setMemberVO(new MemberVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6)));
				vo.setOd_no(rs.getInt(7));
				vo.setOd_memNo(rs.getInt(8));
				vo.setOd_address(rs.getString(9));
				vo.setOd_date(rs.getDate(10));
				orders.add(vo);
			}

			return orders;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;

	}

	public List<OrderBooksVO> selectAllOrderBooks(int orderNo) {
		dbManager = DbManager.getInstance();
		List<OrderBooksVO> orderBooks = new ArrayList<>();
		query = "SELECT * from tbl_Books bk, tbl_order_books odb where bk.bk_no = odb.od_bookNo and  odb.od_no =  "
				+ String.valueOf(orderNo);
		try {
			stmt = dbManager.getConnection().createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				OrderBooksVO vo = new OrderBooksVO();
				vo.setBooksVO(new BookVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
				vo.setOdb_no(rs.getInt(6));
				vo.setOdb_bookNo(rs.getInt(7));
				vo.setOdb_count(rs.getInt(8));
				orderBooks.add(vo);

			}

			return orderBooks;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			dbManager.closeConnection();
		}

		return orderBooks;

	}

	@Override
	public boolean update(OrderVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderVO select(OrderVO vo) {
		dbManager = DbManager.getInstance();

		OrderVO orderVO = new OrderVO();
		if (vo.getOd_memNo() != null) {

			query = "SELECT * from tbl_order where od_memNo = " + vo.getOd_memNo();

		} else {
			throw new IllegalArgumentException("검색할 사용자의 번호를 포함시키십시오.");
		}

		try {
			stmt = dbManager.getConnection().createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				orderVO.setOd_no(rs.getInt(1));
				orderVO.setOd_memNo(rs.getInt(2));
				orderVO.setOd_address(rs.getString(3));
				orderVO.setOd_date(rs.getDate(4));
			}
			
			return orderVO;

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			dbManager.closeConnection();
		}

		return null;
	}

	@Override
	public boolean delete(OrderVO no) {
		// TODO Auto-generated method stub
		return false;
	}

}
