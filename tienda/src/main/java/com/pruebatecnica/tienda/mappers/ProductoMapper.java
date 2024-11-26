package com.pruebatecnica.tienda.mappers;

import com.pruebatecnica.tienda.dto.ProductoDTO;
import com.pruebatecnica.tienda.models.ProductoModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductoMapper {
    public ProductoDTO toDto(ProductoModel productoModel) {
        if (productoModel == null) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(productoModel.getId());
        productoDTO.setNombre(productoModel.getNombre());
        productoDTO.setDescripcion(productoModel.getDescripcion());
        productoDTO.setPrecio(productoModel.getPrecio());
        productoDTO.setCantidadDisponible(productoModel.getCantidadDisponible());
        productoDTO.setFoto(productoModel.getFoto());

        return productoDTO;
    }

    public ProductoModel toEntity(ProductoDTO productoDTO) {
        if (productoDTO == null) {
            return null;
        }

        ProductoModel productoModel = new ProductoModel();
        productoModel.setNombre(productoDTO.getNombre());
        productoModel.setDescripcion(productoDTO.getDescripcion());
        productoModel.setPrecio(productoDTO.getPrecio());
        productoModel.setCantidadDisponible(productoDTO.getCantidadDisponible());
        productoModel.setFoto(productoDTO.getFoto());

        return productoModel;
    }
    public List<ProductoDTO> toDtoList(List<ProductoModel> productoModels) {
        List<ProductoDTO> productoDTOs = new ArrayList<>();
        for (ProductoModel productoModel : productoModels) {
            productoDTOs.add(toDto(productoModel));
        }
        return productoDTOs;
    }
}
