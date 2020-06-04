/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/02
 * @since 0.0.1 2020/06/02
 */

package co.com.crivera.model;

import java.util.Date;
import java.util.List;

/**
 * Dto con datos del usuario
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/02
 * @since 0.0.1 2020/06/02
 */
public class Usuario
{
    private Integer            id;
    private String             nombre;
    private String             email;
    private String             username;
    private String             password;
    private String             estado  = "Bloqueado";
    private Date               fechaRegistro;
    private List<Perfil> perfiles;
    /**
     * @return Regresa el valor del campo id
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public Integer getId()
    {
        return id;
    }
    /**
     * @param id Nuevo valor para el campo id
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setId(Integer id)
    {
        this.id = id;
    }
    /**
     * @return Regresa el valor del campo nombre
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public String getNombre()
    {
        return nombre;
    }
    /**
     * @param nombre Nuevo valor para el campo nombre
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    /**
     * @return Regresa el valor del campo email
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * @param email Nuevo valor para el campo email
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setEmail(String email)
    {
        this.email = email;
    }


    /**
     * @return Regresa el valor del campo username
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public String getUsername()
    {
        return username;
    }
    /**
     * @param username Nuevo valor para el campo username
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    /**
     * @return Regresa el valor del campo password
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public String getPassword()
    {
        return password;
    }
    /**
     * @param password Nuevo valor para el campo password
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    /**
     * @return Regresa el valor del campo estado
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public String getEstado()
    {
        return estado;
    }
    /**
     * @param estado Nuevo valor para el campo estado
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
    /**
     * @return Regresa el valor del campo fechaRegistro
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public Date getFechaRegistro()
    {
        return fechaRegistro;
    }
    /**
     * @param fechaRegistro Nuevo valor para el campo fechaRegistro
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setFechaRegistro(Date fechaRegistro)
    {
        this.fechaRegistro = fechaRegistro;
    }
    /**
     * @return Regresa el valor del campo perfiles
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public List<Perfil> getPerfiles()
    {
        return perfiles;
    }
    /**
     * @param perfiles Nuevo valor para el campo perfiles
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setPerfiles(List<Perfil> perfiles)
    {
        this.perfiles = perfiles;
    }
   
    
}
