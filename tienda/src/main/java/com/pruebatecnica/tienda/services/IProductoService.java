package com.pruebatecnica.tienda.services;

import com.pruebatecnica.tienda.dto.ProductoDTO;
import com.pruebatecnica.tienda.excepciones.ProductoNoEncontradoException;

import java.util.List;

public interface IProductoService {

    ProductoDTO crearProducto(ProductoDTO productoDTO);

    ProductoDTO obtenerProductoPorId(Long id) throws ProductoNoEncontradoException;

    List<ProductoDTO> obtenerTodosLosProductos();

    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) throws ProductoNoEncontradoException;

    void eliminarProducto(Long id) throws ProductoNoEncontradoException;
}
