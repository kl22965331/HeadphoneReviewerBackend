package com.example.demo.ServiceImpl;

import com.example.demo.DAO.RoleRepository;
import com.example.demo.DAO.UserRepository;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Exception.CustomException;
import com.example.demo.Service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    private  PasswordEncoder encoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(PasswordEncoder encoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User getUserByUserId(int id) {
        Optional<User> tempUser = userRepository.findById(id);
        if(!tempUser.isEmpty()){
            User user = tempUser.get();
            user.setPassword(null);
            return user;
        }else {
            return null;
        }
    }

    @Override
    public User getUserByUsername(String username) throws CustomException{
        return userRepository.findByUsername(username);
    }


    @Override
    @Transactional
    public void addUserWithUserRole(User user) {
        String password = user.getPassword();
        String encodedPasswor = encoder.encode(password);
        user.setPassword("{bcrypt}"+encodedPasswor);
            userRepository.save(user);
            roleRepository.save(new Role(user.getUsername(),"user"));


    }

    @Override
    @Transactional
    public void updatePasswordOrEmail(User user){
            Optional<User> optionalUser = userRepository.findById(user.getId());
            if(optionalUser.isPresent()){
                User targetUser=optionalUser.get();
                targetUser.setPassword("{bcrypt}"+encoder.encode(user.getPassword()));
                targetUser.setEmail(user.getEmail());
                userRepository.save(targetUser);
            }else {
                throw new CustomException("無效操作");
            }



    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteUserByUsername(String username) {
        userRepository.deleteUserByUsername(username);
    }

    @Override
    public boolean isUsernamePresent(String username) {
        //如果username相同就視為存在
        User user = new User();
            user.setUsername(username);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("username")
                .withIgnorePaths("id","password","createdAt")
                .withIgnoreNullValues();
        Example userExample = Example.of(user, matcher);
        return userRepository.exists(userExample);
    }

    @Override
    public boolean isUsernamePasswordPresent(String username, String password) {
        User storedUser = userRepository.findByUsername(username);
        String cryptedPassword = storedUser.getPassword();
        if(cryptedPassword.startsWith("{bcrypt}")){
            String substringtring = cryptedPassword.substring(8);
            cryptedPassword=substringtring;

        }
        return storedUser.getUsername().equals(username) && encoder.matches(password, cryptedPassword);
    }


}
