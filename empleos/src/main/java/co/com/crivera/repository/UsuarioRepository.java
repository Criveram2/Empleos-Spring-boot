/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/27
 * @since 0.0.1 2020/05/27
 */

package co.com.crivera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.crivera.entity.UsuarioEntity;

/**
 * Repositorio para usuaro
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/09
 * @since 0.0.1 2020/05/27
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>
{
    /**
     * SELECT * FROM USUARIOS WHERE USUARIO=? AND PASSWORD = ?
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/09
     * @since 0.0.1 2020/05/28
     * @param usuario
     * @return usaurio existente con datos de consulta
     */
    UsuarioEntity findByUsuario(String usuario);
}
