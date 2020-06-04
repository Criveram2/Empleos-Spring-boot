/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/26
 * @since 0.0.1 2020/05/26
 */

package co.com.crivera.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.crivera.entity.VacanteEntity;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/05/26
 * @since 0.0.1 2020/05/26
 */
@Repository
public interface VacanteRepository  extends JpaRepository<VacanteEntity, Integer>
{
    /**
     * SELECT * FROM VACANTES WHERE DESTACADO=?
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/28
     * @since 0.0.1 2020/05/28
     * @param destacado
     * @param estado
     * @return
     */   
    List<VacanteEntity> findBydestacado(String destacado);
    
    /**
     * SELECT * FROM VACANTES WHERE DESTACADO=? AND ESTATUS=?
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/28
     * @since 0.0.1 2020/05/28
     * @param destacado
     * @param estado
     * @return
     */   
    List<VacanteEntity> findBydestacadoAndEstatus(String destacado, String estatus);
    
    /**
     * SELECT * FROM VACANTES WHERE SALARIO>minimo AND SALARIO < maximo
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/28
     * @since 0.0.1 2020/05/28
     * @param destacado
     * @param estado
     * @return
     */   
    List<VacanteEntity> findBySalarioBetweenOrderBySalarioDesc(double minimo,double maximo);
    
    /**
     * SELECT * FROM VACANTES WHERE ESTATUS IN(?)
     * @author Camilo Rivera
     * @version 0.0.1 2020/05/28
     * @since 0.0.1 2020/05/28
     * @param destacado
     * @param estado
     * @return
     */   
    List<VacanteEntity> findByEstatusIn(String[] estatus);
}
