package com.bs.firstboot.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bs.firstboot.model.dto.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Override
	public List<Member> selectMemberAll(SqlSession session) {
		return session.selectList("member.selectMemberAll");
	}

	@Override
	public Member selectMemberById(SqlSession session, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(SqlSession session, Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(SqlSession session, Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(SqlSession session, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
