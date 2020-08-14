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

import com.lakeacr.asoms.dao.LocationDao;
import com.lakeacr.asoms.domain.Locations;
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
public class LocationServiceImpl implements LocationService {

	private static final Logger LOG = LoggerFactory.getLogger(LocationServiceImpl.class);
	@Autowired
	LocationDao locationDao;

	@Override
	public List<Locations> getLocations() {
		// TODO Auto-generated method stub
		return locationDao.findAll();
	}

	@Override
	public String saveOrUpdateLocation(Locations location, User user) {
		if (location.getId() != null) {
			location.setUpdatedAt(new Date());
			location.setUpdatedBy(user.getUserId());
		} else {
			location.setCreatedAt(new Date());
			location.setCreatedBy(user.getUserId());
		}
		locationDao.saveOrUpdate(location);
		return "Saved Succesfully";
	}

	@Override
	public Locations getLocation(Long id) {
		return locationDao.findById(id);
	}

	@Override
	public void deleteLocation(Long id, User user) {
		Locations location = locationDao.findById(id);
		location.setDeleted(true);
		location.setDeletedAt(new Date());
		location.setDeletedBy(user.getUserId());
		locationDao.saveOrUpdate(location);

	}

	@Override
	public String uploadCsvFileData(MultipartFile file, Long userId) {
		String msg = "Save Successfully";
		try {
			List<Locations> subjects = readLocationFromCSV(file.getOriginalFilename(), userId);
			locationDao.saveAll(subjects);
		} catch (Exception e) {
			LOG.error("Some server error in upload file : ", e);
			msg = "Some server error";
		}
		return msg;
	}

	private static List<Locations> readLocationFromCSV(String fileName, Long userId) {
		List<Locations> list = new ArrayList<>();
		Path pathToFile = Paths.get("D:/upload/" + fileName);
		// create an instance of BufferedReader // using try with resource, Java 7
		// feature to close resources
		System.out.println("File=" + pathToFile.getFileName());
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			while (line != null) {
				String[] attributes = line.split(",");
				Locations location = createObjects(attributes, userId);
				line = br.readLine();
				list.add(location);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}

	private static Locations createObjects(String[] metadata, Long userId) {
		String location = metadata[1];
		String code = metadata[2];
		return new Locations(location, code, new Date(), userId, true, false);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	public void export(HttpServletRequest request, HttpServletResponse response) {
		ExportPdfDataDTO dataDTO = new ExportPdfDataDTO();
		dataDTO.setFileName("location_list");
		dataDTO.setHeading("Scanning Location List");
		dataDTO.getTableHeading().add("Location Name");
		dataDTO.getTableHeading().add("Location Code");
		List<Locations> locations = locationDao.findAll();
		for (Locations obj : locations) {
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(obj.getLocationName());
			arrayList.add(obj.getLocationCode());
			dataDTO.getData().add(arrayList);
		}
		ExportExcelUtils.downloadExcelFile(request, response,
				ExportExcelDataHadlerUtil.prepareExcelExportCommand(dataDTO));

	}
}
