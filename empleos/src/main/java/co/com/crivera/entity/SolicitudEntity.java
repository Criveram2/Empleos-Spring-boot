/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/26
 * @since 0.0.1 2020/05/26
 */

package co.com.crivera.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/26
 * @since 0.0.1 2020/05/26
 */
@Entity
@Table(name = "SOLICITUDES")
public class SolicitudEntity
{
    @Id
    @Column(name = "SOLICITUD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "SOLICITUDES_SEQ", name = "SOLICITUDES_SEQ")
    private Integer id;
    @Column(name = "FECHA")
    private Date  fecha;
    @Column(name = "ARCHIVO")
    private String  archivo;
    @Column(name = "COMENTARIOS")
    private String  comentarios;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="USUARIO_ID")
    private UsuarioEntity usuario;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="VACANTE_ID")
    private VacanteEntity vacante;
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
     * @return Regresa el valor del campo fecha
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public Date getFecha()
    {
        return fecha;
    }
    /**
     * @param fecha Nuevo valor para el campo fecha
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }
    /**
     * @return Regresa el valor del campo archivo
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getArchivo()
    {
        return archivo;
    }
    /**
     * @param archivo Nuevo valor para el campo archivo
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setArchivo(String archivo)
    {
        this.archivo = archivo;
    }
    /**
     * @return Regresa el valor del campo comentarios
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getComentarios()
    {
        return comentarios;
    }
    /**
     * @param comentarios Nuevo valor para el campo comentarios
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setComentarios(String comentarios)
    {
        this.comentarios = comentarios;
    }
    /**
     * @return Regresa el valor del campo usuario
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public UsuarioEntity getUsuario()
    {
        return usuario;
    }
    /**
     * @param usuario Nuevo valor para el campo usuario
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setUsuario(UsuarioEntity usuario)
    {
        this.usuario = usuario;
    }
    /**
     * @return Regresa el valor del campo vacante
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public VacanteEntity getVacante()
    {
        return vacante;
    }
    /**
     * @param vacante Nuevo valor para el campo vacante
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setVacante(VacanteEntity vacante)
    {
        this.vacante = vacante;
    }
}
