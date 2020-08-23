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

import com.lakeacr.asoms.dao.SubjectsDao;
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
public class SubjectsServiceImpl implements SubjectsService {


	private static final Logger LOG = LoggerFactory.getLogger(SubjectsServiceImpl.class);
	@Autowired
	SubjectsDao subjectsDao;

	@Override
	public List<Subjects> getSubjects() {
		// TODO Auto-generated method stub
		return subjectsDao.findAll();
	}

	@Override
	public String saveOrUpdateSubject(Subjects subject,User user) {
		if(subject.getId()!=null) {
			subject.setUpdatedAt(new Date());
			subject.setUpdatedBy(user.getUserId());
		}else {
			subject.setCreatedAt(new Date());
			subject.setCreatedBy(user.getUserId());			
		}
		subjectsDao.saveOrUpdate(subject);
		return "Saved Succesfully";
	}

	@Override
	public Subjects getSubject(Long id) {
		return subjectsDao.findById(id);
	}

	@Override
	public void deleteSubject(Long id, User user) {
		Subjects subjects=subjectsDao.findById(id);
		subjects.setDeleted(true);
		subjects.setDeletedAt(new Date());
		subjects.setDeletedBy(user.getUserId());
		subjectsDao.saveOrUpdate(subjects);

	}

	@Override
	public String uploadCsvFileData(MultipartFile file, Long userId) {
		String msg="Save Successfully";
		try {
			List<Subjects> subjects= readSubjectssFromCSV(file.getOriginalFilename(),userId);
			subjectsDao.saveAll(subjects);
		} catch (Exception e) {
			LOG.error("Some server error in upload file : ",e);	
			msg="Some server error";
		}
		return msg;
	}

	private static List<Subjects> readSubjectssFromCSV(String fileName, Long userId) {
		List<Subjects> books = new ArrayList<>();
		Path pathToFile = Paths.get("D:/upload/"+fileName);
		// create an instance of BufferedReader // using try with resource, Java 7
		// feature to close resources
		System.out.println("File="+pathToFile.getFileName());
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] attributes = line.split(",");
				Subjects subject = createSubjects(attributes, userId);
				line = br.readLine();
				books.add(subject);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return books;
	}

	private static Subjects createSubjects(String[] metadata, Long userId) {
		String subject = metadata[1];
		String code = metadata[2];
		return new Subjects(subject, code, new Date(),userId,true,false);
	}

	@Override
	public void export(HttpServletRequest request, HttpServletResponse response) {
		ExportPdfDataDTO dataDTO = new ExportPdfDataDTO();
		dataDTO.setFileName("subject_list");
        dataDTO.setHeading("Subject List");
        dataDTO.getTableHeading().add("Subject Name");
        dataDTO.getTableHeading().add("Subject Code");
		List<Subjects> subjects=subjectsDao.findAll();
		for (Subjects subject : subjects) {
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(subject.getSubjectName());
            arrayList.add(subject.getSubjectCode());
            dataDTO.getData().add(arrayList);
		}
		ExportExcelUtils.downloadExcelFile(request, response, ExportExcelDataHadlerUtil.prepareExcelExportCommand(dataDTO));
		
	}

}
