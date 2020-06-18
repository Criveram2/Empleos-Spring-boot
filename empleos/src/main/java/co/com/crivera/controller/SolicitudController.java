/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/17
 * @since 0.0.1 2020/06/17
 */

package co.com.crivera.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.com.crivera.model.Solicitud;
import co.com.crivera.model.Usuario;
import co.com.crivera.model.Vacante;
import co.com.crivera.service.SolicitudService;
import co.com.crivera.service.UsuarioService;
import co.com.crivera.service.VacanteService;
import co.com.crivera.util.FileUtil;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/06/17
 * @since 0.0.1 2020/06/17
 */
@Controller
@RequestMapping("/solicitudes")
public class SolicitudController
{
    /** ubicacion para almacenar CV */
    @Value("${empleosapp.ruta.cv}")
    private String ruta;
    /** vacantes service */
    @Autowired
    VacanteService vacanteService;
    /** usuarios service */
    @Autowired
    private UsuarioService usuarioService;
    /** solicitud service */
    @Autowired
    private SolicitudService solicitudService;
    
    /**
     * Metodo que muestra la lista de solicitudes con paginacion
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/indexPaginate")
    public String mostrarIndexPaginado(Model model, Pageable page) {
        Page<Solicitud> lista = getSolicitudService().buscarTodas(page);
        model.addAttribute("solicitudes", lista);
        return "solicitudes/listSolicitudes";
    }
    
    /**
     * Método para renderizar el formulario para aplicar para una Vacante
     * @param solicitud
     * @param idVacante
     * @param model
     * @return
     */
    @GetMapping("/create/{idVacante}")
    public String crear(Solicitud solicitud, @PathVariable Integer idVacante, Model model)
    {
        // Traemos los detalles de la Vacante seleccionada para despues mostrarla en la vista
        Vacante vacante = getVacanteService().buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);
        return "solicitudes/formSolicitud";
    }
    
    /**
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     * @param solicitud datos de la solicitud
     * @param result 
     * @param model
     * @param session
     * @param multiPart
     * @param attributes
     * @param authentication
     * @return
     */
    @PostMapping("/save")
    public String guardar(Solicitud solicitud, BindingResult result, Model model, HttpSession session, @RequestParam("archivoCV") MultipartFile multiPart, RedirectAttributes attributes,
            Authentication authentication)
    {
        // Recuperamos el username que inicio sesión
        String username = authentication.getName();
        
        if (result.hasErrors())
        {
            System.out.println("Existieron errores");
            return "solicitudes/formSolicitud";
        }
        
        if (!multiPart.isEmpty())
        {
            // String ruta = "/empleos/files-cv/"; // Linux/MAC
            // String ruta = "c:/empleos/files-cv/"; // Windows
            String nombreArchivo = FileUtil.guardarArchivo(multiPart, ruta);
            if (nombreArchivo != null)
            { // El archivo (CV) si se subio
                solicitud.setArchivo(nombreArchivo); // Asignamos el nombre de la imagen
            }
        }
        
        // Buscamos el objeto Usuario en BD
        Usuario usuario = getUsuarioService().buscarPorNombreUsuario(username);
        
        solicitud.setUsuario(usuario); // Referenciamos la solicitud con el usuario
        solicitud.setFecha(new Date());
        // Guadamos el objeto solicitud en la bd
        getSolicitudService().guardar(solicitud);
        attributes.addFlashAttribute("msg", "Gracias por enviar tu CV!");
        
        // return "redirect:/solicitudes/index";
        return "redirect:/";
    }
    
    /**
     * Elimina solicitud por id 
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/18
     * @since 0.0.1 2020/06/18
     * @param idSolicitud
     * @param attributes
     * @return
     */
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idSolicitud, RedirectAttributes attributes) {
        
        // Eliminamos la solicitud.
        getSolicitudService().eliminar(idSolicitud);
        attributes.addFlashAttribute("msg", "La solicitud fue eliminada!.");
        //return "redirect:/solicitudes/index";
        return "redirect:/solicitudes/indexPaginate";
    }
        
    
    /**
     * @return Regresa el valor del campo vacanteService
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public VacanteService getVacanteService()
    {
        return vacanteService;
    }

    /**
     * @return Regresa el valor del campo usuarioService
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public UsuarioService getUsuarioService()
    {
        return usuarioService;
    }

    /**
     * @return Regresa el valor del campo solicitudService
     * @author Camilo Rivera
     * @version 0.0.1 2020/06/17
     * @since 0.0.1 2020/06/17
     */
    public SolicitudService getSolicitudService()
    {
        return solicitudService;
    }
}
