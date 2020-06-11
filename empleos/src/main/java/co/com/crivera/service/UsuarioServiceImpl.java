/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/02
 * @since 0.0.1 2020/06/02
 */

package co.com.crivera.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.crivera.entity.PerfilEntity;
import co.com.crivera.entity.UsuarioEntity;
import co.com.crivera.model.Perfil;
import co.com.crivera.model.Usuario;
import co.com.crivera.repository.UsuarioRepository;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/02
 * @since 0.0.1 2020/06/02
 */
@Service
public class UsuarioServiceImpl implements UsuarioService
{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.UsuarioService#guardar(co.com.crivera.model.Usuario)
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/10
     * @since 0.0.1 2020/06/02
     */
    @Override
    public void guardar(Usuario usuario)
    {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setEstado(usuario.getEstado());
        usuarioEntity.setId(usuario.getId());
        usuarioEntity.setNombre(usuario.getNombre());
        usuarioEntity.setPassword(usuario.getPassword());
        usuarioEntity.setUsuario(usuario.getUsername());
        if (usuario.getFechaRegistro() != null)
        {
            usuarioEntity.setFechaRegistro(usuario.getFechaRegistro());
        }
        else
        {
            usuarioEntity.setFechaRegistro(new Date());
        }      
        List<PerfilEntity> perfilesEntity = new ArrayList<>();
        if (usuario.getPerfiles() != null)
        {
            usuario.getPerfiles().forEach(perfil -> perfilesEntity.add(convertPerfilToPerfilEntity(perfil)));
        }
        
        usuarioEntity.setPerfiles(perfilesEntity);
        getUsuarioRepository().save(usuarioEntity);
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.UsuarioService#eliminar(java.lang.Integer)
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    @Override
    public void eliminar(Integer idUsuario)
    {
        getUsuarioRepository().deleteById(idUsuario);
        
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.UsuarioService#buscarTodos()
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    @Override
    public List<Usuario> buscarTodos()
    {
        List<UsuarioEntity> usuariosEntity = getUsuarioRepository().findAll();
        List<Usuario> usuarios = new ArrayList<>(usuariosEntity.size());
        usuariosEntity.forEach(usuarioEntity -> usuarios.add(convertUsuarioEntityToUsuario(usuarioEntity)));
        return usuarios;
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.UsuarioService#buscarPorNombreUsuario(java.lang.String)
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/09
     * @since 0.0.1 2020/06/09
     */
    @Override
    public Usuario buscarPorNombreUsuario(String username)
    {
        UsuarioEntity usuarioEntity = getUsuarioRepository().findByUsuario(username);
        return convertUsuarioEntityToUsuario(usuarioEntity);
    }
    
    /**
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/09
     * @since 0.0.1 2020/06/02
     * @param usuarioEntity
     * @return
     */
    private Usuario convertUsuarioEntityToUsuario(UsuarioEntity usuarioEntity)
    {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioEntity.getEmail());
        usuario.setEstado(usuarioEntity.getEstado());
        usuario.setFechaRegistro(usuarioEntity.getFechaRegistro());
        usuario.setId(usuarioEntity.getId());
        usuario.setNombre(usuarioEntity.getNombre());
        usuario.setPassword(usuarioEntity.getPassword());
        usuario.setUsername(usuarioEntity.getUsuario());
        
        List<Perfil> perfiles = new ArrayList<>();
        if (usuarioEntity.getPerfiles() != null)
        {
            usuarioEntity.getPerfiles().forEach(entidadPerfil -> perfiles.add(convertPerfilEntityToPerfil(entidadPerfil)));
        }
        
        usuario.setPerfiles(perfiles);
        return usuario;
    }
    
    /**
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/09
     * @since 0.0.1 2020/06/09
     * @param entidadPerfil
     * @return
     */
    private Perfil convertPerfilEntityToPerfil(PerfilEntity entidadPerfil)
    {
        Perfil perfil = new Perfil();
        perfil.setId(entidadPerfil.getId());
        perfil.setDescripcion(entidadPerfil.getDescripcion());
        perfil.setNombre(entidadPerfil.getNombre());
        return perfil;
    }
    
    
    /**
     * Convierte un perfil en entidad perfil
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/10
     * @since 0.0.1 2020/06/1o
     * @param entidadPerfil
     * @return
     */
    private PerfilEntity convertPerfilToPerfilEntity(Perfil perfil)
    {
        PerfilEntity perfilEntity = new PerfilEntity();
        perfilEntity.setId(perfil.getId());
        perfilEntity.setDescripcion(perfil.getDescripcion());
        perfilEntity.setNombre(perfil.getNombre());
        return perfilEntity;
    }
    
    /**
     * @return Regresa el valor del campo usuarioRepository
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public UsuarioRepository getUsuarioRepository()
    {
        return usuarioRepository;
    }
    
}
