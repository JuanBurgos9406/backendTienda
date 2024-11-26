package com.pruebatecnica.tienda.services;

import com.pruebatecnica.tienda.dto.ClienteDTO;
import com.pruebatecnica.tienda.excepciones.ClienteNoEncontradoException;

import java.util.List;

public interface IClienteService {

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    ClienteDTO obtenerClientePorId(Long id) throws ClienteNoEncontradoException;

    List<ClienteDTO> obtenerTodosLosClientes();

    ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO) throws ClienteNoEncontradoException;

    void eliminarCliente(Long id) throws ClienteNoEncontradoException;
}
