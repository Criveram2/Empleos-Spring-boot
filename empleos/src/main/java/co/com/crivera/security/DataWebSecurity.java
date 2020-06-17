/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/08
 * @since 0.0.1 2020/06/08
 */

package co.com.crivera.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase con configuracion de seguridad web
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/08
 * @since 0.0.1 2020/06/08
 */
@Configuration
@EnableWebSecurity
public class DataWebSecurity extends WebSecurityConfigurerAdapter
{
    @Autowired
    private DataSource dataSource;
    
    /*
     * (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/10
     * @since 0.0.1 2020/06/10
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select usuario, password, estado from Usuarios where usuario=?")
        .authoritiesByUsernameQuery("  select u.usuario, p.nombre from Usuario_Perfil up "
                + "inner join Usuarios u on u.usuario_id= up.usuario_id "
                + "inner join Perfiles p on p.perfil_id = up.perfil_id "
                + "where u.usuario=?");
    }
    
    /*
     * (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/10
     * @since 0.0.1 2020/06/10
     * Define los permisos de los roles para visualizar segmentos del proyecto "URLS"
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception{
    
        http.authorizeRequests()
        //los recursos estaticos no requieren autenticacion
        .antMatchers("/bootstrap/**",
                     "/images/**",
                     "/tinymce/**",
                     "/logos/**" )
        //las vistas publicas no requieren autorizacion
        .permitAll().antMatchers("/",
                    "/signup","/search",
                    "/vacantes/view/**").permitAll()
        //Asignar permisis a URLs por ROLES
        .antMatchers("/vacantes/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
        .antMatchers("/categorias/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
        .antMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")
        //Todas las demas urls requieren autenticacion
        .anyRequest().authenticated()
        //El formulario de login no requiere Autorizacion
        .and().formLogin().loginPage("/login").permitAll();
        
    }
    
    /**
     * Configuracion de codificar password
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/10
     * @since 0.0.1 2020/06/10
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
}
