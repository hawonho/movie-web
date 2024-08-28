package kr.ac.kopo.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.member.vo.MemberVO;

public class MemberDAO {
    private SqlSession Session;

    public MemberDAO() {
       Session = new MyBatisConfig().getInstance();
    }

    public void join(MemberVO member) {
        Session.insert("MemberMapper.join", member);
        Session.commit();
    }

	public MemberVO login(String memberId, String password) {
		MemberVO member = new MemberVO();
		member.setMemberId(memberId);
		member.setPassword(password);
		MemberVO user = Session.selectOne("MemberMapper.login", member);
		System.out.println(user);
		
		return user;
    }

    public void updateWriteAuth(String memberId, String writeAuth) {
    	MemberVO member = new MemberVO();
    	member.setMemberId(memberId);
    	member.setWriteAuth(writeAuth);
        Session.update("MemberMapper.updateWriteAuth", member);
        Session.commit();
    }
    
    public List<MemberVO> getAllMembers() {
    	List<MemberVO> memberList = Session.selectList("MemberMapper.getAllMembers");
    	return memberList;
    }
}
