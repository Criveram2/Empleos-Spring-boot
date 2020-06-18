/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/17
 * @since 0.0.1 2020/06/17
 */

package co.com.crivera.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.com.crivera.entity.CategoriaEntity;
import co.com.crivera.entity.PerfilEntity;
import co.com.crivera.entity.SolicitudEntity;
import co.com.crivera.entity.UsuarioEntity;
import co.com.crivera.entity.VacanteEntity;
import co.com.crivera.model.Categoria;
import co.com.crivera.model.Perfil;
import co.com.crivera.model.Solicitud;
import co.com.crivera.model.Usuario;
import co.com.crivera.model.Vacante;
import co.com.crivera.repository.SolicitudRepository;

/**
 * Implementacion de la interface SolicitudService
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/17
 * @since 0.0.1 2020/06/17
 */
@Service
public class SolicitudServiceImpl implements SolicitudService
{
    /** SI en base de datos*/
    private static final String SI = "S";   
    /**Repositorio de solicitudes */
    @Autowired
    private SolicitudRepository solicitudRepository;
    
    /* (non-Javadoc)
     * @see co.com.crivera.service.SolicitudService#guardar(co.com.crivera.model.Solicitud)
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    @Override
    public void guardar(Solicitud solicitud)
    {
        SolicitudEntity solicitudEntity = new SolicitudEntity();
        solicitudEntity.setArchivo(solicitud.getArchivo());
        solicitudEntity.setComentarios(solicitud.getComentarios());
        solicitudEntity.setFecha(solicitud.getFecha());
        solicitudEntity.setId(solicitud.getId());   
        UsuarioEntity usuarioEntity= new UsuarioEntity();
        usuarioEntity.setId(solicitud.getUsuario().getId());
        solicitudEntity.setUsuario(usuarioEntity);
        VacanteEntity vacanteEntity= new VacanteEntity();
        vacanteEntity.setId(solicitud.getVacante().getId());
        solicitudEntity.setVacante(vacanteEntity);
        getSolicitudRepository().save(solicitudEntity);
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.SolicitudService#buscarTodas(org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable)
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    @Override
    public Page<Solicitud> buscarTodas(Pageable pageable)
    {

        Page<SolicitudEntity> solicitudesEntity =  getSolicitudRepository().findAll(pageable);     
        List<Solicitud> solicitudes = new ArrayList<>();
        solicitudesEntity.forEach(solicitudEntity -> solicitudes.add(convertEntityToSolicitud(solicitudEntity)));
        long catidadRegistros = getSolicitudRepository().count();
        Page<Solicitud> solicitudesPaginados = new PageImpl<>(solicitudes,pageable,catidadRegistros);
        return solicitudesPaginados;
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.SolicitudService#eliminar(java.lang.Integer)
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/18
     * @since 0.0.1 2020/06/18
     */
    @Override
    public void eliminar(Integer idSolicitud)
    {
        getSolicitudRepository().deleteById(idSolicitud);    
    }
    
    /**
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     * @param solicitudEntity
     * @return datos de solicitud
     */
    private Solicitud convertEntityToSolicitud(SolicitudEntity solicitudEntity)
    {
        Solicitud solicitud = new Solicitud();
        solicitud.setArchivo(solicitudEntity.getArchivo());
        solicitud.setComentarios(solicitudEntity.getComentarios());
        solicitud.setFecha(solicitudEntity.getFecha());
        solicitud.setId(solicitudEntity.getId());
        solicitud.setUsuario(convertUsuarioEntityToUsuario(solicitudEntity.getUsuario()));
        solicitud.setVacante(convertVacanteEntityToVacante(solicitudEntity.getVacante()));
        return solicitud;
    } 
    
    /**
     * Mapea Vacante a partir de vacanteEntity
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     * @param vacanteEntity
     * @return
     */
    private Vacante convertVacanteEntityToVacante(VacanteEntity vacanteEntity)
    {
        Vacante vacante = new Vacante();
        vacante.setCategoria(convertCategoriaEntityToCategoria(vacanteEntity.getCategoriaEntity()));
        vacante.setDescripcion(vacanteEntity.getDescripcion());
        vacante.setDestacado(vacanteEntity.getDestacado().equals(SI));
        vacante.setDetalles(vacanteEntity.getDetalles());
        vacante.setEstatus(vacanteEntity.getEstatus());
        vacante.setFechaPublicacion(vacanteEntity.getFechaPublicacion());
        vacante.setId(vacanteEntity.getId());
        vacante.setImagen(vacanteEntity.getImagen());
        vacante.setNombre(vacanteEntity.getNombre());
        vacante.setSalario(vacanteEntity.getSalario());
        return vacante;
    }
    
    /**
     * Mapea Categoria a partir de categoriaEntity
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     * @param categoriaEntity
     * @return
     */
    private Categoria convertCategoriaEntityToCategoria(CategoriaEntity categoriaEntity)
    {
        Categoria categoria = new Categoria();
        categoria.setDescripcion(categoriaEntity.getDescripcion());
        categoria.setId(categoriaEntity.getId());
        categoria.setNombre(categoriaEntity.getNombre());
        return categoria;
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
     * @return Regresa el valor del campo solicitudRepository
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public SolicitudRepository getSolicitudRepository()
    {
        return solicitudRepository;
    }
}
