/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/24
 * @since 0.0.1 2020/05/24
 */

package co.com.crivera.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/24
 * @since 0.0.1 2020/05/24
 */
public class FileUtil
{
    /**Espacio*/
    private static final String SPACE = " ";

    /**
     * Guarda un archivo en la ruta indicada
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/24
     * @since 0.0.1 2020/05/24
     * @param multipart
     * @param ruta
     * @return
     */
    public static String guardarArchivo(MultipartFile multipart, String ruta)
    {  
        try
        {
            StringBuilder nombreOriginal = new StringBuilder().append(new Date().getTime()).append(multipart.getOriginalFilename().replace(SPACE, "-"));        
            File imageFile = new File(ruta + nombreOriginal.toString());
            multipart.transferTo(imageFile);
            return nombreOriginal.toString();
        }
        catch (IllegalStateException | IOException e)
        {
            System.out.println("Error:" + e.getMessage());
            return null;
        }
        
    }
}
