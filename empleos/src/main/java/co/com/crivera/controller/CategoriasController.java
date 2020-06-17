/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/20
 * @since 0.0.1 2020/05/20
 */

package co.com.crivera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.crivera.model.Categoria;
import co.com.crivera.service.CategoriaService;

/**
 * Controlador de categorias
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/20
 * @since 0.0.1 2020/05/20
 */
@Controller
@RequestMapping(value="/categorias")
public class CategoriasController
{
    @Autowired
    private CategoriaService categoriaService;
    
    /**
     * Mostrar Index
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Categoria> categorias =getCategoriaService().buscarTodas();
        model.addAttribute("categorias", categorias);
        return "categorias/listCategorias";
    }
 
    /**
     * mostrarIndex Paginado
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/03
     * @since 0.0.1 2020/06/03
     * @param model
     * @return
     */
    @GetMapping("/indexPaginate")
    public String mostrarIndexPaginado( Model model, Pageable page) {
        Page<Categoria> categorias =getCategoriaService().buscarTodas(page);
        model.addAttribute("categorias", categorias);
        return "categorias/listCategorias";
    }
 
    
    /**
     * 
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @param model
     * @return
     */
    @GetMapping("/crear")
    public String crear(Model model) {
        return "categorias/formCategoria";
    }
    
    /**
     * Metopo para redirecionar al formulario de editar categoria
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/21
     * @since 0.0.1 2020/05/21
     * @param model
     * @return
     */
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int id,  Model model) {
        Categoria categoria= getCategoriaService().buscarPorId(id);
        model.addAttribute("categoria", categoria);
        return "categorias/formCategoria";

    }
           
    /**
     * Guardar una categoria
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @param nombre
     * @param descripcion
     * @param model
     * @return
     */
    @PostMapping("/save")
    public String guardar(Categoria categoria,  BindingResult bindingResult,
            RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "categorias/formCategoria";
        }
        getCategoriaService().guardar(categoria);
        attributes.addFlashAttribute("msg","Registro Guardado");
        return "redirect:/categorias/index";
    }
    
    /**
     * eliminar una categira
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/01
     * @since 0.0.1 2020/05/22
     * @param model
     * @return
     */
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int id,  Model model,
            RedirectAttributes attributes) {
        attributes.addFlashAttribute("msg","Registro Eliminado");
        return "redirect:/categorias/index";
    }

    /**
     * @return Regresa el valor del campo categoriaService
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/01
     * @since 0.0.1 2020/06/01
     */
    public CategoriaService getCategoriaService()
    {
        return categoriaService;
    }
        
    
}
