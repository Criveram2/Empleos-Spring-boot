/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/22
 * @since 0.0.1 2020/05/22
 */

package co.com.crivera.model;

/**
 * Dto con los datos asociados a una categoria
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/22
 * @since 0.0.1 2020/05/22
 */

public class Categoria
{

    private Integer id;
    private String nombre;
    private String descripcion;
    /**
     * @return Regresa el valor del campo id
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     */
    public Integer getId()
    {
        return id;
    }
    /**
     * @param id Nuevo valor para el campo id
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     */
    public void setId(Integer id)
    {
        this.id = id;
    }
    /**
     * @return Regresa el valor del campo nombre
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     */
    public String getNombre()
    {
        return nombre;
    }
    /**
     * @param nombre Nuevo valor para el campo nombre
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    /**
     * @return Regresa el valor del campo descripcion
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     */
    public String getDescripcion()
    {
        return descripcion;
    }
    /**
     * @param descripcion Nuevo valor para el campo descripcion
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }  
}
