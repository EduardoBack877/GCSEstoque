package apoio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fabricio.pretto
 */
import java.sql.*;
import java.io.*;
import java.util.*;

public class ConexaoBD {

    private static ConexaoBD instancia = null;
    private Connection conexao = null;

    public ConexaoBD() {
        
        String currentDirectory = System.getProperty("user.dir");
        String dburl;
        
        try {
            // Carrega informações do arquivo de propriedades
            Properties prop = new Properties();
            //prop.load(new FileInputStream("C:\\Users\\Eduardo Back\\Documents\\NetBeansProjects\\RecDesp\\db.properties"));
            String dbdriver = "org.postgresql.Driver";//prop.getProperty("db.driver");
//      INTEGRACAO
        if (currentDirectory.equals("/root/.jenkins/workspace/estoque_integracao")) {
            dburl = "jdbc:postgresql://172.17.0.3:5432/GCSEstoque";

//      HOMOLOGACAO
        } else if (currentDirectory.equals("/root/.jenkins/workspace/estoque_homologacao")) {
            dburl = "jdbc:postgresql://172.17.0.4:5432/GCSEstoque";

//      PRODUCAO
        } else if (currentDirectory.equals("/root/.jenkins/workspace/estoque_producao")) {
            dburl = "jdbc:postgresql://172.17.0.5:5432/GCSEstoque";

//      MAQUINA LOCAL
        } else {
            dburl = "jdbc:postgresql://localhost:5432/GCSEstoque";
        }

        String dbuser = "postgres";//prop.getProperty("db.user");
            String dbsenha = "postgres";

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            if (dbuser.length() != 0) // conexão COM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else // conexão SEM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Retorna instância
    public static ConexaoBD getInstance() {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    // Retorna conexão
    public Connection getConnection() {
        if (conexao == null) {
            throw new RuntimeException("conexao==null");
        }
        return conexao;
    }

    // Efetua fechamento da conexão
    public void shutDown() {
        try {
            conexao.close();
            instancia = null;
            conexao = null;
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}