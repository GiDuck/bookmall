package vo;

import java.sql.Date;

public class MemberVO {

	private Integer mem_uid;
	private String mem_name;
	private String mem_phone;
	private String mem_email;
	private String mem_pwd;
	private Date mem_joinDate;

	public MemberVO(Integer mem_uid, String mem_name, String mem_phone, String mem_email, String mem_pwd,
			Date mem_joinDate) {
		super();
		this.mem_uid = mem_uid;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
		this.mem_pwd = mem_pwd;
		this.mem_joinDate = mem_joinDate;
	}

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMem_uid() {
		return mem_uid;
	}

	public void setMem_uid(Integer mem_uid) {
		this.mem_uid = mem_uid;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public Date getMem_joinDate() {
		return mem_joinDate;
	}

	public void setMem_joinDate(Date mem_joinDate) {
		this.mem_joinDate = mem_joinDate;
	}

	@Override
	public String toString() {
		String str = mem_uid + ", " + mem_name + ", " + mem_phone + ", " + mem_email + ", " + mem_pwd + ", "
				+ mem_joinDate.toString();
		return str;

	}
}
