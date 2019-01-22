package bookmall_test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bookmall.MemberDao;
import vo.MemberVO;

public class MemberDaoTest {

	private MemberDao memberDao;

	@Before
	public void setUpBeforeRun() {

		memberDao = new MemberDao();

	}

	@Test
	public void testAMemberCreate() {

		MemberVO member = new MemberVO(0, "김기덕", "010-8223-8134", "gdtbgl93@gmail.com", "k1234",
				new Date(new java.util.Date().getTime()));
		assertTrue("회원 삽입 실패", memberDao.insert(member));

		member = new MemberVO(0, "김기순", "010-1234-1234", "ggsoon@gmail.com", "k1234",
				new Date(new java.util.Date().getTime()));
		assertTrue("회원 삽입 실패", memberDao.insert(member));

	}

	@Test
	public void testBMemberRead() {

		List<MemberVO> members = memberDao.selectAll();

		int count = 1;

		for (MemberVO vo : members) {
			System.out.print(count + ". ");
			System.out.println(vo.toString());
			count++;
		}

		System.out.println("==================================");

	}

}
