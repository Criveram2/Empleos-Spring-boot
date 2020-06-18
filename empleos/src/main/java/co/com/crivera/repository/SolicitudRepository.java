/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/17
 * @since 0.0.1 2020/06/17
 */

package co.com.crivera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.crivera.entity.SolicitudEntity;

/**
 * Repositorio para solicitudes
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/17
 * @since 0.0.1 2020/06/17
 */
@Repository
public interface SolicitudRepository  extends JpaRepository<SolicitudEntity, Integer>
{
   
    
    
}
