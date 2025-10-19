package com.productoswork.service;

import java.util.List;
import java.util.Optional;

import com.productoswork.model.Producto;



public interface IProductoService {

	public Producto save(Producto producto);

	public Optional<Producto> get(Integer id);

	public void update(Producto producto);

	public void delete(Integer id);

	Optional<Producto> findById(Integer id);

	List<Producto> findAll();
}
