package com.openclassrooms.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe abstraite - code redondant des servlets
 * @author fabienrecco <fabien.recco@gmail.com>
 *
 */
public abstract class AbstractCommonServlet extends HttpServlet {
    
    private static final long serialVersionUID = 5341806232433303776L;
    

    // Constants
    //--------------------------------------------------
    
    private final static String folder = "pages";

    
    // Actions
    //--------------------------------------------------
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        renderView(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)    throws ServletException, IOException {
        renderView(req, resp);
    }
    
    
    // Private methods
    //--------------------------------------------------
    
    /**
     * Définit la vue à appeler
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void renderView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewName = computeViewName();
        getServletContext().getRequestDispatcher("/WEB-INF/" + folder + "/" + viewName + ".jsp").forward(request, response);
    }
    
    /**
     * Calcul du nom de la JSP à appeler
     * @return
     */
    private String computeViewName() {
        String className = this.getClass().getSimpleName().toLowerCase();
        return className.replaceAll("servlet", "");
    }
    

}
