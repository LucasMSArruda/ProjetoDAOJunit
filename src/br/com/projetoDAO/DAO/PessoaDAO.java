/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoDAO.DAO;

import br.com.projetoDAO.Conexao.Conexao;
import br.com.projetoDAO.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lucas.A
 */
public class PessoaDAO {

    PreparedStatement pst = null;
    Connection con = null;
    ResultSet rs = null;

    public boolean consultar() {

        String sql = "SELECT * FROM pessoa";

        con = Conexao.conectar();

        try {

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            System.out.printf("%-5s|%-50s|%-20s\n", "id", "nome", "profissao");

            while (rs.next()) {
                System.out.printf("%-5s|%-50s|%-20s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }

            return true;

        } catch (Exception e) {

            System.out.println("Não foi possível acessar os dados: " + e);

            return false;
        } finally {
            Conexao.desconectar(con);

        }
    }

    public boolean inserir(Pessoa p) {

        con = Conexao.conectar();

        String Sql = "INSERT INTO pessoa(nome,profissao) VALUES (?,?)";

        try {
            pst = con.prepareStatement(Sql);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getProfissao());
            pst.execute();
            System.out.println("Dados inseridos com sucesso.");

            return true;

        } catch (Exception e) {

            System.out.println("Erro: " + e);

            return false;
        } finally {
            Conexao.desconectar(con);
        }
    }

    public boolean consultaID(Pessoa p) {

        String sql = "SELECT * FROM pessoa WHERE id = ?";

        con = Conexao.conectar();

        try {

            pst = con.prepareStatement(sql);
            pst.setInt(1, p.getId());
            rs = pst.executeQuery();

            System.out.printf("%-5s|%-50s|%-20s\n", "id", "nome", "profissao");

            while (rs.next()) {
                System.out.printf("%-5s|%-50s|%-20s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }

            return true;

        } catch (Exception e) {

            System.out.println("Não foi possível acessar os dados: " + e);
            return false;

        } finally {
            Conexao.desconectar(con);

        }
    }

    public boolean atualizar(Pessoa p) {

        String sql = "UPDATE pessoa SET nome = ?, profissao = ? WHERE id = ?";

        con = Conexao.conectar();

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getProfissao());
            pst.setInt(3, p.getId());
            pst.executeUpdate();

            System.out.println("Dados Atualizados com sucesso.");

            return true;

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return false;
        } finally {
            Conexao.desconectar(con);
        }
    }

    public boolean remover(Pessoa p) {

        String sql = "DELETE FROM pessoa WHERE id = ?";

        con = Conexao.conectar();

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            int r = pst.executeUpdate();

            System.out.println("Remoção realizada com sucesso.");

            return true;

        } catch (Exception e) {

            System.out.println("Erro: " + e);
            return false;

        } finally {
            Conexao.desconectar(con);
        }
    }

}
