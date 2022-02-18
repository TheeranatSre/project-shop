package com.project.shop.projectshop.busibess.user;

import java.util.Optional;

import com.project.shop.projectshop.model.exception.ValidateException;
import com.project.shop.projectshop.model.user.UserEntity;
import com.project.shop.projectshop.model.user.node.UserNode;
import com.project.shop.projectshop.model.user.request.RegisterRequest;
import com.project.shop.projectshop.repository.user.UserNodeRepository;
import com.project.shop.projectshop.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterBusiness {

    private @Autowired UserRepository userRepository;
    private @Autowired UserNodeRepository userNodeRepository;

    public void validateEmailDuplicate(String email) throws ValidateException {
        Optional<UserEntity> user = userRepository.findOneByEmail(email);
        if (!user.isEmpty()) {
            throw new ValidateException("ที่อยู่ Email นี้ถูกใช้แล้ว กรุณากรอกที่อยู่ Email ใหม่");
        }
        if (email.equals("")) {
            throw new ValidateException("กรุณาระบุ email");
        }
    }

    public void validateNameDuplicate(String name) throws ValidateException {
        Optional<UserEntity> user = userRepository.findOneByName(name);
        if (!user.isEmpty()) {
            throw new ValidateException("User Name นี้ถูกใช้แล้ว กรุณากรอกที่อยู่ User Name ใหม่");
        }
        if (name.equals("")) {
            throw new ValidateException("กรุณาระบุ user name");
        }
    }

    public void validatepasswordIsNull(String password) throws ValidateException {
        if (password.equals("")) {
            throw new ValidateException("กรุณาระบุ password");
        }
    }

    public String saveRegister(RegisterRequest request) {
        UserEntity userRegister = new UserEntity();
        userRegister.setEmail(request.getEmail());
        userRegister.setName(request.getUserName());
        userRegister.setPassword(request.getPassword());
        userRegister.setRole("user");
        UserEntity userEntity = userRepository.save(userRegister);
        createNodeUser(userEntity);
        return"สมัครผู้ใช้สำเร็จ";
    }

    public void createNodeUser(UserEntity userEntity) {
        UserNode userNode = new UserNode();
        userNode.setId(userEntity.getId());
        userNode.setName(userEntity.getName());
        userNode.setEmail(userEntity.getEmail());
        userNode.setRole(userEntity.getRole());
        userNodeRepository.save(userNode);
    }
}
