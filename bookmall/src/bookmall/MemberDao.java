package bookmall;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DbManager;
import vo.MemberVO;

public class MemberDao implements DbQuery<MemberVO> {

	private DbManager dbManager;
	public PreparedStatement pstmt;
	public Statement stmt;
	public ResultSet rs;
	public String query;

	public MemberDao() {
		super();

	}

	@Override
	public boolean insert(MemberVO member) {


		query = "INSERT INTO BOOKMALL.TBL_MEMBER VALUES(?, ?, ?, ?, ?, ?)";
		try {
			dbManager = DbManager.getInstance();
			pstmt = dbManager.getConnection().prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, member.getMem_name());
			pstmt.setString(3, member.getMem_phone());
			pstmt.setString(4, member.getMem_email());
			pstmt.setString(5, member.getMem_pwd());
			pstmt.setDate(6, member.getMem_joinDate());

			pstmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			dbManager.closeConnection();
		}

		return false;
	}

	@Override
	public boolean update(MemberVO vo) {

		/*
		 * try { query = "UPDATE BOOKMALL.TBL_MEMBER SET ";
		 * 
		 * Field[] fields = MemberVO.class.getFields(); for(int i=0; i<fields.length;
		 * ++i) {
		 * 
		 * String fieldName = fields[i].getName(); Field fieldValue =
		 * vo.getClass().getField(fieldName); if(fieldValue == null ) continue; query +=
		 * fieldName; query += " = "; query += vo.getClass().getField(fieldName);
		 * 
		 * if(i < fields.length) { query += ",";
		 * 
		 * }
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */

		return false;
	}

	@Override
	public MemberVO select(MemberVO vo) {
		try {
			query = "SELECT * FROM BOOKMALL.TBL_MEMBER WHERE ";

			if (vo.getMem_name() != null) {

				query += "mem_name = '";
				query += vo.getMem_name();
				query += "'";

			} else if (vo.getMem_uid() != null) {
				query += "mem_uid = ";
				query += vo.getMem_uid();

			} else {

				throw new IllegalArgumentException("sql문을 지정해 주지 않으면, 반드시 name 혹은 uid를 기본적인 쿼리 조건으로 넘겨주어야 합니다.");
			}

			dbManager = DbManager.getInstance();
			stmt = dbManager.getConnection().createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				vo.setMem_uid(rs.getInt(1));
				vo.setMem_name(rs.getString(2));
				vo.setMem_phone(rs.getString(3));
				vo.setMem_email(rs.getString(4));
				vo.setMem_pwd(rs.getString(5));
				vo.setMem_joinDate(rs.getDate(6));

			}

			return vo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<MemberVO> selectAll() {

		query = "SELECT * FROM BOOKMALL.TBL_MEMBER";

		dbManager = DbManager.getInstance();
		try {
			stmt = dbManager.getConnection().createStatement();
			rs = stmt.executeQuery(query);
			List<MemberVO> members = new ArrayList<MemberVO>();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMem_uid(rs.getInt(1));
				vo.setMem_name(rs.getString(2));
				vo.setMem_phone(rs.getString(3));
				vo.setMem_email(rs.getString(4));
				vo.setMem_pwd(rs.getString(5));
				vo.setMem_joinDate(rs.getDate(6));
				members.add(vo);
			}
			
			return members;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}

	@Override
	public boolean delete(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
