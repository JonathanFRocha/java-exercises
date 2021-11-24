package br.com.jonathanferreira.servlet.controller;

import br.com.jonathanferreira.servlet.acoes.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String paramAcao = req.getParameter("acao");

        String jsp = null;
        switch (paramAcao) {
            case "ListaEmpresas":
                System.out.println("Listando Empresa");
                ListaEmpresas listaEMpresa = new ListaEmpresas();
                jsp = listaEMpresa.executa(req, res);
                break;
            case "RemoveEmpresa":
                System.out.println("Listando Empresa");
                RemoveEmpresa RemoveEmpresa = new RemoveEmpresa();
                jsp = RemoveEmpresa.executa(req, res);
                break;
            case "MostraEmpresa":
                System.out.println("Mostrando Empresas");
                MostraEmpresa mostraEmpresa = new MostraEmpresa();
                jsp = mostraEmpresa.executa(req, res);
                break;
            case "AlteraEmpresa":
                System.out.println("Alterando Empresa");
                AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
                jsp = alteraEmpresa.executa(req, res);
                break;
            case "NovaEmpresa":
                System.out.println("Alterando Empresa");
                NovaEmpresa novaEmpresa = new NovaEmpresa();
                jsp = novaEmpresa.executa(req, res);
                break;
        }
        String[] tipoEEndereco = jsp.split(":");
        if(tipoEEndereco[0].equals("foward")){
            RequestDispatcher rd = req.getRequestDispatcher(tipoEEndereco[1]);
            rd.forward(req, res);
        }else {
            res.sendRedirect(tipoEEndereco[1]);
        }


    }
}
