package bookmall;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DbManager;
import vo.BookVO;
import vo.CategoryVO;

public class BookDao implements DbQuery<BookVO> {

	private DbManager dbManager;
	private Statement stmt;
	private PreparedStatement pstmt;
	private String query;
	private ResultSet rs;

	@Override
	public boolean insert(BookVO vo) {

		dbManager = DbManager.getInstance();
		query = "INSERT INTO BOOKMALL.TBL_BOOKS VALUES (?, ?, ?, ?, ?)";
		try {
			pstmt = dbManager.getConnection().prepareStatement(query);
			pstmt.setInt(1, vo.getBk_no());
			pstmt.setInt(2, vo.getBk_ctg());
			pstmt.setString(3, vo.getBk_title());
			pstmt.setInt(4, vo.getBk_price());
			pstmt.setString(5, vo.getBk_isbn());

			pstmt.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public List<BookVO> selectAll() {

		dbManager = DbManager.getInstance();
		List<BookVO> books = new ArrayList<>();
		query = "SELECT * FROM BOOKMALL.TBL_BOOKS books, BOOKMALL.TBL_CATEGORY ctg WHERE books.bk_ctg = ctg.ctg_no";
		try {

			stmt = dbManager.getConnection().createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				BookVO book = new BookVO();
				book.setBk_no(rs.getInt(1));
				book.setBk_ctg(rs.getInt(2));
				book.setBk_title(rs.getString(3));
				book.setBk_price(rs.getInt(4));
				book.setBk_isbn(rs.getString(5));
				book.setCategoryVO(new CategoryVO(rs.getInt(6), rs.getString(7)));

				books.add(book);

			}
			return books;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public boolean update(BookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BookVO select(BookVO vo) {

		dbManager = DbManager.getInstance();

		if (vo.getBk_isbn() != null) {
			query = "SELECT * FROM BOOKMALL.TBL_BOOKS where bk_isbn = '" + vo.getBk_isbn() + "'";

		}
		BookVO book = new BookVO();

		try {

			stmt = dbManager.getConnection().createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				book.setBk_no(rs.getInt(1));
				book.setBk_ctg(rs.getInt(2));
				book.setBk_title(rs.getString(3));
				book.setBk_price(rs.getInt(4));
				book.setBk_isbn(rs.getString(5));

			}

			return book;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean delete(BookVO no) {
		// TODO Auto-generated method stub
		return false;
	}

}
