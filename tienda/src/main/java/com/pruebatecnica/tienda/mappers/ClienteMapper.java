package com.pruebatecnica.tienda.mappers;

import com.pruebatecnica.tienda.dto.ClienteDTO;
import com.pruebatecnica.tienda.models.ClienteModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ClienteMapper {    // Convierte ClienteModel a ClienteDTO


    // Convierte ClienteModel a ClienteDTO
    public ClienteDTO toDto(ClienteModel clienteModel) {
        if (clienteModel == null) {
            return null;
        }

        // Mapeo de atributos de ClienteModel a ClienteDTO
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(clienteModel.getIdCliente());
        clienteDTO.setNombreCliente(clienteModel.getNombreCliente());
        clienteDTO.setApellidoCliente(clienteModel.getApellidoCliente());
        clienteDTO.setEmail(clienteModel.getEmail());
        clienteDTO.setTelefono(clienteModel.getTelefono());

        return clienteDTO;
    }

    // Convierte ClienteDTO a ClienteModel
    public ClienteModel toEntity(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            return null;
        }

        // Mapeo de atributos de ClienteDTO a ClienteModel
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setNombreCliente(clienteDTO.getNombreCliente());
        clienteModel.setApellidoCliente(clienteDTO.getApellidoCliente());
        clienteModel.setEmail(clienteDTO.getEmail());
        clienteModel.setTelefono(clienteDTO.getTelefono());

        return clienteModel;
    }
    public List<ClienteDTO> toDtoList(List<ClienteModel> clienteModels) {
        List<ClienteDTO> clienteDTOs = new ArrayList<>();
        for (ClienteModel clienteModel : clienteModels) {
            clienteDTOs.add(toDto(clienteModel));  // Mapeo individual de cada clienteModel a clienteDTO
        }
        return clienteDTOs;
    }
}
