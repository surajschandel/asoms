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

import com.lakeacr.asoms.dao.MediumDao;
import com.lakeacr.asoms.domain.Medium;
import com.lakeacr.asoms.domain.User;
import com.lakeacr.asoms.dto.ExportPdfDataDTO;
import com.lakeacr.asoms.utils.ExportExcelDataHadlerUtil;
import com.lakeacr.asoms.utils.ExportExcelUtils;

/**
 * @author SURAJ CHANDEL
 *
 */
@Service
public class MediumServiceImpl implements MediumService {

	private static final Logger LOG = LoggerFactory.getLogger(MediumServiceImpl.class);
	@Autowired
	MediumDao mediumDao;

	@Override
	public List<Medium> getMedium() {
		// TODO Auto-generated method stub
		return mediumDao.findAll();
	}

	@Override
	public String saveOrUpdate(Medium medium, User user) {
		if (medium.getId() != null) {
			medium.setUpdatedAt(new Date());
			medium.setUpdatedBy(user.getUserId());
		} else {
			medium.setCreatedAt(new Date());
			medium.setCreatedBy(user.getUserId());
		}
		mediumDao.saveOrUpdate(medium);
		return "Saved Succesfully";
	}

	@Override
	public Medium getMedium(Long id) {
		return mediumDao.findById(id);
	}

	@Override
	public void delete(Long id, User user) {
		Medium location = mediumDao.findById(id);
		location.setDeleted(true);
		location.setDeletedAt(new Date());
		location.setDeletedBy(user.getUserId());
		mediumDao.saveOrUpdate(location);

	}

	@Override
	public String uploadCsvFileData(MultipartFile file, Long userId) {
		String msg = "Save Successfully";
		try {
			List<Medium> subjects = readMediumFromCSV(file.getOriginalFilename(), userId);
			mediumDao.saveAll(subjects);
		} catch (Exception e) {
			LOG.error("Some server error in upload file : ", e);
			msg = "Some server error";
		}
		return msg;
	}

	/**
	 * 
	 * @param fileName
	 * @param userId
	 * @return
	 */
	private static List<Medium> readMediumFromCSV(String fileName, Long userId) {
		List<Medium> list = new ArrayList<>();
		Path pathToFile = Paths.get("D:/upload/" + fileName);
		// create an instance of BufferedReader // using try with resource, Java 7
		// feature to close resources
		System.out.println("File=" + pathToFile.getFileName());
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] attributes = line.split(",");
				Medium location = createObjects(attributes, userId);
				line = br.readLine();
				list.add(location);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}

	private static Medium createObjects(String[] metadata, Long userId) {
		String location = metadata[1];
		String code = metadata[2];
		return new Medium(location, code, new Date(), userId, true, false);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	public void export(HttpServletRequest request, HttpServletResponse response) {
		ExportPdfDataDTO dataDTO = new ExportPdfDataDTO();
		dataDTO.setFileName("medium_list");
		dataDTO.setHeading("Medium List");
		dataDTO.getTableHeading().add("Medium Name");
		dataDTO.getTableHeading().add("Medium Code");
		List<Medium> locations = mediumDao.findAll();
		for (Medium obj : locations) {
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(obj.getMediumName());
			arrayList.add(obj.getMediumCode());
			dataDTO.getData().add(arrayList);
		}
		ExportExcelUtils.downloadExcelFile(request, response,
				ExportExcelDataHadlerUtil.prepareExcelExportCommand(dataDTO));

	}
}
