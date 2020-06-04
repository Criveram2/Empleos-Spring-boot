/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/19
 * @since 0.0.1 2020/05/19
 */

package co.com.crivera.model;

import java.util.Date;

/**
 * Objeto con datos de vacante
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/19
 * @since 0.0.1 2020/05/19
 */

public class Vacante
{
    private Integer id;
    private String  nombre;
    private String  descripcion;
    private Date    fechaPublicacion;
    private Double  salario;
    private Boolean destacado;
    private String  imagen;
    private String  estatus;
    private String  detalles;
    private Categoria categoria;
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
     * @return Regresa el valor del campo descripcion
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public String getDescripcion()
    {
        return descripcion;
    }
    /**
     * @param descripcion Nuevo valor para el campo descripcion
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
    /**
     * @return Regresa el valor del campo fechaPublicacion
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public Date getFechaPublicacion()
    {
        return fechaPublicacion;
    }
    /**
     * @param fechaPublicacion Nuevo valor para el campo fechaPublicacion
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setFechaPublicacion(Date fechaPublicacion)
    {
        this.fechaPublicacion = fechaPublicacion;
    }
    /**
     * @return Regresa el valor del campo salario
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public Double getSalario()
    {
        return salario;
    }
    /**
     * @param salario Nuevo valor para el campo salario
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setSalario(Double salario)
    {
        this.salario = salario;
    }
    /**
     * @return Regresa el valor del campo destacado
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public Boolean getDestacado()
    {
        return destacado;
    }
    /**
     * @param destacado Nuevo valor para el campo destacado
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setDestacado(Boolean destacado)
    {
        this.destacado = destacado;
    }
    /**
     * @return Regresa el valor del campo imagen
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public String getImagen()
    {
        return imagen;
    }
    /**
     * @param imagen Nuevo valor para el campo imagen
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setImagen(String imagen)
    {
        this.imagen = imagen;
    }
    /**
     * @return Regresa el valor del campo estatus
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public String getEstatus()
    {
        return estatus;
    }
    /**
     * @param estatus Nuevo valor para el campo estatus
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setEstatus(String estatus)
    {
        this.estatus = estatus;
    }
    /**
     * @return Regresa el valor del campo detalles
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public String getDetalles()
    {
        return detalles;
    }
    /**
     * @param detalles Nuevo valor para el campo detalles
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setDetalles(String detalles)
    {
        this.detalles = detalles;
    }
    /**
     * @return Regresa el valor del campo categoria
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public Categoria getCategoria()
    {
        return categoria;
    }
    /**
     * @param categoria Nuevo valor para el campo categoria
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public void setCategoria(Categoria categoria)
    {
        this.categoria = categoria;
    }
    
    
}
