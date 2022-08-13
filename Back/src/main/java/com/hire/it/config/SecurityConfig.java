package com.hire.it.config;

import com.hire.it.jwt.JwtSecurityConfig;
import com.hire.it.jwt.JwtAccessDeniedHandler;
import com.hire.it.jwt.JwtAuthenticationEntryPoint;
import com.hire.it.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final TokenProvider tokenProvider;
    private final CorsFilter corsFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(
            TokenProvider tokenProvider,
            CorsFilter corsFilter,
            JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
            JwtAccessDeniedHandler jwtAccessDeniedHandler
    ) {
        this.tokenProvider = tokenProvider;
        this.corsFilter = corsFilter;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable() //토큰을 사용하기 때문에 csrf 설정은 disable

                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)

                .exceptionHandling() //예외 핸들링
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //세션은 사용하지 않기 때문에 STATELESS

                .and()
                .authorizeRequests() //httpServletRequest를 사용하는 요청들에 대한 접근제한 설정
                .antMatchers("/api/idcheck").permitAll() //'/api/idcheck'에 대한 요청은 인증 없이 접근 허용
                .antMatchers("/api/authenticate").permitAll() //로그인 api - 토큰이 없는 상태에서 들어오는 요청
                .antMatchers("/api/signup").permitAll() //회원가입 api - 토큰이 없는 상태에서 들어오는 요청
                .antMatchers("/resume/**").permitAll()
                .antMatchers("/jobposting/**").permitAll()
                .antMatchers("/corpManagement/**").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers("/board/**").permitAll()
                .antMatchers("/save/**").permitAll()
                .antMatchers("/image/**").permitAll()
                .antMatchers("/static/image/**").permitAll()
                
                .anyRequest().authenticated() //나머지 요청은 모두 인증 필요

                .and()
                .apply(new JwtSecurityConfig(tokenProvider)); //addFilterBefore
    }
    
}
