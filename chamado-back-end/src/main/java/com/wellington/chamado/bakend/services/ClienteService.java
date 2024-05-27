package com.wellington.chamado.bakend.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellington.chamado.bakend.dto.CargoDTO;
import com.wellington.chamado.bakend.dto.ChamadoDTO;
import com.wellington.chamado.bakend.dto.ClienteDTO;
import com.wellington.chamado.bakend.dto.ClienteInsertDTO;
import com.wellington.chamado.bakend.entity.Cargo;
import com.wellington.chamado.bakend.entity.Chamado;
import com.wellington.chamado.bakend.entity.Cliente;
import com.wellington.chamado.bakend.entity.enums.StatusChamado;
import com.wellington.chamado.bakend.exceptions.DataIntegratyViolationException;
import com.wellington.chamado.bakend.exceptions.ObjectNotFoundException;
import com.wellington.chamado.bakend.repository.CargoRepository;
import com.wellington.chamado.bakend.repository.ChamadoRepository;
import com.wellington.chamado.bakend.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public ClienteDTO findById(UUID id) {
		Optional<Cliente> cli = repository.findById(id);
		Cliente entity = cli.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO create(ClienteInsertDTO clienteDTO) {
		Cliente entity = new Cliente();
		entity.setNome(clienteDTO.getNome());
		verificarEmailExistente(clienteDTO);
		entity.setEmail(clienteDTO.getEmail());
		atribuirCargo(entity, clienteDTO);
		entity.setSenha(passwordEncoder.encode(clienteDTO.getSenha()));
		repository.save(entity);
		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO updateEmail(ClienteDTO clienteDTO, UUID id) {
		Cliente entity = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
		verificarEmailExistente(clienteDTO);
		entity.setEmail(clienteDTO.getEmail());
		repository.save(entity);
		return new ClienteDTO(entity);
	}
	
	public ChamadoDTO buscarChamado(Long id) {
		Optional<Chamado> chamado = chamadoRepository.findById(id);
		Chamado entity = chamado.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado"));
		return new ChamadoDTO(entity);
	}

	@Transactional
	public ChamadoDTO criarChamado(ChamadoDTO chamadoDTO, UUID id) {
		Cliente cliente = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
		Chamado chamado = new Chamado();
		chamado.setCliente(cliente);
		chamado.setDataAberto(LocalDateTime.now());
		chamado.setDescricao(chamadoDTO.getDescricao());
		chamado.setStatusChamado(StatusChamado.ABERTO);
		chamadoRepository.save(chamado);
		return new ChamadoDTO(chamado);
	}
	
	public List<ChamadoDTO> findAllMeuChamados(String nome){
		List<Chamado> chamados = chamadoRepository.findAll()
				.stream().filter(x -> x.getCliente().getNome().equals(nome))
				.collect(Collectors.toList());
		return chamados.stream().map(ChamadoDTO::new).collect(Collectors.toList());
	}

	protected void atribuirCargo(Cliente cli, ClienteDTO clienteDTO) {
		cli.getCargos().clear();
		for (CargoDTO car : clienteDTO.getCargos()) {
			Cargo cargo = cargoRepository.findById(car.getId()).orElseThrow(() -> new ObjectNotFoundException("Cargo não encontrado"));
			cli.getCargos().add(cargo);

		}
	}

	protected void verificarEmailExistente(ClienteDTO clienteDTO) {
		Optional<Cliente> entity = repository.findByEmail(clienteDTO.getEmail());
		if (entity.isPresent() && !entity.get().getId().equals(clienteDTO.getId())) {
			throw new DataIntegratyViolationException("Email já existe");
		}
	}
}
