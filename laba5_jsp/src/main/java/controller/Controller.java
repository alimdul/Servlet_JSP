package controller;

import command.ActionFactory;
import command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

import static controller.Router.RouteType.FORWARD;

@WebServlet("/controller")
public class Controller extends HttpServlet {

    private static final String PARAMETER_COMMAND = "command";
    private static final String ATTRIBUTE_NULL_PAGE = "nullPage";
    private static final String MESSAGE_ERROR = "message.nullpage";
    private static final String PATH_INDEX_PAGE = "path.page.index";
    private static final String PATH_PROPERTY_CONFIG = "property.config";
    private static final String PATH_PROPERTY_MESSAGE = "property.messages";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = ActionFactory.defineCommand(request.getParameter(PARAMETER_COMMAND));
        Router router = command.execute(request);

        if (router != null) {
            if(FORWARD.equals(router.getRoute())) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(router.getPagePath());
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect(router.getPagePath());
            }
        } else {
            ResourceBundle messageResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_MESSAGE);
            request.getSession().setAttribute(ATTRIBUTE_NULL_PAGE, messageResourceBundle.getString(MESSAGE_ERROR));
            ResourceBundle configResourceBundle = ResourceBundle.getBundle(PATH_PROPERTY_CONFIG);
            response.sendRedirect(request.getContextPath() + configResourceBundle.getString(PATH_INDEX_PAGE));
        }
    }
}
