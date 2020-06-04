/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/22
 * @since 0.0.1 2020/05/22
 */

package co.com.crivera.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.com.crivera.entity.CategoriaEntity;
import co.com.crivera.model.Categoria;
import co.com.crivera.repository.CategoriaRepository;

/**
 * Implementacion de categoria service
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/22
 * @since 0.0.1 2020/05/22
 */
@Service
public class CategoriaServiceImpl implements CategoriaService
{
    /**Repositorio de Categorias*/
    @Autowired
    CategoriaRepository categoriaRepository;
  
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.CategoriaService#guardar(co.com.crivera.model.Categoria)
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     */
    @Override
    public void guardar(Categoria categoria)
    {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(categoria.getId());
        categoriaEntity.setDescripcion(categoria.getDescripcion());
        categoriaEntity.setNombre(categoria.getNombre());
        getCategoriaRepository().save(categoriaEntity);
        
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.CategoriaService#buscarTodas()
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     */
    @Override
    public   List<Categoria> buscarTodas()
    {
        List<CategoriaEntity> categoriasEntiy =getCategoriaRepository().findAll(Sort.by(Sort.Direction.ASC, "id"));
        List<Categoria> listaCategorias = new ArrayList<>();
        categoriasEntiy.forEach(categoriaEntity->{
            Categoria categoria =convertCategoriaEntityToCategoria(categoriaEntity);
            listaCategorias.add(categoria);
        });
        return  listaCategorias;
    }
    
    /* (non-Javadoc)
     * @see co.com.crivera.service.CategoriaService#buscarTodas(org.springframework.data.domain.Pageable)
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/03
     * @since 0.0.1 2020/06/03
     */
    @Override
    public Page<Categoria> buscarTodas(Pageable pageable)
    {
        Page<CategoriaEntity> vacantesEntity = getCategoriaRepository().findAll(pageable);     
        List<Categoria> categorias = new ArrayList<>();
        vacantesEntity.forEach(vacanteEntity ->
        {
            Categoria categoria = convertCategoriaEntityToCategoria(vacanteEntity);
            categorias.add(categoria);
        });
        
        long catidadRegistros = getCategoriaRepository().count();
        Page<Categoria> categoriasaginados = new PageImpl<>(categorias,pageable,catidadRegistros);
        return categoriasaginados;
    } 
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.CategoriaService#buscarPorId(java.lang.Integer)
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/22
     * @since 0.0.1 2020/05/22
     */
    @Override
    public Categoria buscarPorId(Integer id)
    {

        Optional<CategoriaEntity> categoriaEntity=  getCategoriaRepository().findById(id);
        if(categoriaEntity.get() != null) {
            return convertCategoriaEntityToCategoria(categoriaEntity.get());
        }
        return null;
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.CategoriaService#eliminar(java.lang.Integer)
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/01
     * @since 0.0.1 2020/06/01
     */
    @Override
    public void eliminar(Integer id)
    {
        // TODO pendiente mirar que pasa con las vacantes asociadas a esta categoria
        getCategoriaRepository().deleteById(id);        
    }
    
    /**
     * Mapea Categoria a partir de  categoriaEntity
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
     * @return Regresa el valor del campo categoriaRepository
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/26
     * @since 0.0.1 2020/05/26
     */
    public CategoriaRepository getCategoriaRepository()
    {
        return categoriaRepository;
    }   
}
