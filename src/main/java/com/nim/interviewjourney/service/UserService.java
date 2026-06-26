package com.nim.interviewjourney.service;

import com.nim.interviewjourney.entity.UserEntity;
import com.nim.interviewjourney.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(
            String name,
            String email,
            String provider,
            String providerId) {

        return userRepository.findByEmail(email)
                .orElseGet(() -> {

                    UserEntity user = UserEntity.builder()
                            .name(name)
                            .email(email)
                            .provider(provider)
                            .providerId(providerId)
                            .build();

                    return userRepository.save(user);
                });
    }
}