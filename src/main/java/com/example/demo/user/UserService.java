package com.example.demo.user;

import com.example.demo.banque.Banque;
import com.example.demo.banque.BanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BanqueRepository banqueRepository;

    @Autowired
    public UserService(UserRepository userRepository, BanqueRepository banqueRepository) {
        this.userRepository = userRepository;
        this.banqueRepository = banqueRepository;
    }

    public List<User> getUsers(){
        return userRepository.findByDeleteMarkIsFalse();
    }

    public User newUser(User user){
        Optional<Banque> banqueOpt = banqueRepository.findById(user.getBanque().getId());
        if(banqueOpt.isEmpty()){
            throw new RuntimeException("banque not found");
        }
        Banque banque = banqueOpt.get();
        user.setBanque(banque);

        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        if(!userRepository.existsById(userId)){
            throw new IllegalStateException("user doesn't exists");
        }
        userRepository.deleteById(userId);
    }

    public Optional<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }

    public void updateUser(Long userId, User user) {
        user.setUserId(userId);
        userRepository.save(user);
    }

    public List<Long> getMontant(){
        return userRepository.findAllByDeleteMarkIsFalse().stream().map(UserProjection::getMontant).collect(Collectors.toList());
    }

    public List<User> getUsersDelete() {
        return userRepository.findByDeleteMarkIsTrue();
    }

    public void softDelete(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
        user.setDeleteMark(true);
        userRepository.save(user);
    }

    public void restoreUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
        user.setDeleteMark(false);
        userRepository.save(user);
    }
}
