package com.pruebatecnica.tienda.controllers;

import com.pruebatecnica.tienda.dto.ProductoDTO;
import com.pruebatecnica.tienda.excepciones.ProductoNoEncontradoException;
import com.pruebatecnica.tienda.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final IProductoService productoService;

    @Autowired
    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO productoDTO) {
        ProductoDTO productoCreado = productoService.crearProducto(productoDTO);
        return new ResponseEntity<>(productoCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable Long id) {
        try {
            ProductoDTO producto = productoService.obtenerProductoPorId(id);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (ProductoNoEncontradoException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerTodosLosProductos() {
        List<ProductoDTO> productos = productoService.obtenerTodosLosProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        try {
            ProductoDTO productoActualizado = productoService.actualizarProducto(id, productoDTO);
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } catch (ProductoNoEncontradoException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        try {
            productoService.eliminarProducto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ProductoNoEncontradoException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
