package in.gore;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.gore.ISimpleSession;
import in.gore.models.Customer;

import javax.ejb.EJB;
import javax.inject.Inject;

public class HelloWorldServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    private ISimpleSession session;

    @Inject Customer customer;

    @Inject Test test;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (test != null) {
            resp.getOutputStream().write(session.getMessage().getBytes());
        } else {
            resp.getOutputStream().write("Customer not set".getBytes());
        }

    }
}