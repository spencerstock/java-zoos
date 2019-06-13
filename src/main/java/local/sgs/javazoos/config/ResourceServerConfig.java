package local.sgs.javazoos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
    //this class tells Security who has access to what
{

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
    {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        // http.anonymous().disable();
        http.authorizeRequests() //various endpoints
            .antMatchers("/",                       // required for h2
                                   "/h2-console/**",          // required for h2
                                   "/v2/api-docs",            // required for swagger
                                   "/swagger-resources",      // required for swagger
                                   "/swagger-resources/**",   // required for swagger
                                   "/configuration/ui",       // required for swagger
                                   "/configuration/security", // required for swagger
                                   "/swagger-ui.html",        // required for swagger
                                   "/webjars/**"              // required for swagger
                        ).permitAll()
                .antMatchers("/users/**").authenticated() //anyone with a token
                .antMatchers("/roles", "/actuator/**").hasAnyRole("ADMIN", "MANAGER") //can add roles before they're in DB
            .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());

        // http.requiresChannel().anyRequest().requiresSecure();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
