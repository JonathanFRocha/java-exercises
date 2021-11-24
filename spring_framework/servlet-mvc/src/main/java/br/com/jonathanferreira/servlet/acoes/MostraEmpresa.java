package br.com.jonathanferreira.servlet.acoes;

import br.com.jonathanferreira.servlet.modelo.Banco;
import br.com.jonathanferreira.servlet.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MostraEmpresa {
    public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();

        Empresa empresa = banco.buscaEmpresaPelaId(id);

        System.out.println(empresa.getNome());

        req.setAttribute("empresa", empresa);

        return "forward:/formAlteraEmpresa.jsp";
    }
}
