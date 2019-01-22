package bookmall;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DbManager;
import vo.BookVO;
import vo.CartVO;

public class CartDao implements DbQuery<CartVO> {

	private DbManager dbManager;
	private Statement stmt;
	private PreparedStatement pstmt;
	private String query;
	private ResultSet rs;

	@Override
	public boolean insert(CartVO vo) {

		dbManager = DbManager.getInstance();
		query = "INSERT INTO BOOKMALL.TBL_CART VALUES (?, ?, ?)";
		try {
			pstmt = dbManager.getConnection().prepareStatement(query);
			pstmt.setInt(1, vo.getCt_bookNo());
			pstmt.setInt(2, vo.getCt_memNo());
			pstmt.setInt(3, vo.getCt_count());

			pstmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(CartVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CartVO select(CartVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CartVO> selectAll(CartVO vo) {

		List<CartVO> carts = new ArrayList<CartVO>();
		dbManager = DbManager.getInstance();
		
		query = "SELECT * FROM TBL_BOOKS BK, TBL_CART CRT WHERE BK.BK_NO = CRT.CT_BOOKNO";
		
		try {
			stmt = dbManager.getConnection().createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				CartVO cartVO = new CartVO();
				
				cartVO.setBookVO(new BookVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
				cartVO.setCt_bookNo(rs.getInt(6));
				cartVO.setCt_memNo(rs.getInt(7));
				cartVO.setCt_count(rs.getInt(8));
				carts.add(cartVO);

			}

			return carts;

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			
			dbManager.closeConnection();
		}

		return null;
	}
	
	

	@Override
	public boolean delete(CartVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAll(Integer memberNo) {

		dbManager = DbManager.getInstance();
		query = "DELETE FROM BOOKMALL.TBL_CART WHERE CT_MEMNO = ";
		query += String.valueOf(memberNo);
		try {
			System.out.println(query);

			dbManager = DbManager.getInstance();
			stmt = dbManager.getConnection().createStatement();
			stmt.execute(query);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.closeConnection();
		}

		return false;
	}

}
