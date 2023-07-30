package com.cxx.server.service.serviceImpl;

import com.cxx.server.Entity.UserInfo;
import com.cxx.server.dto.*;
import com.cxx.server.service.CommonCRUDService;
import com.cxx.server.vo.UserInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cxx.server.dao.UserInfoDAO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserInfoServiceImpl implements CommonCRUDService<UserInfoDTO, UserInfoVO> {
    @Autowired
    private UserInfoDAO userInfoDAO;


    @Override
    public ResponseDTO<UserInfoVO> create(UserInfoDTO userInfoDTO) {
        if (userInfoDTO.getId() != null) return new ErrorResponse<>("Id should be null");
        if (userInfoDTO.getUserName() == null || userInfoDTO.getUserName().isEmpty()) return new ErrorResponse<>("User name should not be null");
        if (userInfoDTO.getPassWord() == null || userInfoDTO.getPassWord().isEmpty()) return new ErrorResponse<>("Password should not be null");
        if (userInfoDTO.getNickName() == null) userInfoDTO.setNickName(userInfoDTO.getUserName());
        if (userInfoDAO.existsByUserName(userInfoDTO.getUserName())) return new ErrorResponse<>("User name already exists");

        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDTO, userInfo);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(userInfoDAO.save(userInfo), userInfoVO);
        return new SuccessResponse<>(userInfoVO);
    }

    @Override
    public ResponseDTO<UserInfoVO> update(UserInfoDTO userInfoDTO) {
        if (userInfoDTO.getId() == null) return new ErrorResponse<>("Id should not be null");
        if (userInfoDTO.getUserName() == null || userInfoDTO.getUserName().isEmpty()) return new ErrorResponse<>("User name should not be null");
        if (userInfoDTO.getPassWord() == null || userInfoDTO.getPassWord().isEmpty()) return new ErrorResponse<>("Password should not be null");
        if (userInfoDTO.getNickName() == null) userInfoDTO.setNickName(userInfoDTO.getUserName());
        if (!userInfoDAO.existsById(userInfoDTO.getId())) return new ErrorResponse<>("User is not exist");
        if (userInfoDTO.getUserName() != null) return new ErrorResponse<>("User name should not be changed");

        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoDTO, userInfo);
        userInfo.setUserName(userInfoDAO.findById(userInfoDTO.getId()).get().getUserName());
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(userInfoDAO.save(userInfo), userInfoVO);
        return new SuccessResponse<>(userInfoVO);
    }

    @Override
    public void delete(Long id) {
        userInfoDAO.deleteById(id);
    }

    @Override
    public ResponseDTO<UserInfoVO> get(Long id) {
        Optional<UserInfo> byId = userInfoDAO.findById(id);
        if (byId.isPresent()) {
            UserInfoVO userInfoVO = new UserInfoVO();
            BeanUtils.copyProperties(byId.get(), userInfoVO);
            return new SuccessResponse<>(userInfoVO);
        } else {
            return new FailedResponse<>("User not found");
        }
    }

    public ResponseDTO<List<UserInfoVO>> getAll() {
        List<UserInfo> all = userInfoDAO.findAll();
        Stream<UserInfoVO> userInfoVOStream = all.stream().map(userInfo -> {
            UserInfoVO userInfoVO = new UserInfoVO();
            BeanUtils.copyProperties(userInfo, userInfoVO);
            return userInfoVO;
        });
        return new SuccessResponse<>(userInfoVOStream.toList());
    }
}
