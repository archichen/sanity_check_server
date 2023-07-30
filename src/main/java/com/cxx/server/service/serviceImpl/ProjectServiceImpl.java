package com.cxx.server.service.serviceImpl;

import com.cxx.server.Entity.Project;
import com.cxx.server.Entity.UserInfo;
import com.cxx.server.dao.ProjectDAO;
import com.cxx.server.dao.UserInfoDAO;
import com.cxx.server.dto.*;
import com.cxx.server.service.CommonCRUDService;
import com.cxx.server.vo.ProjectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProjectServiceImpl implements CommonCRUDService<ProjectDTO, ProjectVO> {
    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public ResponseDTO<ProjectVO> create(ProjectDTO projectDTO) {
        if (projectDTO.getProjectId() != null) return new ErrorResponse<>("Id should be null");
        if (projectDAO.existsByUserIdAndProjectName(projectDTO.getUserId(), projectDTO.getProjectName()))
            return new ErrorResponse<>("Project name is already exist");

        Project project = new Project();
        BeanUtils.copyProperties(projectDTO, project);
        Project saved = projectDAO.save(project);
        ProjectVO projectVO = new ProjectVO();
        BeanUtils.copyProperties(saved, projectVO);
        return new SuccessResponse<>(projectVO);
    }

    @Override
    public ResponseDTO<ProjectVO> update(ProjectDTO projectDTO) {
        if (projectDTO.getProjectId() == null) return new ErrorResponse<>("Id should not be null");
        if (!projectDAO.existsById(projectDTO.getProjectId())) return new ErrorResponse<>("Project is not exist");
        if (projectDAO.existsByUserIdAndProjectName(projectDTO.getUserId(), projectDTO.getProjectName()))
            return new ErrorResponse<>("Project name is already exist");

        Project project = new Project();
        BeanUtils.copyProperties(projectDTO, project);
        Project saved = projectDAO.save(project);
        ProjectVO projectVO = new ProjectVO();
        BeanUtils.copyProperties(saved, projectVO);
        return new SuccessResponse<>(projectVO);
    }

    @Override
    public void delete(Long id) {
        projectDAO.deleteById(id);
    }

    @Override
    public ResponseDTO<ProjectVO> get(Long id) {
        Optional<Project> projectOptional = projectDAO.findById(id);
        if (projectOptional.isPresent()) {
            ProjectVO projectVO = new ProjectVO();
            BeanUtils.copyProperties(projectOptional.get(), projectVO);
            return new SuccessResponse<>(projectVO);
        } else {
            return new FailedResponse<>("Project not found");
        }
    }

    public ResponseDTO<List<ProjectVO>> getAll(Long userId) {
        List<Project> projects = projectDAO.findAllByUserId(userId);
        List<ProjectVO> projectVOS = projects.stream().map(project -> {
            ProjectVO projectVO = new ProjectVO();
            BeanUtils.copyProperties(project, projectVO);
            return projectVO;
        }).toList();
        return new SuccessResponse<>(projectVOS);
    }
}
