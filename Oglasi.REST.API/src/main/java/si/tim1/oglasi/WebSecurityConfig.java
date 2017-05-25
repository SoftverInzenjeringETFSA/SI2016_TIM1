package si.tim1.oglasi;

/**
 * Created by Adnan on 5/5/2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import si.tim1.oglasi.filters.JWTAuthenticationFilter;
import si.tim1.oglasi.filters.JWTLoginFilter;
import si.tim1.oglasi.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/advert").permitAll()
                .antMatchers(HttpMethod.GET, "/advert/all").permitAll()
                .antMatchers("/advert/category").permitAll()
                .antMatchers("/advert/owner/{ownerId}").permitAll()
                .antMatchers("/advert/with_report").permitAll()
                .antMatchers("/advert/details/{advertId}").permitAll()
                .antMatchers("/advert/create").permitAll()
                .antMatchers("/advert/update").permitAll()
                .antMatchers("/advert/delete/{advertId}").permitAll()
                .antMatchers("/advert/subscribe/{id}").permitAll()
                .antMatchers("/account/register").permitAll()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers(HttpMethod.POST, "/advert/subscribe").permitAll()
                .antMatchers(HttpMethod.POST, "/advert/report").permitAll()
                .antMatchers(HttpMethod.POST, "/category/create").permitAll()
                .antMatchers(HttpMethod.GET, "/category/all").permitAll()
                .anyRequest().authenticated()
                .and()
                // We filter the api/login requests
                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);


    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}
