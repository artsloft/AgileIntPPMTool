package com.elastitrader.ppmtool.services;

import com.elastitrader.ppmtool.domain.Project;
import com.elastitrader.ppmtool.exceptions.ProjectIdException;
import com.elastitrader.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.color.ProfileDataException;

@Service
public class ProjectService
{
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException(String.format("Project Id: %s exists", project.getProjectIdentifier().toUpperCase()));
        }
    }

    public Project findByProjectIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw  new ProjectIdException(String.format("Project ID: %s doesn't exist.", projectId));
        }

        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }
}
