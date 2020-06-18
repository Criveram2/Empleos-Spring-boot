/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/17
 * @since 0.0.1 2020/06/17
 */

package co.com.crivera.model;

import java.util.Date;

/**
 * Objeto con datos de la solicitud
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/17
 * @since 0.0.1 2020/06/17
 */
public class Solicitud
{
    /**id de la solicitud*/
    private Integer id;
    /** fecha en la cual se crea la solicutd */
    private Date  fecha;
    /** archivo */
    private String  archivo;
    /** comentarios para la solicitud */
    private String  comentarios;
    /** Datos del usuario */
    private Usuario usuario;
    /** Datos Vacantes */
    private Vacante vacante;
    /**
     * @return Regresa el valor del campo id
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public Integer getId()
    {
        return id;
    }
    /**
     * @param id Nuevo valor para el campo id
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public void setId(Integer id)
    {
        this.id = id;
    }
    /**
     * @return Regresa el valor del campo fecha
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public Date getFecha()
    {
        return fecha;
    }
    /**
     * @param fecha Nuevo valor para el campo fecha
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }
    /**
     * @return Regresa el valor del campo archivo
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public String getArchivo()
    {
        return archivo;
    }
    /**
     * @param archivo Nuevo valor para el campo archivo
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public void setArchivo(String archivo)
    {
        this.archivo = archivo;
    }
    /**
     * @return Regresa el valor del campo comentarios
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public String getComentarios()
    {
        return comentarios;
    }
    /**
     * @param comentarios Nuevo valor para el campo comentarios
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public void setComentarios(String comentarios)
    {
        this.comentarios = comentarios;
    }
    /**
     * @return Regresa el valor del campo usuario
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public Usuario getUsuario()
    {
        return usuario;
    }
    /**
     * @param usuario Nuevo valor para el campo usuario
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }
    /**
     * @return Regresa el valor del campo vacante
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public Vacante getVacante()
    {
        return vacante;
    }
    /**
     * @param vacante Nuevo valor para el campo vacante
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public void setVacante(Vacante vacante)
    {
        this.vacante = vacante;
    }
}
