package bookmall_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
 * Test Case를 실행 시키는 Junit 클래스입니다. 
 * Run을 시키면 순차적으로 테스트 케이스가 실행됩니다.
 * */


@RunWith(Suite.class)
@SuiteClasses({ MemberDaoTest.class, CategoryDaoTest.class, BookDaoTest.class, CartDaoTest.class, OrderDaoTest.class })
public class SuiteTestController {


}
