package web.member.service;

import java.util.List;

import web.member.vo.Member;

public interface MemberService {
	
	boolean registerMember(Member member);

	List<Member> findAllMembers();
	
}
