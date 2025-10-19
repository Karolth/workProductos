import type { Producto } from '../types/producto';

const API_BASE = 'http://localhost:8080';

export const ProductoService = {
  async getAll(): Promise<Producto[]> {
    try {
      const res = await fetch(`${API_BASE}/productos/api`);
      if (!res.ok) throw new Error('Error al obtener productos');
      return await res.json();
    } catch (error) {
      console.error('Error:', error);
      return [];
    }
  },

  async getById(id: number): Promise<Producto | null> {
    try {
      const res = await fetch(`${API_BASE}/productos/api/${id}`);
      if (!res.ok) return null;
      return await res.json();
    } catch (error) {
      console.error('Error:', error);
      return null;
    }
  },

  async create(producto: Omit<Producto, 'idProductos'>): Promise<Producto | null> {
    try {
      const res = await fetch(`${API_BASE}/productos/api`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(producto)
      });
      if (!res.ok) throw new Error('Error al crear producto');
      return await res.json();
    } catch (error) {
      console.error('Error:', error);
      return null;
    }
  },

  async update(id: number, producto: Producto): Promise<Producto | null> {
    try {
      const res = await fetch(`${API_BASE}/productos/api/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(producto)
      });
      if (!res.ok) throw new Error('Error al actualizar producto');
      return await res.json();
    } catch (error) {
      console.error('Error:', error);
      return null;
    }
  },

  async delete(id: number): Promise<boolean> {
    try {
      const res = await fetch(`${API_BASE}/productos/api/${id}`, {
        method: 'DELETE'
      });
      return res.ok;
    } catch (error) {
      console.error('Error:', error);
      return false;
    }
  },

  async getSaludo(): Promise<string> {
    try {
      const res = await fetch(`${API_BASE}/api/saludo`);
      return await res.text();
    } catch (error) {
      console.error('Error:', error);
      return 'Error al conectar con el servidor';
    }
  }
};