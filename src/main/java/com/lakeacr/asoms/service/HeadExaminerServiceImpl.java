/**
 * 
 */
package com.lakeacr.asoms.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lakeacr.asoms.dao.CenterDao;
import com.lakeacr.asoms.dao.HeadExaminerDao;
import com.lakeacr.asoms.dao.LocationDao;
import com.lakeacr.asoms.domain.Centers;
import com.lakeacr.asoms.domain.HeadExaminer;
import com.lakeacr.asoms.domain.Locations;
import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.dto.ExportPdfDataDTO;
import com.lakeacr.asoms.utils.ExportExcelDataHadlerUtil;
import com.lakeacr.asoms.utils.ExportExcelUtils;

/**
 * @author SURAJ CHANDEL
 *
 */
@Service
public class HeadExaminerServiceImpl implements HeadExaminerService {

	private static final Logger LOG = LoggerFactory.getLogger(HeadExaminerServiceImpl.class);
	@Autowired
	HeadExaminerDao examinerDao;
	@Autowired
	CenterDao centerDao;

	@Autowired
	LocationDao locationDao;

	@Override
	public List<HeadExaminer> getHeadExaminer() {
		return examinerDao.findAll();
	}

	@Override
	public String saveOrUpdate(HeadExaminer examiner, User user) {
		examiner.setActive(true);
		examiner.setDeleted(false);
		if (examiner.getId() != null) {
			examiner.setUpdatedAt(new Date());
			examiner.setUpdatedBy(user.getUserId());
		} else {
			examiner.setCreatedAt(new Date());
			examiner.setCreatedBy(user.getUserId());
		}
		examinerDao.saveOrUpdate(examiner);
		return "Saved Succesfully";
	}

	@Override
	public HeadExaminer getHeadExaminer(Long id) {
		return examinerDao.findById(id);
	}

	@Override
	public void delete(Long id, User user) {
		HeadExaminer center = examinerDao.findById(id);
		center.setDeleted(true);
		center.setDeletedAt(new Date());
		center.setDeletedBy(user.getUserId());
		examinerDao.saveOrUpdate(center);

	}

	@Override
	public String uploadCsvFileData(MultipartFile file, Long userId) {
		String msg = "Save Successfully";
		try {
			List<HeadExaminer> headExaminer = new ArrayList<>();
			for (HeadExaminer examiner : readCenterFromCSV(file.getOriginalFilename(), userId)) {			
					headExaminer.add(examiner);
				
			}
			examinerDao.saveAll(headExaminer);
		} catch (Exception e) {
			LOG.error("Some server error in upload file : ", e);
			msg = "Some server error";
		}
		return msg;
	}

	private List<HeadExaminer> readCenterFromCSV(String fileName, Long userId) {
		List<HeadExaminer> list = new ArrayList<>();
		Path pathToFile = Paths.get("D:/upload/" + fileName);
		// create an instance of BufferedReader // using try with resource, Java 7
		// feature to close resources
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
					String[] attributes = line.split(",");
					HeadExaminer center = createObjects(attributes, userId);
					line = br.readLine();
					list.add(center);

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}

	private HeadExaminer createObjects(String[] metadata, Long userId) {
		String name = metadata[1];
		String designation = metadata[2];
		String emailId = metadata[3];
		String mobileNo = metadata[4];
		String schoolName = metadata[5];
		String locationId = metadata[6];
		String userName = metadata[7];
		String centerId = metadata[8];
		Locations locations = locationDao.findById(Long.parseLong(locationId));
		Centers centers = centerDao.findById(Long.parseLong(centerId));

		return new HeadExaminer(name, designation, mobileNo, emailId, schoolName, userName, new Date(), userId, true,
				false, locations, centers);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	public void export(HttpServletRequest request, HttpServletResponse response) {
		ExportPdfDataDTO dataDTO = new ExportPdfDataDTO();
		dataDTO.setFileName("head_examiner_list");
		dataDTO.setHeading("Head Examiner List");
		dataDTO.getTableHeading().add("Name");
		dataDTO.getTableHeading().add("Designation");
		dataDTO.getTableHeading().add("Phone No");
		dataDTO.getTableHeading().add("Email");
		dataDTO.getTableHeading().add("School Name");
		dataDTO.getTableHeading().add("Location Name");
		dataDTO.getTableHeading().add("User Name");
		dataDTO.getTableHeading().add("Center Code");
		List<HeadExaminer> headExaminer = examinerDao.findAll();
		for (HeadExaminer obj : headExaminer) {
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(obj.getName());
			arrayList.add(obj.getDesignation());
			arrayList.add(obj.getPhoneNo());
			arrayList.add(obj.getEmailId());
			arrayList.add(obj.getSchoolName());
			arrayList.add(obj.getLocations().getLocationName());
			arrayList.add(obj.getUserName());
			arrayList.add(obj.getCenters().getCenterCode());
			dataDTO.getData().add(arrayList);
		}
		ExportExcelUtils.downloadExcelFile(request, response,
				ExportExcelDataHadlerUtil.prepareExcelExportCommand(dataDTO));

	}
}
