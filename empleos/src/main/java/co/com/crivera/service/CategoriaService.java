/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/22
 * @since 0.0.1 2020/05/22
 */

package co.com.crivera.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.com.crivera.model.Categoria;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/22
 * @since 0.0.1 2020/05/22
 */
public interface CategoriaService
{
    /**
     * 
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     * @param categoria informacion de la categoria a almacenar
     */
    void guardar(Categoria categoria);
    
    /**
     * busca todas las categorias
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22 
     * @return la lista de categorias existentes
     */
    List<Categoria> buscarTodas();
    
    /**
     * consulta listado de categoria Paginado
     * @author Camilo Rivera 
     * @version 0.0.1 2020/06/03
     * @since 0.0.1 2020/06/03
     * @return lista de vacantes
     */
    Page<Categoria> buscarTodas(Pageable pageable);
    
    /**
     * buscar una categoria por su Id
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     * @param id identifcador de la categoria
     * @return datos de cateogoria
     */
    Categoria buscarPorId(Integer id);
    
    /**
     * eliminar una categoria por su Id
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     * @param id identifcador de la categoria
     * @return datos de cateogoria
     */
    void eliminar(Integer id);
}
