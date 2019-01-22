package vo;

public class CartVO {

	private Integer ct_bookNo;
	private Integer ct_memNo;
	private Integer ct_count;
	
	private BookVO bookVO;
	private MemberVO memberVO;
	
	
	public CartVO() {
		super();
	}



	public CartVO(Integer ct_bookNo, Integer ct_memNo, Integer ct_count) {
		super();
		this.ct_bookNo = ct_bookNo;
		this.ct_memNo = ct_memNo;
		this.ct_count = ct_count;
	}

	public Integer getCt_bookNo() {
		return ct_bookNo;
	}

	public void setCt_bookNo(Integer ct_bookNo) {
		this.ct_bookNo = ct_bookNo;
	}

	public Integer getCt_memNo() {
		return ct_memNo;
	}

	public void setCt_memNo(Integer ct_memNo) {
		this.ct_memNo = ct_memNo;
	}

	
	public Integer getCt_count() {
		return ct_count;
	}


	public void setCt_count(Integer ct_count) {
		this.ct_count = ct_count;
	}



	public BookVO getBookVO() {
		return bookVO;
	}



	public void setBookVO(BookVO bookVO) {
		this.bookVO = bookVO;
	}



	public MemberVO getMemberVO() {
		return memberVO;
	}



	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}



	@Override
	public String toString() {
		return "CartVO [ct_bookNo=" + ct_bookNo + ", ct_memNo=" + ct_memNo + ", ct_count=" + ct_count + "]";
	}



	

	
	
}
