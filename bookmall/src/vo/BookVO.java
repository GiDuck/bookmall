package vo;

public class BookVO {

	private Integer bk_no;
	private Integer bk_ctg;
	private String bk_title;
	private Integer bk_price;
	private String bk_isbn;
	private CategoryVO categoryVO;
	

	public BookVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookVO(Integer bk_no, Integer bk_ctg, String bk_title, Integer bk_price, String bk_isbn) {
		super();
		this.bk_no = bk_no;
		this.bk_ctg = bk_ctg;
		this.bk_title = bk_title;
		this.bk_price = bk_price;
		this.bk_isbn = bk_isbn;
	}

	public Integer getBk_no() {
		return bk_no;
	}

	public void setBk_no(Integer bk_no) {
		this.bk_no = bk_no;
	}

	public Integer getBk_ctg() {
		return bk_ctg;
	}

	public void setBk_ctg(Integer bk_ctg) {
		this.bk_ctg = bk_ctg;
	}

	public String getBk_title() {
		return bk_title;
	}

	public void setBk_title(String bk_title) {
		this.bk_title = bk_title;
	}

	public Integer getBk_price() {
		return bk_price;
	}

	public void setBk_price(Integer bk_price) {
		this.bk_price = bk_price;
	}

	public String getBk_isbn() {
		return bk_isbn;
	}

	public void setBk_isbn(String bk_isbn) {
		this.bk_isbn = bk_isbn;
	}
	

	public CategoryVO getCategoryVO() {
		return categoryVO;
	}

	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}

	@Override
	public String toString() {
		
		String str = bk_no + ", " + bk_ctg + ", " +  bk_title + ", " +  bk_price + ", " + bk_isbn;
		return str;
		
	}

}
