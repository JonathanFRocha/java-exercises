package br.com.jonathanferreira.servlet.acoes;

import br.com.jonathanferreira.servlet.modelo.Banco;
import br.com.jonathanferreira.servlet.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaEmpresas {

    public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        req.setAttribute("empresas", lista);

        return "forward:listaEmpresas.jsp";
    }
}
