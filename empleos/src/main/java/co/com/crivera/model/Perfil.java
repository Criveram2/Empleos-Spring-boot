/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/02
 * @since 0.0.1 2020/06/02
 */

package co.com.crivera.model;

/**
 * Dto con los datos de un perfil
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/02
 * @since 0.0.1 2020/06/02
 */
public class Perfil
{
    private Integer id;
    private String  nombre;
    private String  descripcion;
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
}
