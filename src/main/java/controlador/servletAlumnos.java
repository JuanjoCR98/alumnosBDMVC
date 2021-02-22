/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumnos;
import modelo.Utilidades;

/**
 *
 * @author Juanjo Cortés
 */
public class servletAlumnos extends HttpServlet {

    private ArrayList<String> gruposDAW;
      
    public void init(ServletConfig config) throws ServletException {
        gruposDAW = new ArrayList<String>();
        gruposDAW.add("2daw_a");
        gruposDAW.add("2daw_b");
           
    }
      

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String grupoSeleccionado = "2daw_a";
        List<Alumnos> gruposAB;
        if (request.getParameter("grupo") != null) {
            grupoSeleccionado = request.getParameter("grupo");
        }
        request.setAttribute("grupos", gruposDAW);
        request.setAttribute("grupo", grupoSeleccionado);
       
        gruposAB= Utilidades.getAlumnosBD(grupoSeleccionado);
       
        request.setAttribute("grupoSeleccionado", gruposAB);
        request.getRequestDispatcher("alumnos.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String alumnosSeleccionados[] = request.getParameterValues("alumno");
        List<Alumnos> arrayalumSelec =  new ArrayList<Alumnos>();
        for(int i = 0;i<alumnosSeleccionados.length;i++){
            String[] al = alumnosSeleccionados[i].split(",");
            Alumnos alumno = new Alumnos(Integer.parseInt(al[0]),al[1],al[2],al[3],al[4]);
            arrayalumSelec.add(alumno);
        }
        request.setAttribute("alumnos",arrayalumSelec);
        request.getRequestDispatcher("alumnosseleccionados.jsp").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
