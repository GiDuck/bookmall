package vo;

import java.util.Date;

public class OrderVO {

	private Integer od_no;
	private Integer od_memNo;
	private String od_address;
	private Date od_date;
	
	private MemberVO memberVO;

	public OrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderVO(Integer od_no, Integer od_memNo, String od_address, Date od_date) {
		super();
		this.od_no = od_no;
		this.od_memNo = od_memNo;
		this.od_address = od_address;
		this.od_date = od_date;
	}

	public Integer getOd_no() {
		return od_no;
	}

	public void setOd_no(Integer od_no) {
		this.od_no = od_no;
	}

	public Integer getOd_memNo() {
		return od_memNo;
	}

	public void setOd_memNo(Integer od_memNo) {
		this.od_memNo = od_memNo;
	}

	public String getOd_address() {
		return od_address;
	}

	public void setOd_address(String od_address) {
		this.od_address = od_address;
	}

	public Date getOd_date() {
		return od_date;
	}

	public void setOd_date(Date od_date) {
		this.od_date = od_date;
	}
	

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	@Override
	public String toString() {
		return "OrderVO [od_no=" + od_no + ", od_memNo=" + od_memNo + ", od_address=" + od_address + ", od_date="
				+ od_date + "]";
	}

}
