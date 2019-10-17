package com.kb.org.member;

public class MemberVO {
	private String name;
	private String id;
	private String pwd;
	private int seq;
	private String joindate;
	private String gender;
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", id=" + id + ", pwd=" + pwd + ", seq=" + seq + ", joindate=" + joindate
				+ ", gender=" + gender + "]";
	}
	public MemberVO() {}
	public MemberVO(String name, String id, String pwd, int seq, String joindate, String gender) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.seq = seq;
		this.joindate = joindate;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
