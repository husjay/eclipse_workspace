/**
 * 
 */
package com.hsj.girl.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsj.girl.model.Girl;

/**
 * @author hsj
 *
 */
public interface GirlRepository extends JpaRepository<Girl, Long> {
	
	public List<Girl> findGirlsByAge(Integer age);

}
