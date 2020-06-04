/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/20
 * @since 0.0.1 2020/05/20
 */

package co.com.crivera.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.com.crivera.entity.CategoriaEntity;
import co.com.crivera.entity.VacanteEntity;
import co.com.crivera.model.Categoria;
import co.com.crivera.model.Vacante;
import co.com.crivera.repository.VacanteRepository;

/**
 * Implementacion de VacanteService
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/20
 * @since 0.0.1 2020/05/20
 */
@Service
public class VacateServiceImpl implements VacanteService
{
    /** Estado Aprabado */
    private static final String APROBADO = "Aprobada";
    /** NO en base de datos*/
    private static final String NO = "N";   
    /** SI en base de datos*/
    private static final String SI = "S";   
    /**  Repositorio de vacantes*/
    @Autowired
    private VacanteRepository vacanteRepository;
    

    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.VacanteService#buscarTodas()
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     */
    @Override
    public List<Vacante> buscarTodas()
    {
        List<VacanteEntity> vacantesEntity = getVacanteRepository().findAll();
        List<Vacante> vacantes = new ArrayList<>();
        vacantesEntity.forEach(vacanteEntity ->
        {
            Vacante vacante = convertVacanteEntityToVacante(vacanteEntity);
            vacantes.add(vacante);
        });
        return vacantes;
    }
    
    /* (non-Javadoc)
     * @see co.com.crivera.service.VacanteService#buscarTodas(java.awt.print.Pageable)
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    @Override
    public Page<Vacante> buscarTodas(Pageable pageable)
    {
        Page<VacanteEntity> vacantesEntity = getVacanteRepository().findAll(pageable);     
        List<Vacante> vacantes = new ArrayList<>();
        vacantesEntity.forEach(vacanteEntity ->
        {
            Vacante vacante = convertVacanteEntityToVacante(vacanteEntity);
            vacantes.add(vacante);
        });
        
        long catidadRegistros = getVacanteRepository().count();
        Page<Vacante> vacantesPaginados = new PageImpl<>(vacantes,pageable,catidadRegistros);
        return vacantesPaginados;
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.VacanteService#buscarPorId(int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     */
    @Override
    public Vacante buscarPorId(int id)
    {
        Optional<VacanteEntity> vacanteEntity = getVacanteRepository().findById(id);
        if(vacanteEntity.get()!=null) {
        return convertVacanteEntityToVacante(vacanteEntity.get());
        }else {
            return null;
        }
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.VacanteService#buscarDestados()
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     */
    @Override
    public List<Vacante> buscarDestados()
    {
        List<VacanteEntity> vacantesEntity = getVacanteRepository().findBydestacadoAndEstatus(SI,APROBADO);
        List<Vacante> vacantesDestacadas = new ArrayList<>();
        vacantesEntity.forEach(vacanteEntity ->
        {
            Vacante vacante = convertVacanteEntityToVacante(vacanteEntity);
            vacantesDestacadas.add(vacante);
        });
        return vacantesDestacadas;
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.VacanteService#guardar(co.com.crivera.model.Vacante)
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/21
     * @since 0.0.1 2020/05/21
     */
    @Override
    public void guardar(Vacante vacante)
    {
        VacanteEntity vacanteEntity = convertVacanteToVacanteEntity(vacante);
        getVacanteRepository().save(vacanteEntity);
    }
    
    /* (non-Javadoc)
     * @see co.com.crivera.service.VacanteService#modificar(co.com.crivera.model.Vacante)
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    @Override
    public void modificar(Vacante vacante)
    {
        Optional<VacanteEntity> vacanteEntityTemporal = getVacanteRepository().findById(vacante.getId());
        if(vacanteEntityTemporal.get()!=null) {
        VacanteEntity vacanteEntity = convertVacanteToVacanteEntity(vacante);
        vacanteEntity.setId(vacanteEntityTemporal.get().getId());
        getVacanteRepository().save(vacanteEntity);
        }
        
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.VacanteService#eliminar(int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    @Override
    public void eliminar(int id)
    {
        getVacanteRepository().deleteById(id);       
    }
    
   /*
    * (non-Javadoc)
    * @see co.com.crivera.service.VacanteService#buscarPorExample(co.com.crivera.model.Vacante)
    * @author Camilo Rivera
    * @version 0.0.1 2020/06/02
    * @since 0.0.1 2020/06/02
    */
    @Override
    public List<Vacante> buscarPorExample(Vacante vacante)
    {
        vacante.setImagen(null);
        VacanteEntity vacanteEntity = convertVacanteToVacanteEntity(vacante);
        
        ExampleMatcher martcher = ExampleMatcher
                //where descripcion like '%?%'
                .matching()
                .withMatcher("descripcion", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<VacanteEntity> example = Example.of(vacanteEntity,martcher);
        
        
        List<VacanteEntity> vacantesEntity =  getVacanteRepository().findAll(example);
        List<Vacante> vacantesDestacadas = new ArrayList<>();
        vacantesEntity.forEach(vacanteTemp ->  vacantesDestacadas.add(convertVacanteEntityToVacante(vacanteTemp)));
        return vacantesDestacadas;
    }

    
    /**
     * Mapea VacanteEntity a partir de Vacante
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     * @param vacante
     * @return
     */
    private VacanteEntity convertVacanteToVacanteEntity(Vacante vacante)
    {
        VacanteEntity vacanteEntity = new VacanteEntity();
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(vacante.getCategoria().getId());
        vacanteEntity.setCategoriaEntity(categoriaEntity);
        vacanteEntity.setDescripcion(vacante.getDescripcion());
        if(vacante.getDestacado()!=null) {
        vacanteEntity.setDestacado(vacante.getDestacado() ? SI : NO);
        }
        vacanteEntity.setDetalles(vacante.getDetalles());
        vacanteEntity.setEstatus(vacante.getEstatus());
        vacanteEntity.setFechaPublicacion(vacante.getFechaPublicacion());
        vacanteEntity.setId(vacante.getId());
        vacanteEntity.setImagen(vacante.getImagen());
        vacanteEntity.setNombre(vacante.getNombre());
        vacanteEntity.setSalario(vacante.getSalario());
        vacanteEntity.setId(vacante.getId());
        return vacanteEntity;
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
     * @return Regresa el valor del campo vacanteRepository
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public VacanteRepository getVacanteRepository()
    {
        return vacanteRepository;
    }





}
