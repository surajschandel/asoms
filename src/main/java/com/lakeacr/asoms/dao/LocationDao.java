package com.lakeacr.asoms.dao;

import java.util.List;

import com.lakeacr.asoms.domain.Locations;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public interface LocationDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Locations findById(long id);
	/**
	 * 
	 * @param location
	 * @return
	 */
	public Locations saveOrUpdate(Locations location);
	
	/**
	 * 
	 * @return
	 */
	public List<Locations> saveAll(List<Locations> location);
	/**
	 * 
	 * @param code
	 * @return
	 */
	public Locations findByLocationCode(String code);

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
	public List<Locations> findAll();
	
	/**
	 * 
	 * @return
	 */
	public int countActive();

}
