/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/20
 * @since 0.0.1 2020/05/20
 */

package co.com.crivera.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.crivera.model.Categoria;
import co.com.crivera.model.Vacante;
import co.com.crivera.service.CategoriaService;
import co.com.crivera.service.VacanteService;
import co.com.crivera.util.FileUtil;

/**
 * Controlador de vacantes
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/20
 * @since 0.0.1 2020/05/20
 */
@Controller
@RequestMapping(value="/vacantes")
public class VacantesController
{
    
    @Value("${empleos.ruta.imagenes}")
    String rutaImagenes;
    @Autowired
    VacanteService vacanteService;
    @Autowired
    CategoriaService categoriaService;
    
    /**
     * detalle de vacantes
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String mostrarIndex( Model model) {
        List<Vacante> vacantes= vacanteService.buscarTodas();
        model.addAttribute("vacantes", vacantes);
        return "vacantes/listVacantes";
    }
 
    /**
     * detalle de vacantes
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @param model
     * @return
     */
    @GetMapping("/indexPaginate")
    public String mostrarIndexPaginado( Model model, Pageable page) {
        Page<Vacante> vacantes= vacanteService.buscarTodas(page);
        model.addAttribute("vacantes", vacantes);
        return "vacantes/listVacantes";
    }
 
    
    
    /**
     * detalle de vacantes
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @param model
     * @return
     */
    @GetMapping("/view/{id}")
    public String detalle(@PathVariable("id") int id,  Model model) {
        Vacante vacante= vacanteService.buscarPorId(id);
        model.addAttribute("vacante", vacante);
        return "vacantes/detalle";
    }
 
    /**
     * eliminar una vacante
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/20
     * @since 0.0.1 2020/05/20
     * @param  id identificador de vacante a eliminar
     * @return
     */
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int id, RedirectAttributes attributes) {

        vacanteService.eliminar(id);
        attributes.addFlashAttribute("msg","Vacante Eliminada");
        return "redirect:/vacantes/indexPaginate";

    }
    
    /**
     * Metopo para redirecionar al formulario de vacante
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/21
     * @since 0.0.1 2020/05/21
     * @param model
     * @return
     */
    @GetMapping("/crear")
    public String crear( Vacante vacante,  Model model) {
        List<Categoria> categorias = categoriaService.buscarTodas();
        model.addAttribute("categorias", categorias);
        return "vacantes/formVacante";

    }
    
    
    /**
     * Metopo para redirecionar al formulario de vacante
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/21
     * @since 0.0.1 2020/05/21
     * @param model
     * @return
     */
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int id,  Model model) {
        Vacante vacante= vacanteService.buscarPorId(id);
        List<Categoria> categorias = categoriaService.buscarTodas();
        model.addAttribute("categorias", categorias);
        model.addAttribute("vacante", vacante);
        return "vacantes/formVacante";

    }
    
    
    /**
     * Metopo para crear una vacante
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/21
     * @since 0.0.1 2020/05/21
     * @param model
     * @return
     */
    @PostMapping("/save")
    public String guardar( Vacante vacante,  BindingResult bindingResult,
            RedirectAttributes attributes, 
            @RequestParam("archivoImagen") MultipartFile multiPart) {
        if (bindingResult.hasErrors()) {
            return "vacantes/formVacante";
        }
        
        if(!multiPart.isEmpty()) {
            String nombreImagen = FileUtil.guardarArchivo(multiPart, rutaImagenes);
            if(nombreImagen!=null) {
                vacante.setImagen(nombreImagen);
            }
        }
  
        vacanteService.guardar(vacante);
        attributes.addFlashAttribute("msg","Vacante Guardada");
        return "redirect:/vacantes/indexPaginate";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        dateformat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, "fechaPublicacion",
                                    new CustomDateEditor(dateformat, true));       
    }
}
