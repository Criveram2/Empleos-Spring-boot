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
@Table(name = "VACANTES")
public class VacanteEntity
{
    @Id
    @Column(name = "VACANTES_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "VACANTES_SEQ", name = "VACANTES_SEQ")
    private Integer id;
    @Column(name = "NOMBRE")
    private String  nombre;
    @Column(name = "DESCRIPCION")
    private String  descripcion;
    @Column(name = "FECHA_PUBLICACION")
    private Date    fechaPublicacion;
    @Column(name = "SALARIO")
    private Double  salario;
    @Column(name = "DESTACADO")
    private String destacado;
    @Column(name = "IMAGEN")
    private String  imagen;
    @Column(name = "ESTADO")
    private String  estatus;
    @Column(name = "DETALLE")
    private String  detalles;
    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="CATEGORIA")
    private CategoriaEntity categoriaEntity;
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
     * @return Regresa el valor del campo descripcion
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getDescripcion()
    {
        return descripcion;
    }
    /**
     * @param descripcion Nuevo valor para el campo descripcion
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
    /**
     * @return Regresa el valor del campo fechaPublicacion
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public Date getFechaPublicacion()
    {
        return fechaPublicacion;
    }
    /**
     * @param fechaPublicacion Nuevo valor para el campo fechaPublicacion
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setFechaPublicacion(Date fechaPublicacion)
    {
        this.fechaPublicacion = fechaPublicacion;
    }
    /**
     * @return Regresa el valor del campo salario
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public Double getSalario()
    {
        return salario;
    }
    /**
     * @param salario Nuevo valor para el campo salario
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setSalario(Double salario)
    {
        this.salario = salario;
    }
    /**
     * @return Regresa el valor del campo destacado
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getDestacado()
    {
        return destacado;
    }
    /**
     * @param destacado Nuevo valor para el campo destacado
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setDestacado(String destacado)
    {
        this.destacado = destacado;
    }
    /**
     * @return Regresa el valor del campo imagen
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getImagen()
    {
        return imagen;
    }
    /**
     * @param imagen Nuevo valor para el campo imagen
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setImagen(String imagen)
    {
        this.imagen = imagen;
    }
    /**
     * @return Regresa el valor del campo estatus
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getEstatus()
    {
        return estatus;
    }
    /**
     * @param estatus Nuevo valor para el campo estatus
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setEstatus(String estatus)
    {
        this.estatus = estatus;
    }
    /**
     * @return Regresa el valor del campo detalles
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public String getDetalles()
    {
        return detalles;
    }
    /**
     * @param detalles Nuevo valor para el campo detalles
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setDetalles(String detalles)
    {
        this.detalles = detalles;
    }
    /**
     * @return Regresa el valor del campo categoriaEntity
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public CategoriaEntity getCategoriaEntity()
    {
        return categoriaEntity;
    }
    /**
     * @param categoriaEntity Nuevo valor para el campo categoriaEntity
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public void setCategoriaEntity(CategoriaEntity categoriaEntity)
    {
        this.categoriaEntity = categoriaEntity;
    }

    
}
