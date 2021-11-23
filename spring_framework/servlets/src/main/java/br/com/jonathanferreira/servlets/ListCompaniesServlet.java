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
import java.util.List;

@WebServlet(urlPatterns = "/companies")
public class ListCompaniesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Listing Companies new company.");

        Database database = new Database();
        List<Company> companies = database.getCompanyList();
        req.setAttribute("companies", companies);
        RequestDispatcher rd = req.getRequestDispatcher("/companyList.jsp");
        rd.forward(req, resp);
    }
}
