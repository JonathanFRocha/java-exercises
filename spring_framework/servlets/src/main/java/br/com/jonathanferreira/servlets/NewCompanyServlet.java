package br.com.jonathanferreira.servlets;


import br.com.jonathanferreira.servlets.entities.Company;
import br.com.jonathanferreira.servlets.repository.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/new-company")
public class NewCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Registered new company.");
        String companyName = req.getParameter("name");

        Company company = new Company();
        company.setName(companyName);

        Database database = new Database();
        database.save(company);

        RequestDispatcher rd = req.getRequestDispatcher("/new-company-created.jsp");
        req.setAttribute("company", company.getName());
        rd.forward(req, resp);
    }
}
