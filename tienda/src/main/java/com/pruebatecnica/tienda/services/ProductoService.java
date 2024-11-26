package com.pruebatecnica.tienda.services;

import com.pruebatecnica.tienda.dto.ProductoDTO;
import com.pruebatecnica.tienda.excepciones.ProductoNoEncontradoException;
import com.pruebatecnica.tienda.mappers.ProductoMapper;
import com.pruebatecnica.tienda.models.ProductoModel;
import com.pruebatecnica.tienda.repositories.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoService implements IProductoService{

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;
    @Autowired
    public ProductoService(ProductoRepository productoRepository,
                           ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        ProductoModel productoModel = productoMapper.toEntity(productoDTO);
        ProductoModel productoGuardado = productoRepository.save(productoModel);
        return productoMapper.toDto(productoGuardado);
    }

    public ProductoDTO obtenerProductoPorId(Long id) throws ProductoNoEncontradoException {
        Optional<ProductoModel> productoOpt = productoRepository.findById(id);
        if (productoOpt.isPresent()) {
            return productoMapper.toDto(productoOpt.get());
        }
        throw new ProductoNoEncontradoException("El producto buscado no existe");
    }

    public List<ProductoDTO> obtenerTodosLosProductos() {
        List<ProductoModel> productos = productoRepository.findAll();
        return productoMapper.toDtoList(productos);
    }

    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) throws ProductoNoEncontradoException {
        Optional<ProductoModel> productoOpt = productoRepository.findById(id);
        if (productoOpt.isPresent()) {
            ProductoModel productoModel = productoOpt.get();
            productoModel.setNombre(productoDTO.getNombre());
            productoModel.setDescripcion(productoDTO.getDescripcion());
            productoModel.setPrecio(productoDTO.getPrecio());
            productoModel.setCantidadDisponible(productoDTO.getCantidadDisponible());
            productoModel.setFoto(productoDTO.getFoto());
            ProductoModel productoActualizado = productoRepository.save(productoModel);
            return productoMapper.toDto(productoActualizado);
        } else {
            throw new ProductoNoEncontradoException("Producto no encontrado");
        }
    }

    public void eliminarProducto(Long id) throws ProductoNoEncontradoException {
        if (!productoRepository.existsById(id)) {
            throw new ProductoNoEncontradoException("El producto no existe");
        }
        productoRepository.deleteById(id);
    }


}
