package br.usjt.arqdesis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.arqdesis.model.Empresa;

public class EmpresaDAO {

	
	//
	public int criar(Empresa empresa) {
		String sqlInsert = "INSERT INTO company(cnpj, razaoSocial, horarioEmpresa, temperaturaAr, horarioAr) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, empresa.getCnpj());
			stm.setString(2, empresa.getRazaoSocial());
			stm.setString(3, empresa.getHorarioEmpresa());
			stm.setDouble(4, empresa.getTemperaturaArCondicionado());
			stm.setString(5, empresa.getHorarioArCondicionado());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					empresa.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresa.getId();
	}
	
	//
	public void atualizar(Empresa empresa) {
		String sqlUpdate = "UPDATE company SET razaoSocial=?, horarioEmpresa=?, temperaturaAr=?, horarioAr=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, empresa.getRazaoSocial());
			stm.setString(2, empresa.getHorarioEmpresa());
			stm.setDouble(3, empresa.getTemperaturaArCondicionado());
			stm.setString(4, empresa.getHorarioArCondicionado());
			stm.setInt(5, empresa.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void atualizarPorCnpj(Empresa empresa) {
		String sqlUpdate = "UPDATE company SET razaoSocial=?, horarioEmpresa=?, temperaturaAr=?, horarioAr=? WHERE cnpj=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, empresa.getRazaoSocial());
			stm.setString(2, empresa.getHorarioEmpresa());
			stm.setDouble(3, empresa.getTemperaturaArCondicionado());
			stm.setString(4, empresa.getHorarioArCondicionado());
			stm.setString(5, empresa.getCnpj());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM company WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void excluirPorCnpj(String cnpj) {
		String sqlDelete = "DELETE FROM company WHERE cnpj = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, cnpj);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//
	public Empresa carregar(int id) {
		Empresa empresa = new Empresa();
		empresa.setId(id);
		String sqlSelect = "SELECT cnpj, razaoSocial, horarioEmpresa, temperaturaAr, horarioAr FROM company WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, empresa.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setHorarioEmpresa(rs.getString("horarioEmpresa"));
					empresa.setTemperaturaArCondicionado(rs.getDouble("temperaturaAr"));
					empresa.setHorarioArCondicionado(rs.getString("horarioAr"));
				} else {
					empresa.setId(-1);
					empresa.setCnpj(null);
					empresa.setRazaoSocial(null);
					empresa.setHorarioEmpresa(null);
					empresa.setTemperaturaArCondicionado(Double.NaN);
					empresa.setHorarioArCondicionado(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return empresa;
	}
	public Empresa carregarPorCnpj(String cnpj) {
		Empresa empresa = new Empresa();
		empresa.setCnpj(cnpj);
		String sqlSelect = "SELECT cnpj, razaoSocial, horarioEmpresa, temperaturaAr, horarioAr FROM company WHERE cnpj = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, empresa.getCnpj());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setHorarioEmpresa(rs.getString("horarioEmpresa"));
					empresa.setTemperaturaArCondicionado(rs.getDouble("temperaturaAr"));
					empresa.setHorarioArCondicionado(rs.getString("horarioAr"));
				} else {
					empresa.setId(-1);
					empresa.setCnpj(null);
					empresa.setRazaoSocial(null);
					empresa.setHorarioEmpresa(null);
					empresa.setTemperaturaArCondicionado(Double.NaN);
					empresa.setHorarioArCondicionado(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return empresa;
	}
	//
	//
	public List<Empresa> carregarTodasEmpresas() {
		Empresa empresa;
		
		List<Empresa> lista = new ArrayList<Empresa>();
		
		String sqlSelect = "SELECT cnpj, razaoSocial, horarioEmpresa, temperaturaAr, horarioAr FROM company;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					
					empresa = new Empresa();
					
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setHorarioEmpresa(rs.getString("horarioEmpresa"));
					empresa.setTemperaturaArCondicionado(rs.getDouble("temperaturaAr"));
					empresa.setHorarioArCondicionado(rs.getString("horarioAr"));
					
					lista.add(empresa);
					
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	/////
	public ArrayList<Empresa> listarEmpresas(String chave) {
		Empresa empresa;
		ArrayList<Empresa> lista = new ArrayList<>();
		String sqlSelect = "SELECT cnpj, razaoSocial, horarioEmpresa, temperaturaAr, horarioAr FROM company where upper(nome) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					empresa = new Empresa();
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setHorarioEmpresa(rs.getString("horarioEmpresa"));
					empresa.setTemperaturaArCondicionado(rs.getDouble("temperaturaAr"));
					empresa.setHorarioArCondicionado(rs.getString("horarioAr"));
					lista.add(empresa);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	///
	public ArrayList<Empresa> listarEmpresas() {
		Empresa empresa;
		ArrayList<Empresa> lista = new ArrayList<>();
		String sqlSelect = "SELECT cnpj, razaoSocial, horarioEmpresa, temperaturaAr, horarioAr FROM company";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					empresa = new Empresa();
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setHorarioEmpresa(rs.getString("horarioEmpresa"));
					empresa.setTemperaturaArCondicionado(rs.getDouble("temperaturaAr"));
					empresa.setHorarioArCondicionado(rs.getString("horarioAr"));
					lista.add(empresa);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
}
