package com.pruebatecnica.tienda.services;

import com.pruebatecnica.tienda.dto.ClienteDTO;
import com.pruebatecnica.tienda.excepciones.ClienteNoEncontradoException;
import com.pruebatecnica.tienda.mappers.ClienteMapper;
import com.pruebatecnica.tienda.models.ClienteModel;
import com.pruebatecnica.tienda.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService implements IClienteService{

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        ClienteModel clienteModel = clienteMapper.toEntity(clienteDTO);
        ClienteModel clienteGuardado = clienteRepository.save(clienteModel);
        return clienteMapper.toDto(clienteGuardado);
    }

    public ClienteDTO obtenerClientePorId(Long id) throws ClienteNoEncontradoException {
        Optional<ClienteModel> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isPresent()) {
            return clienteMapper.toDto(clienteOpt.get());
        } else {
            throw new ClienteNoEncontradoException("el cleinte con Id: " + id+" no se encuentra");
        }
    }

    public List<ClienteDTO> obtenerTodosLosClientes() {
        List<ClienteModel> clientes = clienteRepository.findAll();
        return clienteMapper.toDtoList(clientes);
    }

    public ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO) throws ClienteNoEncontradoException {
        Optional<ClienteModel> clienteOpt = clienteRepository.findById(id);
        if (clienteOpt.isPresent()) {
            ClienteModel clienteModel = clienteOpt.get();
            clienteModel.setNombreCliente(clienteDTO.getNombreCliente());
            clienteModel.setApellidoCliente(clienteDTO.getApellidoCliente());
            clienteModel.setEmail(clienteDTO.getEmail());
            clienteModel.setTelefono(clienteDTO.getTelefono());
            ClienteModel clienteActualizado = clienteRepository.save(clienteModel);
            return clienteMapper.toDto(clienteActualizado);
        } else {
            throw new ClienteNoEncontradoException("Cliente no encontrado");
        }
    }

    public void eliminarCliente(Long id) throws ClienteNoEncontradoException {
        if (!clienteRepository.existsById(id)) {
            throw new ClienteNoEncontradoException("Cliente no existe");
        }
        clienteRepository.deleteById(id);
    }
}


