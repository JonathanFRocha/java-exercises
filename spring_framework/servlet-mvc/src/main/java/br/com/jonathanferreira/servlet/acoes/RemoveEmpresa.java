package br.com.jonathanferreira.servlet.acoes;

import br.com.jonathanferreira.servlet.modelo.Banco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveEmpresa {

    public String executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        System.out.println(id);

        Banco banco = new Banco();
        banco.removeEmpresa(id);
        return "redirect:entrada?acao=ListaEmpresas";
    }
}
