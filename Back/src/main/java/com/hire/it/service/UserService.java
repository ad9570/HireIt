package com.hire.it.service;

import java.util.Collections;
import com.hire.it.dto.UserDto;
import com.hire.it.entity.Authority;
import com.hire.it.entity.User;
import com.hire.it.exception.DuplicateMemberException;
import com.hire.it.repository.UserRepository;
import com.hire.it.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserDto signup(UserDto userDto) {
    	//이미 가입되어 있는 username인지 확인
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        //이미 가입되어 있는 username이 아니라면
        //권한정보 생성
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        //User정보 생성
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .name(userDto.getName())
                .role("1")
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        //DB에 정보 저장
        return UserDto.from(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public UserDto getUserWithAuthorities(String username) { //파라미터로 받은 username을 기준으로 유저, 권한정보를 가져옴
        return UserDto.from(userRepository.findOneWithAuthoritiesByUsername(username).orElse(null));
    }

    @Transactional(readOnly = true)
    public UserDto getMyUserWithAuthorities() { //현재 SecurityContext에 저장된 username에 한해 유저, 권한정보를 가져옴
        return UserDto.from(SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername).orElse(null));
    }
}
