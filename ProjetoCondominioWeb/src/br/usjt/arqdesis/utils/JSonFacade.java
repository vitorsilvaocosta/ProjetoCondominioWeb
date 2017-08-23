package br.usjt.arqdesis.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import br.usjt.arqdesis.model.Usuario;
import br.usjt.arqdesis.model.Empresa;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonFacade {
	
	public static StringBuilder montaJSon(HttpServletRequest request)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		return sb;
	}

	public static String listToJSon(ArrayList<Usuario> lista) {
		JSONArray vetor = new JSONArray();
		for (Usuario to : lista) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", to.getId());
				object.put("cpf", to.getId());
				object.put("nome", to.getNome());
				object.put("email", to.getEmail());
				object.put("telefone", to.getTelefone());
				object.put("empresa", to.getEmpresa());
				object.put("login", to.getUsername());
				object.put("senha", to.getPassword());
				vetor.put(object);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return vetor.toString();
	}

	public static Usuario jSonToCliente(String json) throws IOException{
		try{
			JSONObject registro = new JSONObject(json);
			int id = registro.getInt("id");
			String cpf = registro.getString("cpf");
			String nome = registro.getString("nome");
			String email = registro.getString("email");
			String telefone = registro.getString("telefone");
			String empresa = registro.getString("empresa");
			String login = registro.getString("login");
			String senha = registro.getString("senha");
			Usuario usuario = new Usuario();
			usuario.setId(id);
			usuario.setCpf(cpf);
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setTelefone(telefone);
			usuario.setEmpresa(empresa);
			usuario.setUsername(login);
			usuario.setPassword(senha);

			return usuario;
		} catch(JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}
	
	public static String clienteToJSon(Usuario usuario) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("id", usuario.getId());
			object.put("cpf", usuario.getCpf());
			object.put("nome", usuario.getNome());
			object.put("email", usuario.getEmail());
			object.put("telefone", usuario.getTelefone());
			object.put("empresa", usuario.getEmpresa());
			object.put("login", usuario.getUsername());
			object.put("senha", usuario.getPassword());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}

	public static String errorToJSon(Exception e) {
		JSONObject object = new JSONObject();
		try {
			object.put("error", e.toString());
		} catch (JSONException e1) {
			e.printStackTrace();
		}
		return object.toString();
	}
	
	
	//JSON para Empresa
	public static String listToJSonEmpresa(ArrayList<Empresa> lista) {
		JSONArray vetor = new JSONArray();
		for (Empresa to : lista) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", to.getId());
				object.put("cnpj", to.getCnpj());
				object.put("razaoSocial", to.getRazaoSocial());
				object.put("horarioEmpresa", to.getHorarioEmpresa());
				object.put("temperaturaAr", to.getTemperaturaArCondicionado());
				object.put("horarioAr", to.getHorarioArCondicionado());
				vetor.put(object);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return vetor.toString();
	}
	public static Empresa jSonToEmpresa(String json) throws IOException{
		try{
			JSONObject registro = new JSONObject(json);
			int id = registro.getInt("id");
			String cnpj = registro.getString("cnpj");
			String razaoSocial = registro.getString("razaoSocial");
			String horarioEmpresa = registro.getString("horarioEmpresa");
			double temperaturaAr = registro.getDouble("temperaturaAr");
			String horarioAr = registro.getString("horarioAr");

			Empresa empresa = new Empresa();
			empresa.setId(id);
			empresa.setCnpj(cnpj);
			empresa.setRazaoSocial(razaoSocial);
			empresa.setHorarioEmpresa(horarioEmpresa);
			empresa.setTemperaturaArCondicionado(temperaturaAr);
			empresa.setHorarioArCondicionado(horarioAr);
		

			return empresa;
		} catch(JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}
	
	public static String EmpresaToJSon(Empresa empresa) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("id", empresa.getId());
			object.put("cnpj", empresa.getCnpj());
			object.put("razaoSocial", empresa.getRazaoSocial());
			object.put("horarioEmpresa", empresa.getHorarioEmpresa());
			object.put("temperaturaAr", empresa.getTemperaturaArCondicionado());
			object.put("horarioAr", empresa.getHorarioArCondicionado());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}
}
