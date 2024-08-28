package kr.ac.kopo.member.vo;

public class MemberVO {
    
	private String memberId;
    private String memberName;
    private String password;
    private String phone;
    private String email;
    private String writeAuth;
    private String type;
    
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWriteAuth() {
		return writeAuth;
	}
	public void setWriteAuth(String writeAuth) {
		this.writeAuth = writeAuth;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberName=" + memberName + ", password=" + password + ", phone="
				+ phone + ", email=" + email + ", writeAuth=" + writeAuth + ", type=" + type + "]";
	}

	
}
