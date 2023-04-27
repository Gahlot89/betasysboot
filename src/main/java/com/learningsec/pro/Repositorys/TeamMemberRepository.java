package com.learningsec.pro.Repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learningsec.pro.Model.TeamMember;
import com.learningsec.pro.Model.User;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer>{

	@Query(value = "SELECT tm.id as id, tm.member_id as memberId ,user.username as memberName,user.profile as memberProfile,user.email as memberEmail,tm.member_role as memberRole from team_member as tm Inner join user_data as user on user.id = tm.member_id where tm.project_projectid = :projectID", nativeQuery = true)
	List<TeamMember> findAllByProjectID(@Param("projectID") int projectID);
	
	
	@Query(value = "select user.username as memberName from user_data as user where user.id =:id",nativeQuery = true)
	TeamMember getTemaMember(@Param("id") int id);
	
	@Query(value = "select tm.id as id,user.id as member_id,user.username as member_name,user.email as member_email,tm.member_role,user.profile as memberProfile from dexcoder.user_data user Inner join dexcoder.team_member as tm on user.id = tm.member_id where user.id =2",nativeQuery = true)
	List<TeamMember> findProjectTeamMembersWithUserDetails(@Param("projectId") int projectId);
	

}
