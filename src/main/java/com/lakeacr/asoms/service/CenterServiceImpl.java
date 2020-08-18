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
import com.lakeacr.asoms.domain.Centers;
import com.lakeacr.asoms.domain.Subjects;
import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.dto.ExportPdfDataDTO;
import com.lakeacr.asoms.utils.ExportExcelDataHadlerUtil;
import com.lakeacr.asoms.utils.ExportExcelUtils;

/**
 * @author SURAJ CHANDEL
 *
 */
@Service
public class CenterServiceImpl implements CenterService {

	private static final Logger LOG = LoggerFactory.getLogger(CenterServiceImpl.class);
	@Autowired
	CenterDao centerDao;

	@Override
	public List<Centers> getCenters() {
		return centerDao.findAll();
	}

	@Override
	public String saveOrUpdate(Centers center, User user) {
		if (center.getId() != null) {
			center.setUpdatedAt(new Date());
			center.setUpdatedBy(user.getUserId());
		} else {
			center.setCreatedAt(new Date());
			center.setCreatedBy(user.getUserId());
		}
		centerDao.saveOrUpdate(center);
		return "Saved Succesfully";
	}

	@Override
	public Centers getCenter(Long id) {
		return centerDao.findById(id);
	}

	@Override
	public void delete(Long id, User user) {
		Centers center = centerDao.findById(id);
		center.setDeleted(true);
		center.setDeletedAt(new Date());
		center.setDeletedBy(user.getUserId());
		centerDao.saveOrUpdate(center);

	}

	@Override
	public String uploadCsvFileData(MultipartFile file, Long userId) {
		String msg = "Save Successfully";
		try {
			List<Centers> centers = new ArrayList<>();
			for (Centers center : readCenterFromCSV(file.getOriginalFilename(), userId)) {
				if(!center.getCenterName().equalsIgnoreCase("Center Name")) {
					centers.add(center);
				}
			}
			centerDao.saveAll(centers);
		} catch (Exception e) {
			LOG.error("Some server error in upload file : ", e);
			msg = "Some server error";
		}
		return msg;
	}

	private static List<Centers> readCenterFromCSV(String fileName, Long userId) {
		List<Centers> list = new ArrayList<>();
		Path pathToFile = Paths.get("D:/upload/" + fileName);
		// create an instance of BufferedReader // using try with resource, Java 7
		// feature to close resources
		System.out.println("File=" + pathToFile.getFileName());
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			while (line != null) {
				String[] attributes = line.split(",");
					Centers center = createObjects(attributes, userId);
					line = br.readLine();
					list.add(center);
				
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}

	private static Centers createObjects(String[] metadata, Long userId) {
		String center = metadata[1];
		String code = metadata[2];
		String locationCode = metadata[3];
		String contactPerson = metadata[4];
		String address = metadata[5];
		String pinCode = metadata[6];
		String mobileNo = metadata[7];
		String emailId = metadata[8];
		return new Centers(center, code, locationCode, contactPerson, address, pinCode, mobileNo, emailId, new Date(),
				userId, true, false);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	public void export(HttpServletRequest request, HttpServletResponse response) {
		ExportPdfDataDTO dataDTO = new ExportPdfDataDTO();
		dataDTO.setFileName("center_list");
		dataDTO.setHeading("Scanning Center List");
		dataDTO.getTableHeading().add("Center Name");
		dataDTO.getTableHeading().add("Center Code");
		dataDTO.getTableHeading().add("Location Code");
		dataDTO.getTableHeading().add("Contact Person");
		dataDTO.getTableHeading().add("Address");
		dataDTO.getTableHeading().add("Pin Code");
		dataDTO.getTableHeading().add("Phone No");
		dataDTO.getTableHeading().add("Email");
		List<Centers> centers = centerDao.findAll();
		for (Centers obj : centers) {
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(obj.getCenterName());
			arrayList.add(obj.getCenterCode());
			arrayList.add(obj.getLocationCode());
			arrayList.add(obj.getContactPerson());
			arrayList.add(obj.getAddress());
			arrayList.add(obj.getPinCode());
			arrayList.add(obj.getPhoneNo());
			arrayList.add(obj.getEmailId());
			dataDTO.getData().add(arrayList);
		}
		ExportExcelUtils.downloadExcelFile(request, response,
				ExportExcelDataHadlerUtil.prepareExcelExportCommand(dataDTO));

	}
}
