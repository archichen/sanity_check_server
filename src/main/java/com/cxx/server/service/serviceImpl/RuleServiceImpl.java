package com.cxx.server.service.serviceImpl;

import com.cxx.server.Entity.Rule;
import com.cxx.server.dao.ProjectDAO;
import com.cxx.server.dao.RuleDAO;
import com.cxx.server.dao.UserInfoDAO;
import com.cxx.server.dto.FailedResponse;
import com.cxx.server.dto.ResponseDTO;
import com.cxx.server.dto.RuleDTO;
import com.cxx.server.dto.SuccessResponse;
import com.cxx.server.vo.RuleVO;
import com.cxx.server.service.CommonCRUDService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class RuleServiceImpl implements CommonCRUDService<RuleDTO, RuleVO> {

    @Autowired
    private RuleDAO ruleDAO;

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public ResponseDTO<RuleVO> create(RuleDTO ruleDTO) {
        if (ruleDTO.getId() != null) return new FailedResponse<>("Id should be null");
        if (!projectDAO.existsById(ruleDTO.getProjectId())) return new FailedResponse<>("Project is not exist");
        if (!userInfoDAO.existsById(ruleDTO.getUserId())) return new FailedResponse<>("User is not exist");

        Rule rule = new Rule();
        BeanUtils.copyProperties(ruleDTO, rule);
        RuleVO ruleVO = new RuleVO();
        BeanUtils.copyProperties(ruleDAO.save(rule), ruleVO);
        return new SuccessResponse<>(ruleVO);
    }

    @Override
    public ResponseDTO<RuleVO> update(RuleDTO ruleDTO) {
        if (!ruleDAO.existsById(ruleDTO.getId())) return new FailedResponse<>("Rule is not exist");
        if (ruleDTO.getProjectId() == null) return new FailedResponse<>("Id should not be null");
        if (!projectDAO.existsById(ruleDTO.getProjectId())) return new FailedResponse<>("Project is not exist");
        if (!userInfoDAO.existsById(ruleDTO.getUserId())) return new FailedResponse<>("User is not exist");

        Rule rule = new Rule();
        BeanUtils.copyProperties(ruleDTO, rule);
        RuleVO ruleVO = new RuleVO();
        BeanUtils.copyProperties(ruleDAO.save(rule), ruleVO);
        return new SuccessResponse<>(ruleVO);    }

    @Override
    public void delete(Long id) {
        ruleDAO.deleteById(id);
    }

    @Override
    public ResponseDTO<RuleVO> get(Long id) {
        Optional<Rule> byId = ruleDAO.findById(id);
        if (byId.isPresent()) {
            RuleVO ruleVO = new RuleVO();
            BeanUtils.copyProperties(byId.get(), ruleVO);
            return new SuccessResponse<>(ruleVO);
        } else {
            return new FailedResponse<>("Rule not found");
        }
    }

    public ResponseDTO<List<RuleVO>> getAll(Long userId, Long projectId) {
        if (!projectDAO.existsById(projectId)) return new FailedResponse<>("Project is not exist");
        if (!userInfoDAO.existsById(userId)) return new FailedResponse<>("User is not exist");

        List<Rule> allByUserIdAndProjectId = ruleDAO.findAllByUserIdAndProjectId(userId, projectId);
        Stream<RuleVO> ruleVOStream = allByUserIdAndProjectId.stream().map(rule -> {
            RuleVO ruleVO = new RuleVO();
            BeanUtils.copyProperties(rule, ruleVO);
            return ruleVO;
        });
        return new SuccessResponse<>(ruleVOStream.toList());
    }
}
