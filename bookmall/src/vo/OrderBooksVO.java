package vo;

public class OrderBooksVO {

	private Integer odb_no;
	private Integer odb_memNo;
	private Integer odb_bookNo;
	private Integer odb_count;
	private BookVO booksVO;

	public OrderBooksVO(Integer odb_no, Integer odb_memNo, Integer odb_bookNo, Integer odb_count, BookVO booksVO) {
		super();
		this.odb_no = odb_no;
		this.odb_memNo = odb_memNo;
		this.odb_bookNo = odb_bookNo;
		this.odb_count = odb_count;
		this.booksVO = booksVO;
	}

	public OrderBooksVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getOdb_no() {
		return odb_no;
	}

	public void setOdb_no(Integer odb_no) {
		this.odb_no = odb_no;
	}

	public Integer getOdb_memNo() {
		return odb_memNo;
	}

	public void setOdb_memNo(Integer odb_memNo) {
		this.odb_memNo = odb_memNo;
	}

	public Integer getOdb_bookNo() {
		return odb_bookNo;
	}

	public void setOdb_bookNo(Integer odb_bookNo) {
		this.odb_bookNo = odb_bookNo;
	}

	public Integer getOdb_count() {
		return odb_count;
	}

	public void setOdb_count(Integer odb_count) {
		this.odb_count = odb_count;
	}

	public BookVO getBooksVO() {
		return booksVO;
	}

	public void setBooksVO(BookVO booksVO) {
		this.booksVO = booksVO;
	}

	@Override
	public String toString() {
		return "OrderBooksVO [odb_no=" + odb_no + ", odb_memNo=" + odb_memNo + ", odb_bookNo=" + odb_bookNo
				+ ", odb_count=" + odb_count + ", booksVO=" + booksVO + "]";
	}

}
