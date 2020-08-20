package com.lakeacr.asoms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakeacr.asoms.dao.CenterDao;
import com.lakeacr.asoms.dao.LocationDao;
import com.lakeacr.asoms.dao.SubjectsDao;
import com.lakeacr.asoms.dto.DashboardCount;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
@Service
public class DashBoardServiceImpl implements DashBoardService {
	
	@Autowired
	SubjectsDao subectsDao;

	@Autowired
	LocationDao locationDao;
	
	@Autowired
	CenterDao centerDao;
	
	@Override
	public DashboardCount dashboardCount() {
		DashboardCount count=new DashboardCount();
		count.setSubjects(subectsDao.countActive());
		count.setLocations(locationDao.countActive());
		count.setCenters(centerDao.countActive());
		return count;
	}

}
