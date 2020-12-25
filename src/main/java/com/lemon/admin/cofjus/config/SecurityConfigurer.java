package com.lemon.admin.cofjus.config;

import com.lemon.admin.cofjus.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring security全局安全入口.
 *  使用 Ji Rui定义的 CustomUserDetailsService
 *  将密码设置为spring security自带的加密方式而非 md5
 *
 * @author nlby
 * @date 2020/7/5
 */
@Configuration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

//  @Autowired
//  PasswordEncoder passwordEncoder;
  @Autowired
  CustomUserDetailsService userDetailsService;


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    // 加入自定义的安全认证
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    //解决静态资源被拦截的问题
    web.ignoring().antMatchers("/css/**","/js/**","/images/**","/fonts/**","/favicon.ico");
  }
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/authentication/form")//登录请求url-form表单的action
        .defaultSuccessUrl("/",true)
        .failureForwardUrl("/login.html?error")
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/logout")
        .and()
        .csrf()
        .disable()

            .headers()
            .frameOptions().sameOrigin()
            .httpStrictTransportSecurity().disable();;
  }

  @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
