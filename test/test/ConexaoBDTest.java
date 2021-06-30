/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import apoio.ConexaoBD;
import java.sql.Connection;
import java.sql.Statement;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class ConexaoBDTest {
    Connection conexao;
    @Test
    public void testGetConnection() throws Exception
    {
        conexao = ConexaoBD.getInstance().getConnection();
        assertTrue(conexao != null);
    }
}
