/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/19
 * @since 0.0.1 2020/05/19
 */

package co.com.crivera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.crivera.model.Categoria;
import co.com.crivera.model.Usuario;
import co.com.crivera.model.Vacante;
import co.com.crivera.service.CategoriaService;
import co.com.crivera.service.UsuarioService;
import co.com.crivera.service.VacanteService;

/**
 * controlador para la pantalla Home
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/19
 * @since 0.0.1 2020/05/19
 */
@Controller
public class HomeController
{
    @Autowired
    VacanteService         vacanteService;
    @Autowired
    CategoriaService       categoriaService;
    @Autowired
    private UsuarioService usuarioService;
    
    /**
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/19
     * @since 0.0.1 2020/05/19
     * @return
     */
    @GetMapping("")
    public String mostrarHome(Model model)
    {
        
        List<Vacante> vacantes = getVacanteService().buscarDestados();
        model.addAttribute("vacantes", vacantes);
        
        model.addAttribute("search", new Vacante());
        return "home";
    }
    
    /**
     * Formulario para registrar un usario
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     * @param usuario
     * @return
     */
    @GetMapping("/signup")
    public String registrarse(Usuario usuario)
    {
        return "formRegistro";
        
    }
    
    /**
     * Registra usuario en core
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     * @param usuario
     * @param attributes
     * @return
     */
    @PostMapping("/signup")
    public String guardar(Usuario usuario, RedirectAttributes attributes)
    {
        getUsuarioService().guardar(usuario);
        attributes.addFlashAttribute("msg", "Registro Guardado");
        return "redirect:/usuarios/index";
        
    }
    
    /**
     * Formulario para registrar un usario
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     * @param usuario
     * @return
     */
    @GetMapping("/search")
    public String buscar(@ModelAttribute("search") Vacante vacante, Model model)
    {
        List<Vacante> vacantes = getVacanteService().buscarPorExample(vacante);
        model.addAttribute("vacantes", vacantes);
        return "home";
        
    }
    
    @ModelAttribute
    public void setGenericos(Model model)
    {
        List<Categoria> categorias = getCategoriaService().buscarTodas();
        model.addAttribute("categorias", categorias);
    }
    
    /**
     * InitBinder  para string si los detecta vacios en el Data Binding los settea Null
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     * @param binder
     */
    @InitBinder
    public void InitBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true) );
    }
    /**
     * @return Regresa el valor del campo vacanteService
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/27
     * @since 0.0.1 2020/05/27
     */
    public VacanteService getVacanteService()
    {
        return vacanteService;
    }
    
    /**
     * @return Regresa el valor del campo categoriaService
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/27
     * @since 0.0.1 2020/05/27
     */
    public CategoriaService getCategoriaService()
    {
        return categoriaService;
    }
    
    /**
     * @return Regresa el valor del campo usuarioService
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     */
    public UsuarioService getUsuarioService()
    {
        return usuarioService;
    }
    
}
