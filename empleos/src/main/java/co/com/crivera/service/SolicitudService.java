/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/17
 * @since 0.0.1 2020/06/17
 */

package co.com.crivera.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.com.crivera.model.Solicitud;

/**
 * Interface con la logica de negocio para solicitudes
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/17
 * @since 0.0.1 2020/06/17
 */
public interface SolicitudService
{
    /**
     * Guarda datos de una solicitud
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     * @param solicitud
     */
    public void guardar(Solicitud solicitud) ;
    
    /**
     * Buscar todas las solicitudes pagiandas
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     * @param pageable
     * @return
     */
    public Page<Solicitud> buscarTodas(Pageable pageable) ;
    
    /**
     * Eliminar solicitud por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/18
     * @since 0.0.1 2020/06/18
     * @param idSolicitud
     */
    public void eliminar(Integer idSolicitud) ;
}
