/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/02
 * @since 0.0.1 2020/06/02
 */

package co.com.crivera.service;

import java.util.List;

import co.com.crivera.model.Usuario;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/02
 * @since 0.0.1 2020/06/02
 */
public interface UsuarioService
{
    /**
     * GUardar usuario 
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     * @param usuario
     */
    public void guardar(Usuario usuario) ;
    
    /**
     * eliminar usuario por su ID
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     * @param idUsuario
     */
    public void eliminar(Integer idUsuario);
    
    /**
     * Consulta usuario por username
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     * @return
     */
    public List<Usuario> buscarTodos() ;
    
    Usuario buscarPorNombreUsuario(String username);
}
