/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.info.dal;

import java.sql.*;

/**
 *
 * @author marcioc
 */
public class ModuloConexao {

    //método responsavel por estabelecer a conexão com banco
    public static Connection conector() {
        java.sql.Connection conexao = null;
        //Chama o driver que foi importado para biblioteca
        String driver = "com.mysql.jdbc.Driver";
        //Armazenando informações referente ao banco
        //o ?autoReconnect=true&useSSL=false servira para tirar o aviso de userSSl
        String url = "jdbc:mysql://localhost:3306/db_info?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "@#$toor_";
        //Estabelecendo a conexão com banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //a linha abaixo serve de apoio para esclarecer o erro
            //System.out.println(e);
            return null;
        }
    }
}
