package com.accp.zjq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.ProjectMapper;
import com.accp.domain.Project;
import com.accp.domain.ProjectByTimeAndName;
import com.accp.domain.QuestionTj;

@Service
public class ProjectService {

	@Autowired
	ProjectMapper pm;
	
	public List<Project> queryAllProject(){
		return pm.selectByExample(null);
	}
	
	public List<ProjectByTimeAndName> superSelectProject(String years){
		
		return pm.superSelectBytime(years);
	}
	
	public List<QuestionTj> selectByQuestion(String projectname){
		return pm.selectByQuestionTj(projectname);
	}
}
