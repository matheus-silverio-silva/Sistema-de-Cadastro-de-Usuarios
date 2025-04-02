package service;

import entidades.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {
	public void cadastrar(Usuario usuario) throws Exception {
		UsuarioRepository repository = new UsuarioRepository();

		if (usuario == null) {
			throw new Exception("Usuario invalido");
		} else if (usuario.getId() <= 0) {
			throw new Exception("Id do usuario invalido");
		} else if (usuario.getNome() == null) {
			throw new Exception("Nome do usuario invalido: nulo");
		} else if (usuario.getNome().trim().equals("")) {
			throw new Exception("Nome do usuario invalido: vazio");
		} else if (usuario.getNome().length() > 100) {
			throw new Exception("Nome do usuario invalido: tamanho excedido");
		} else if (usuario.getCpf() == null) {
			throw new Exception("Cpf do usuario invalido: nulo");
		} else if (usuario.getCpf().trim().equals("")) {
			throw new Exception("Cpf do usuario invalido: vazio");
		} else if (usuario.getCpf().length() != 11) {
			throw new Exception("Cpf do usuario invalido: deve ter 11 numeros");
		} else if (usuario.getIdade() < 0) {
			throw new Exception("Idade do usuario invalido: não pode ser negativa");
		} else if (usuario.getIdade() > 120) {
			throw new Exception("Idade do usuario invalido: tamanho excedido");
		}
		try {
			long cpf = Long.parseLong(usuario.getCpf());
			if (cpf <= 0) {
				throw new Exception("Cpf do usuario invalido: CPF negativo");
			}
		} catch (Exception e) {
			throw new Exception("Cpf do usuario invalido: deve ser numerico");
		}
		if (repository.consultarPorCpf(usuario.getCpf()) != null) {
			throw new Exception("Cpf do usuario já existe");
		}

		repository.inserir(usuario);
	}
	public void atualizar(Usuario usuario) throws Exception {
		UsuarioRepository repository = new UsuarioRepository();

		if (usuario == null) {
			throw new Exception("Usuario invalido");
		} else if (usuario.getId() <= 0) {
			throw new Exception("Id do usuario invalido");
		} else if (usuario.getNome() == null) {
			throw new Exception("Nome do usuario invalido: nulo");
		} else if (usuario.getNome().trim().equals("")) {
			throw new Exception("Nome do usuario invalido: vazio");
		} else if (usuario.getNome().length() > 100) {
			throw new Exception("Nome do usuario invalido: tamanho excedido");
		} else if (usuario.getCpf() == null) {
			throw new Exception("Cpf do usuario invalido: nulo");
		} else if (usuario.getCpf().trim().equals("")) {
			throw new Exception("Cpf do usuario invalido: vazio");
		} else if (usuario.getCpf().length() != 11) {
			throw new Exception("Cpf do usuario invalido: deve ter 11 numeros");
		} else if (usuario.getIdade() < 0) {
			throw new Exception("Idade do usuario invalido: não pode ser negativa");
		} else if (usuario.getIdade() > 120) {
			throw new Exception("Idade do usuario invalido: tamanho excedido");
		}
		try {
			long cpf = Long.parseLong(usuario.getCpf());
			if (cpf <= 0) {
				throw new Exception("Cpf do usuario invalido: CPF negativo");
			}
		} catch (Exception e) {
			throw new Exception("Cpf do usuario invalido: deve ser numerico");
		}

		if (repository.consultarPorCpf(usuario.getCpf()) != null) {
			throw new Exception("Cpf do usuario já existe");
		}
		repository.atualizar(usuario);
	}
}