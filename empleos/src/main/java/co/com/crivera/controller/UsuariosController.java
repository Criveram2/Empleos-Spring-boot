/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/02
 * @since 0.0.1 2020/06/02
 */

package co.com.crivera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.crivera.model.Usuario;
import co.com.crivera.service.UsuarioService;

/**
 * Controlador para temas relacionados con usuarios
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/02
 * @since 0.0.1 2020/06/02
 */
@Controller
@RequestMapping("/usuarios")
public class UsuariosController
{
    @Autowired
    private UsuarioService usuarioService;
    
    
    /**
     *  mostrar todos los usuarios
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     * @param model
     * @return lista de usuarios
     */
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Usuario> lista = getUsuarioService().buscarTodos();
        model.addAttribute("usuarios", lista);
        return "usuarios/listUsuarios";
    }
    
    /**
     * 
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/02
     * @since 0.0.1 2020/06/02
     * @param idUsuario
     * @param attributes
     * @return
     */
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {              
        // Eliminamos el usuario
        getUsuarioService().eliminar(idUsuario);            
        attributes.addFlashAttribute("msg", "El usuario fue eliminado!.");
        return "redirect:/usuarios/index";
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
