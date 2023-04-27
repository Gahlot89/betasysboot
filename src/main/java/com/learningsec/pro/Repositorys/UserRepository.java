package com.learningsec.pro.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learningsec.pro.Model.TeamMember;
import com.learningsec.pro.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
	
	@Query(value = "select * from user_data as user where user.id =:userID",nativeQuery = true)
	User findByIDForPro(@Param("userID") int id);

}
