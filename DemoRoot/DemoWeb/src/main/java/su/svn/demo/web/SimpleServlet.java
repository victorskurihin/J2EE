package su.svn.demo.web;

import su.svn.demo.persistent.ConfigDAO;
import su.svn.demo.persistent.ConfigDataSet;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Stateless
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = -4751096228274971485L;

    @EJB
    private ConfigDAO configDAO;

    @Override
    protected void doGet(HttpServletRequest reqest, HttpServletResponse response)
        throws ServletException, IOException {

        String configString = "configDAO is null";

        if (configDAO != null) {
            List<ConfigDataSet> config = configDAO.getAll();
            configString = config != null ? config.toString() : "config is null";
        }

        response.getWriter().println("Config: " + configString);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}
