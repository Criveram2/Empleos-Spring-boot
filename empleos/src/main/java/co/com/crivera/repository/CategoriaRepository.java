/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/24
 * @since 0.0.1 2020/05/24
 */

package co.com.crivera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.crivera.entity.CategoriaEntity;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/24
 * @since 0.0.1 2020/05/24
 */
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer>
{
   
}
