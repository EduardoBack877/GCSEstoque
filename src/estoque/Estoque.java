/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;
import apoio.ConexaoBD;
import dao.GrupoProdDAO;
import java.sql.Statement;
import tela.Login;
import tela.MainWindow;

/**
 *
 * @author dudub
 */
public class Estoque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new Login(null, true).setVisible(true);
        System.out.println("testando novamente - ALTERADO");
        GrupoProdDAO gDAO = new GrupoProdDAO();
        System.out.println(gDAO.consultarId(1).getDescricao());
        
        
        
        
    }
    
}
