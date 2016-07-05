package in.gore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.gore.ISimpleSession;
import javax.ejb.EJB;

public class HelloWorldServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    private ISimpleSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getOutputStream().write(session.getMessage().getBytes());
    }
}