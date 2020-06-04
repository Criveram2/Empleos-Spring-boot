/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/20
 * @since 0.0.1 2020/05/20
 */

package co.com.crivera.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.com.crivera.model.Vacante;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/20
 * @since 0.0.1 2020/05/20
 */
public interface VacanteService
{
    /**
     * consulta listado de vacantes
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @return lista de vacantes
     */
    List<Vacante> buscarTodas();
    
    /**
     * consulta listado de vacantes
     * @author Camilo Rivera Paginado
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @return lista de vacantes
     */
    Page<Vacante> buscarTodas(Pageable pageable);
    

    /**
     * consulta  vacante por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @return lista de vacantes
     */
    Vacante buscarPorId(int id);
    
    /**
     * consulta listado de vacantes destacadas
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @return lista de vacantes
     */
    List<Vacante> buscarDestados();

    /**
     * guardar de vacantes
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @param vacante datos con la vacante a guardar
     * @return lista de vacantes
     */
    void guardar(Vacante vacante);
    
    /**
     * modificar de vacantes
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     * @param vacante datos con la vacante a guardar
     * @return lista de vacantes
     */
    void modificar(Vacante vacante);
    
    /**
     * eliminar vacante por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     * @return lista de vacantes
     */
    void eliminar(int id);
    
    
    /**
     * consulta listado de vacantes por atributos indicados
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @return lista de vacantes
     */
    List<Vacante> buscarPorExample(Vacante vacante);
}
