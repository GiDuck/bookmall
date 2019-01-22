package vo;

public class CategoryVO {

	private Integer ctg_no;
	private String ctg_name;
	
	
	
	
	public CategoryVO(Integer ctg_no, String ctg_name) {
		super();
		this.ctg_no = ctg_no;
		this.ctg_name = ctg_name;
	}
	
	
	public CategoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCtg_no() {
		return ctg_no;
	}
	public void setCtg_no(Integer ctg_no) {
		this.ctg_no = ctg_no;
	}
	public String getCtg_name() {
		return ctg_name;
	}
	public void setCtg_name(String ctg_name) {
		this.ctg_name = ctg_name;
	}
	@Override
	public String toString() {
		return "CategoryVO [ctg_no=" + ctg_no + ", ctg_name=" + ctg_name + "]";
	}
	
	
	
	
}
