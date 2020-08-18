package com.lakeacr.asoms.dao;

import java.util.List;

import com.lakeacr.asoms.domain.Centers;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface CenterDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Centers findById(long id);
	/**
	 * 
	 * @param centers
	 * @return
	 */
	public Centers saveOrUpdate(Centers centers);
	
	/**
	 * 
	 * @return
	 */
	public List<Centers> saveAll(List<Centers> location);
	/**
	 * 
	 * @param code
	 * @return
	 */
	public Centers findByCenterCode(String code);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public void deleteById(long id);
	/**
	 * 
	 * @return
	 */
	public List<Centers> findAll();
	
	/**
	 * 
	 * @return
	 */
	public int countActive();

}
