package controller;

import model.dao.ServicosDAO;
import model.dao.Servicos;
import java.util.ArrayList;

public class buscaServico {

    private ServicosDAO servicosDAO;

    public buscaServico(String database) {
        this.servicosDAO = new ServicosDAO(database);
    }

    public ArrayList<Servicos> buscar(String termo, String tabela) {
        return servicosDAO.buscarServicos(termo, tabela);
    }
}
