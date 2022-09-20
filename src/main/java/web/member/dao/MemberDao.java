package web.member.dao;

import java.util.List;

import web.member.vo.Member;

public interface MemberDao {
	
	Integer insert(Member member);
	
	Member selectByMemberEmail(String memberEmail);

	List<Member> selectAll();

}