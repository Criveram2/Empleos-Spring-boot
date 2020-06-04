/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/26
 * @since 0.0.1 2020/05/26
 */

package co.com.crivera.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entidad usuarios
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/26
 * @since 0.0.1 2020/05/26
 */
@Entity
@Table(name = "USUARIOS")
public class UsuarioEntity
{
    @Id
    @Column(name = "USUARIO_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "USUARIOS_SEQ", name = "USUARIOS_SEQ")
    private Integer            id;
    @Column(name = "NOMBRE")
    private String             nombre;
    @Column(name = "EMAIL")
    private String             email;
    @Column(name = "USUARIO")
    private String             usuario;
    @Column(name = "PASSWORD")
    private String             password;
    @Column(name = "ESTADO")
    private String             estado;
    @Column(name = "FECHA_REGISTRO")
    private Date               fechaRegistro;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USUARIO_PERFIL", joinColumns = @JoinColumn(name = "USUARIO_ID"), inverseJoinColumns = @JoinColumn(name = "PERFIL_ID"))
    private List<PerfilEntity> perfiles;
    
    /**
     * Adiciona un perfil que se le va a adicionar al usuario
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/28
     * @since 0.0.1 2020/05/28
     * @param perfil
     */
    public void agregarPerfil(PerfilEntity perfil)
    {
        if (perfiles == null)
        {
            perfiles = new LinkedList<PerfilEntity>();
        }
        perfiles.add(perfil);
    }
    
    /**
     * @return Regresa el valor del campo id
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public Integer getId()
    {
        return id;
    }
    
    /**
     * @param id Nuevo valor para el campo id
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    /**
     * @return Regresa el valor del campo nombre
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * @param nombre Nuevo valor para el campo nombre
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    /**
     * @return Regresa el valor del campo email
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * @param email Nuevo valor para el campo email
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * @return Regresa el valor del campo usuario
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getUsuario()
    {
        return usuario;
    }
    
    /**
     * @param usuario Nuevo valor para el campo usuario
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }
    
    /**
     * @return Regresa el valor del campo password
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * @param password Nuevo valor para el campo password
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * @return Regresa el valor del campo estado
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getEstado()
    {
        return estado;
    }
    
    /**
     * @param estado Nuevo valor para el campo estado
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
    
    /**
     * @return Regresa el valor del campo fechaRegistro
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public Date getFechaRegistro()
    {
        return fechaRegistro;
    }
    
    /**
     * @param fechaRegistro Nuevo valor para el campo fechaRegistro
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setFechaRegistro(Date fechaRegistro)
    {
        this.fechaRegistro = fechaRegistro;
    }
    
    /**
     * @return Regresa el valor del campo perfiles
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/27
     * @since 0.0.1 2020/05/27
     */
    public List<PerfilEntity> getPerfiles()
    {
        return perfiles;
    }
    
    /**
     * @param perfiles Nuevo valor para el campo perfiles
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/27
     * @since 0.0.1 2020/05/27
     */
    public void setPerfiles(List<PerfilEntity> perfiles)
    {
        this.perfiles = perfiles;
    }
}
