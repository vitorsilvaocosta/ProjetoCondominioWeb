package br.usjt.arqdesis.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.arqdesis.dao.ConnectionFactory;
import br.usjt.arqdesis.model.Usuario;

public class UsuarioDAO {

	//
	public int criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO user(cpf, nome, email, telefone, empresa, login, senha) VALUES (?, ?, ?, ?, ? ,? ,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getCpf());
			stm.setString(2, usuario.getNome());
			stm.setString(3, usuario.getEmail());
			stm.setString(4, usuario.getTelefone());
			stm.setString(5, usuario.getEmpresa());
			stm.setString(6, usuario.getUsername());
			stm.setString(7, usuario.getPassword());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getId();
	}
	
	//
	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE user SET nome=?, email=?, telefone=?, empresa=?, login=?, senha=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getTelefone());
			stm.setString(4, usuario.getEmpresa());
			stm.setString(5, usuario.getUsername());
			stm.setString(6, usuario.getPassword());
			stm.setInt(7, usuario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void atualizarPorCpf(Usuario usuario) {
		String sqlUpdate = "UPDATE user SET nome=?, email=?, telefone=?, empresa=?, login=?, senha=? WHERE cpf=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getTelefone());
			stm.setString(4, usuario.getEmpresa());
			stm.setString(5, usuario.getUsername());
			stm.setString(6, usuario.getPassword());
			stm.setString(7, usuario.getCpf());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM user WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirPorCpf(String cpf) {
		String sqlDelete = "DELETE FROM user WHERE cpf = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, cpf);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		String sqlSelect = "SELECT nome, cpf, email, telefone, empresa, login, senha FROM user WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setCpf(rs.getString("cpf"));
					usuario.setEmail(rs.getString("email"));
					usuario.setTelefone(rs.getString("telefone"));
					usuario.setEmpresa(rs.getString("empresa"));
					usuario.setUsername(rs.getString("login"));
					usuario.setPassword(rs.getString("senha"));
				} else {
					usuario.setId(-1);
					usuario.setCpf(null);
					usuario.setNome(null);
					usuario.setEmail(null);
					usuario.setTelefone(null);
					usuario.setEmpresa(null);
					usuario.setUsername(null);
					usuario.setPassword(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}
	public Usuario carregarPorCpf(String cpf) {
		Usuario usuario = new Usuario();
		usuario.setCpf(cpf);
		String sqlSelect = "SELECT nome, cpf, email, telefone, empresa, login, senha FROM user WHERE cpf = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, usuario.getCpf());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setCpf(rs.getString("cpf"));
					usuario.setEmail(rs.getString("email"));
					usuario.setTelefone(rs.getString("telefone"));
					usuario.setEmpresa(rs.getString("empresa"));
					usuario.setUsername(rs.getString("login"));
					usuario.setPassword(rs.getString("senha"));
				} else {
					usuario.setId(-1);
					usuario.setCpf(null);
					usuario.setNome(null);
					usuario.setEmail(null);
					usuario.setTelefone(null);
					usuario.setEmpresa(null);
					usuario.setUsername(null);
					usuario.setPassword(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}
	//
	//
	public List<Usuario> carregarTodosUsuarios() {
		Usuario usuario;
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		String sqlSelect = "SELECT nome, cpf, email, telefone, empresa, login, senha FROM user;";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					
					usuario = new Usuario();
					
					usuario.setNome(rs.getString("nome"));
					usuario.setCpf(rs.getString("cpf"));
					usuario.setEmail(rs.getString("email"));
					usuario.setTelefone(rs.getString("telefone"));
					usuario.setEmpresa(rs.getString("empresa"));
					usuario.setUsername(rs.getString("login"));
					usuario.setPassword(rs.getString("senha"));
					
					lista.add(usuario);
					
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	//validar login
	public boolean validar(Usuario usuario) {
		String sqlSelect = "SELECT login, senha FROM user "
				+ "WHERE login = ? and senha = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, usuario.getUsername());
				stm.setString(2, usuario.getPassword());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}
	
	///arraylist
	public ArrayList<Usuario> listarUsuarios() throws IOException {
		Usuario to;
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, cpf, email, telefone, empresa, login, senha FROM user";

		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new Usuario();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setCpf(rs.getString("cpf"));
					to.setEmail(rs.getString("email"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmpresa(rs.getString("empresa"));
					to.setUsername(rs.getString("login"));
					to.setPassword(rs.getString("senha"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
			throw new IOException(e1);
		}
		return lista;
	}
	
	public ArrayList<Usuario> listarUsuarios(String chave) throws IOException {
		Usuario to;
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, cpf, email, telefone, empresa, login, senha FROM user where upper(nome) like ?";

		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					to = new Usuario();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setCpf(rs.getString("cpf"));
					to.setEmail(rs.getString("email"));
					to.setTelefone(rs.getString("telefone"));
					to.setEmpresa(rs.getString("empresa"));
					to.setUsername(rs.getString("login"));
					to.setPassword(rs.getString("senha"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
			throw new IOException(e1);
		}
		return lista;
	}
}
