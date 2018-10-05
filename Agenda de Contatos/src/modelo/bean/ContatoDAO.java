package modelo.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conector.ConnectionFactory;

public class ContatoDAO {

	public static void insert(Contato contato) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("insert into contatos (nome, email, numero) values (?, ?, ?)");
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getNumero());
			
			stmt.executeUpdate();
			System.out.println("Salvou");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ContatoDAO");
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
			System.out.println("Fechou conexao");
		}
	}
	public static List<String> getList() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<>();
		try {
			stmt = con.prepareStatement("select nome from contatos ");
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("nome"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Falha em ContatoDAO");
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
			System.out.println("Fechou conexao");
		}
		return list;
	}
	
}
