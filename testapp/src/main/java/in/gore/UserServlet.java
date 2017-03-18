package in.gore;

import in.gore.entities.User;
import in.gore.models.Customer;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mihirgore on 19/10/16.
 */
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    private ISimpleSession session;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User u = session.getUser();
        if (u != null)
            resp.getOutputStream().write(u.getName().getBytes());
        else
            resp.getOutputStream().write("No Data".getBytes());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            long id = session.createUser();
            resp.getOutputStream().write("Success:".getBytes());
            resp.getOutputStream().write(new Long(id).intValue());

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

}
