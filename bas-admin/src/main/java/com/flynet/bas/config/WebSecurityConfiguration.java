/* <p>文件名称: WebSecurityConfiguration.java </p>
 * <p>文件描述: 无</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司: 沈阳唬哈科技有限公司</p>
 * <p>内容摘要: 无</p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2017年6月15日</p>
 * <p>完成日期：2017年6月15日</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期：下午4:26:17
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author	zhanghuafeng
 */
package com.flynet.bas.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author zhanghuafeng
 */
@Order(2)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;
    
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
//        auth.inMemoryAuthentication()
//            .withUser("bill").password("abc123").roles("ADMIN")
//            .and()
//            .withUser("bob").password("abc123").roles("USER");
          
//        auth.jdbcAuthentication()
//            .dataSource(dataSource)
//            .authoritiesByUsernameQuery("select login_name, 'ROLE_USER' from user where login_name = ?")
//            .usersByUsernameQuery("select login_name, password, true from user where login_name = ?");
    	
        auth.userDetailsService(userDetailsService);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.headers().frameOptions().disable();
    	
    	http.csrf().disable();
    	
        http.authorizeRequests()
            .antMatchers("/BMWTest_web/**").permitAll()
            .antMatchers("/mobile-api/**").permitAll()
            .antMatchers("/api/projects/**").permitAll()    
            .antMatchers("/api/users/**").permitAll() 
            .antMatchers("/api/vehicles/**").permitAll()             
            .antMatchers("/assets/**").permitAll()
            .antMatchers("/css/**").permitAll()
            .antMatchers("/images/**").permitAll()
            .antMatchers("/img/**").permitAll()
            .antMatchers("/documents/**").permitAll()
            .antMatchers("/**").hasAnyAuthority("ADMIN")            
            .anyRequest().authenticated()
            .and().formLogin()
                  .loginPage("/login")
                  .defaultSuccessUrl("/")
                  .permitAll()
            .and().logout()
                  .logoutUrl("/logout")
                  .logoutSuccessUrl("/login")
                  .permitAll();
        
    }
 
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
