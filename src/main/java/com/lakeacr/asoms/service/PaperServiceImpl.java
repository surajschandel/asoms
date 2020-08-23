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
import com.lakeacr.asoms.dao.PaperDao;
import com.lakeacr.asoms.dao.SubjectsDao;
import com.lakeacr.asoms.domain.Medium;
import com.lakeacr.asoms.domain.Paper;
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
public class PaperServiceImpl implements PaperService {

	private static final Logger LOG = LoggerFactory.getLogger(PaperServiceImpl.class);
	@Autowired
	SubjectsDao subjectsDao;
	@Autowired
	MediumDao mediumDao;
	
	@Autowired
	PaperDao paperDao;

	@Override
	public List<Paper> getPapers() {
		return paperDao.findAll();
	}

	@Override
	public String saveOrUpdate(Paper center, User user) {
		if (center.getId() != null) {
			center.setUpdatedAt(new Date());
			center.setUpdatedBy(user.getUserId());
		} else {
			center.setCreatedAt(new Date());
			center.setCreatedBy(user.getUserId());
		}
		paperDao.saveOrUpdate(center);
		return "Saved Succesfully";
	}

	@Override
	public Paper getPaper(Long id) {
		return paperDao.findById(id);
	}

	@Override
	public void delete(Long id, User user) {
		Paper center = paperDao.findById(id);
		center.setDeleted(true);
		center.setDeletedAt(new Date());
		center.setDeletedBy(user.getUserId());
		paperDao.saveOrUpdate(center);

	}

	@Override
	public String uploadCsvFileData(MultipartFile file, Long userId) {
		String msg = "Save Successfully";
		try {
			List<Paper> papers = new ArrayList<>();
			for (Paper paper : readCenterFromCSV(file.getOriginalFilename(), userId)) {
					papers.add(paper);
			}
			paperDao.saveAll(papers);
		} catch (Exception e) {
			LOG.error("Some server error in upload file : ", e);
			msg = "Some server error";
		}
		return msg;
	}

	private List<Paper> readCenterFromCSV(String fileName, Long userId) {
		List<Paper> list = new ArrayList<>();
		Path pathToFile = Paths.get("D:/upload/" + fileName);
		// create an instance of BufferedReader // using try with resource, Java 7
		// feature to close resources
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] attributes = line.split(",");
					Paper paper = createObjects(attributes, userId);
					line = br.readLine();
					list.add(paper);
				
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}

	private Paper createObjects(String[] metadata, Long userId) {
		String name = metadata[1];
		String paperCode = metadata[2];
		String regionCode = metadata[3];
		String subjectId = metadata[4];
		String mediumId = metadata[5];
		String mainAnsScriptPage = metadata[6];
		String supliAnsScriptPage = metadata[7];
		String modelQuesPaper = metadata[8];
		String modelAnswer = metadata[9];
		double totalMark = Double.parseDouble(metadata[10]);
		double optionalQueMark = Double.parseDouble(metadata[11]);
		double passingMark = Double.parseDouble(metadata[12]);
		String markingScheme = metadata[13];
		Subjects subjects=subjectsDao.findById(Long.parseLong(subjectId));
		Medium medium=mediumDao.findById(Long.parseLong(mediumId));
		return new Paper(name, paperCode, regionCode, mainAnsScriptPage, supliAnsScriptPage, modelQuesPaper, modelAnswer, totalMark, optionalQueMark,passingMark, markingScheme, new Date(),
				userId, true, false,subjects, medium);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	@Override
	public void export(HttpServletRequest request, HttpServletResponse response) {
		ExportPdfDataDTO dataDTO = new ExportPdfDataDTO();
		dataDTO.setFileName("paper_list");
		dataDTO.setHeading("Paper List");
		dataDTO.getTableHeading().add("Name");  
		dataDTO.getTableHeading().add("Paper Code");
		dataDTO.getTableHeading().add("Region Code");
		dataDTO.getTableHeading().add("Subject Code");
		dataDTO.getTableHeading().add("Medium");
		dataDTO.getTableHeading().add("Main Ans Script Page");
		dataDTO.getTableHeading().add("Suppl. Ans Script Page");
		dataDTO.getTableHeading().add("Model Question Paper");
		dataDTO.getTableHeading().add("Model Answer");
		dataDTO.getTableHeading().add("Total Mark");
		dataDTO.getTableHeading().add("Optional Question Mark");
		dataDTO.getTableHeading().add("Passing Mark");
		dataDTO.getTableHeading().add("Marking Scheme");
		List<Paper> papers = paperDao.findAll();
		for (Paper obj : papers) {
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(obj.getName());
			arrayList.add(obj.getPaperCode());
			arrayList.add(obj.getRegionCode());
			arrayList.add(obj.getSubjects().getSubjectCode());
			arrayList.add(obj.getMedium().getMediumName());
			arrayList.add(obj.getMainAnsScriptPage());
			arrayList.add(obj.getSupplAnsScriptPage());
			arrayList.add(obj.getModelQuestionPaper());
			arrayList.add(obj.getModelAnswer());
			arrayList.add(obj.getTotalMarks());
			arrayList.add(obj.getOptionalQuestionMarks());
			arrayList.add(obj.getPassingMarks());
			arrayList.add(obj.getMarkingScheme());
			dataDTO.getData().add(arrayList);
		}
		ExportExcelUtils.downloadExcelFile(request, response,
				ExportExcelDataHadlerUtil.prepareExcelExportCommand(dataDTO));

	}
}
