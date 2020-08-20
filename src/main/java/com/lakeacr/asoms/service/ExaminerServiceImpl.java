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
import com.lakeacr.asoms.dao.ExaminerDao;
import com.lakeacr.asoms.dao.HeadExaminerDao;
import com.lakeacr.asoms.dao.SubjectsDao;
import com.lakeacr.asoms.domain.Centers;
import com.lakeacr.asoms.domain.Examiner;
import com.lakeacr.asoms.domain.HeadExaminer;
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
public class ExaminerServiceImpl implements ExaminerService {

	private static final Logger LOG = LoggerFactory.getLogger(ExaminerServiceImpl.class);
	@Autowired
	ExaminerDao examinerDao;
	@Autowired
	CenterDao centerDao;
	@Autowired
	SubjectsDao subjectsDao;
	@Autowired
	HeadExaminerDao headExaminerDao;

	@Override
	public List<Examiner> getExaminer() {
		return examinerDao.findAll();
	}

	@Override
	public String saveOrUpdate(Examiner examiner, User user) {
		examiner.setActive(true);
		examiner.setDeleted(false);
		if (examiner.getId() != null) {
			Examiner examiner2=examinerDao.findById(examiner.getId());
			examiner.setCreatedAt(examiner2.getCreatedAt());
			examiner.setCreatedBy(examiner2.getCreatedBy());
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
	public Examiner getExaminer(Long id) {
		return examinerDao.findById(id);
	}

	@Override
	public void delete(Long id, User user) {
		Examiner center = examinerDao.findById(id);
		center.setDeleted(true);
		center.setDeletedAt(new Date());
		center.setDeletedBy(user.getUserId());
		examinerDao.saveOrUpdate(center);

	}

	@Override
	public String uploadCsvFileData(MultipartFile file, Long userId) {
		String msg = "Save Successfully";
		try {
			List<Examiner> headExaminer = new ArrayList<>();
			for (Examiner examiner : readCenterFromCSV(file.getOriginalFilename(), userId)) {			
					headExaminer.add(examiner);
				
			}
			examinerDao.saveAll(headExaminer);
		} catch (Exception e) {
			LOG.error("Some server error in upload file : ", e);
			msg = "Some server error";
		}
		return msg;
	}

	private List<Examiner> readCenterFromCSV(String fileName, Long userId) {
		List<Examiner> list = new ArrayList<>();
		Path pathToFile = Paths.get("D:/upload/" + fileName);
		// create an instance of BufferedReader // using try with resource, Java 7
		// feature to close resources
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
					String[] attributes = line.split(",");
					Examiner center = createObjects(attributes, userId);
					line = br.readLine();
					list.add(center);

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}

	private Examiner createObjects(String[] metadata, Long userId) {
		String name = metadata[1];
		String designation = metadata[2];
		String emailId = metadata[3];
		String mobileNo = metadata[4];
		String schoolName = metadata[5];
		String headExaminerId = metadata[6];
		String userName = metadata[7];
		String centerId = metadata[8];
		String subjectId = metadata[9];
		Subjects subjects = subjectsDao.findById(Long.parseLong(subjectId));
		Centers centers = centerDao.findById(Long.parseLong(centerId));
		HeadExaminer headExaminer = headExaminerDao.findById(Long.parseLong(headExaminerId));

		return new Examiner(name, designation, mobileNo, emailId, schoolName, userName, new Date(), userId, true,
				false, headExaminer, centers, subjects);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	public void export(HttpServletRequest request, HttpServletResponse response) {
		ExportPdfDataDTO dataDTO = new ExportPdfDataDTO();
		dataDTO.setFileName("examiner_list");
		dataDTO.setHeading("Examiner List");
		dataDTO.getTableHeading().add("Name");
		dataDTO.getTableHeading().add("Designation");
		dataDTO.getTableHeading().add("Phone No");
		dataDTO.getTableHeading().add("Email");
		dataDTO.getTableHeading().add("School Name");
		dataDTO.getTableHeading().add("Head Examiner Name");
		dataDTO.getTableHeading().add("User Name");
		dataDTO.getTableHeading().add("Center Code");
		dataDTO.getTableHeading().add("Subject Code");
		List<Examiner> headExaminer = examinerDao.findAll();
		for (Examiner obj : headExaminer) {
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(obj.getName());
			arrayList.add(obj.getDesignation());
			arrayList.add(obj.getPhoneNo());
			arrayList.add(obj.getEmailId());
			arrayList.add(obj.getSchoolName());
			arrayList.add(obj.getHeadExaminer().getName());
			arrayList.add(obj.getUserName());
			arrayList.add(obj.getCenters().getCenterCode());
			arrayList.add(obj.getSubjects().getSubjectCode());
			dataDTO.getData().add(arrayList);
		}
		ExportExcelUtils.downloadExcelFile(request, response,
				ExportExcelDataHadlerUtil.prepareExcelExportCommand(dataDTO));

	}
}
