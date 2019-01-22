package bookmall;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DbManager;
import vo.CategoryVO;

public class CategoryDao implements DbQuery<CategoryVO> {

	private DbManager dbManager;
	private Statement stmt;
	private PreparedStatement pstmt;
	private String query;
	private ResultSet rs;

	@Override
	public boolean insert(CategoryVO vo) {

		dbManager = dbManager.getInstance();
		query = "INSERT INTO BOOKMALL.TBL_CATEGORY VALUES ( ?, ? )";
		try {
			pstmt = dbManager.getConnection().prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, vo.getCtg_name());
			pstmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			dbManager.closeConnection();

		}

		return false;
	}

	public List<CategoryVO> selectAll() {

		dbManager = dbManager.getInstance();
		List<CategoryVO> categories = new ArrayList<>();

		query = "SELECT * FROM BOOKMALL.TBL_CATEGORY";
		try {
			stmt = dbManager.getConnection().createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				CategoryVO ctg = new CategoryVO();
				ctg.setCtg_no(rs.getInt(1));
				ctg.setCtg_name(rs.getString(2));
				categories.add(ctg);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.closeConnection();

		}
		return categories;

	}

	@Override
	public boolean update(CategoryVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CategoryVO select(CategoryVO vo) {
		dbManager = dbManager.getInstance();
		CategoryVO category = new CategoryVO();

		if (vo.getCtg_name() != null) {

			query = "SELECT * FROM BOOKMALL.TBL_CATEGORY WHERE ctg_name = '" + vo.getCtg_name() + "'";

		} else if (vo.getCtg_no() != null) {

			query = "SELECT * FROM BOOKMALL.TBL_CATEGORY WHERE ctg_no = " + vo.getCtg_no();

		} else {

			throw new IllegalArgumentException("검색할 키워드를 삽입하세요.. 이름 혹은 번호를 vo에 추가하십시오..");
		}

		try {
			stmt = dbManager.getConnection().createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				category.setCtg_no(rs.getInt(1));
				category.setCtg_name(rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public boolean delete(CategoryVO no) {
		// TODO Auto-generated method stub
		return false;
	}

}
