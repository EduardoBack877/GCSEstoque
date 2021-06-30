/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import apoio.ConexaoBD;
import dao.GrupoProdDAO;
import entidade.GrupoProduto;
import java.sql.Connection;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Back
 */
public class GrupoProdDAOTest {
    
    
    private static Connection conexao;
    private static GrupoProdDAO gDao;
    
    @BeforeClass
    public static void init() throws Exception
    {
        conexao = ConexaoBD.getInstance().getConnection();
        gDao = new GrupoProdDAO();
    }
    
    @Test
    public void testSalvar() throws Exception
    {
        GrupoProduto gProd = new GrupoProduto();
        gProd.setDescricao("MasculinoFeminino");
        assertTrue(gDao.salvar(gProd) != false);
    }
    

}
