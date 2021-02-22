/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Juanjo Cortés
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Utilidades {

    public static List<Alumnos> getAlumnosBD(String grupo) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_alumnosBDMVC_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM alumnos where grupo = '" + grupo + "'";
        Query q = manager.createNativeQuery(sql, Alumnos.class);
        List<Alumnos> alumnosBD = q.getResultList();

        return alumnosBD;
    }
}
