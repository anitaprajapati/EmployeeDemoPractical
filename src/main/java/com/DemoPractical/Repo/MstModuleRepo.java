package com.DemoPractical.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DemoPractical.Model.MstModuleBo;

@Repository
public interface MstModuleRepo extends JpaRepository<MstModuleBo, Integer>{

}
