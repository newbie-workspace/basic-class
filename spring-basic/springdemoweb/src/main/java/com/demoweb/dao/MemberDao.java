package com.demoweb.dao;

import com.demoweb.dto.MemberDto;

public interface MemberDao {

	void insertMember(MemberDto member);
	
	MemberDto checkMember(String memberId, String passwd);

	int selectMemberCountById(String memberId);

}