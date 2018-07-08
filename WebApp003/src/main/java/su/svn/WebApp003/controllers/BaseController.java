package su.svn.WebApp003.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import su.svn.WebApp003.models.UserDAO;
import su.svn.WebApp003.models.UserDataSet;

@Controller
public class BaseController {

    private static final String VIEW_INDEX = "index";
    private final static Logger logger =  LogManager.getLogger(BaseController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        // UserDataSet user = userDAO.get(1);

        String message = "Welcome";

        model.addAttribute("message", message);
        logger.info("[welcome]");

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {

        model.addAttribute("message", "Welcome " + name);
        logger.info("[welcomeName] name: {}", name);
        return VIEW_INDEX;
    }
}
