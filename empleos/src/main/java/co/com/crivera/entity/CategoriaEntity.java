/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/26
 * @since 0.0.1 2020/05/26
 */

package co.com.crivera.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entidad Categoria
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/26
 * @since 0.0.1 2020/05/26
 */
@Entity
@Table(name = "CATEGORIAS")
public class CategoriaEntity
{
    @Id
    @Column(name = "CATEGORIA_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "CATEGORIAS_SEQ", name = "CATEGORIAS_SEQ")
    private Integer id;
    @Column(name = "NOMBRE")
    private String  nombre;
    @Column(name = "DESCRIPCION")
    private String  descripcion;
    
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
