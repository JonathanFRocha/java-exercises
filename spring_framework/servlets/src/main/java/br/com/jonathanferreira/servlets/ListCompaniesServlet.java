package br.com.jonathanferreira.servlets;

import br.com.jonathanferreira.servlets.entities.Company;
import br.com.jonathanferreira.servlets.repository.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/companies")
public class ListCompaniesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Listing Companies new company.");

        Database database = new Database();
        List<Company> companies = database.getCompanyList();

        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<ul>");
        for (Company company : companies) {
            out.println("<li>"+company.getName()+"</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
}
