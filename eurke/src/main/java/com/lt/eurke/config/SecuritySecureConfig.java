//package com.lt.eurke.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @author tong.luo
// * @description SecuritySecureConfig
// * @date 2020/3/29 0:35
// */
//@Configuration
//public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
//    private final AdminServerProperties adminServer;
//
//
//
//    /**
//
//     * Instantiates a new Security secure config.
//
//     *
//
//     * @param adminServer the admin server
//
//     */
//
//    public SecuritySecureConfig(AdminServerProperties adminServer) {
//
//        this.adminServer = adminServer;
//
//    }
//
//
//
//    @Override
//
//    protected void configure(HttpSecurity http) throws Exception {
//
//        // @formatter:off
//
//        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
//
//        successHandler.setTargetUrlParameter("redirectTo");
//
//        final String adminServerContextPath = this.adminServer.getContextPath();
//
//        successHandler.setDefaultTargetUrl(adminServerContextPath+"/");
//
//
//
//        http.authorizeRequests()
//
//                .antMatchers(adminServerContextPath + "/assets/**").permitAll() // <1>
//
//                .antMatchers(adminServerContextPath + "/login").permitAll()
//
//                .anyRequest().authenticated() // <2>
//
//                .and()
//
//                .formLogin().loginPage(adminServerContextPath + "/login").successHandler(successHandler).and() // <3>
//
//                .logout().logoutUrl(adminServerContextPath + "/logout").and()
//
//                .httpBasic().and() // <4>
//
//                .csrf()
//
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // <5>
//
//                .ignoringRequestMatchers(
//
//                        new AntPathRequestMatcher(adminServerContextPath + "/instances", HttpMethod.POST.toString()),  // <6>
//
//                        new AntPathRequestMatcher(adminServerContextPath + "/instances/*", HttpMethod.DELETE.toString()),  // <6>
//
//                        new AntPathRequestMatcher(adminServerContextPath + "/actuator/**")  // <7>
//
//                )
//
//                .and()
//
//                .rememberMe().key(UUID.randomUUID().toString()).tokenValiditySeconds(1209600);
//
//
//
//    }
//
//}
//}
