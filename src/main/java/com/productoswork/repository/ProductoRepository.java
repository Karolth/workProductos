package com.productoswork.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.productoswork.model.Producto;



public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
