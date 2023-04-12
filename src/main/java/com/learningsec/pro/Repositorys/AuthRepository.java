package com.learningsec.pro.Repositorys;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learningsec.pro.Model.AuthModel;

@Repository
@EnableJpaRepositories
public interface AuthRepository extends JpaRepository<AuthModel, Integer>{

	AuthModel findByEmail(String email);



}
