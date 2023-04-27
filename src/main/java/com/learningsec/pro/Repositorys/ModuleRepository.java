package com.learningsec.pro.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningsec.pro.Model.ModuleMaster;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleMaster, Integer> {
	
}
