package com.bolsadeideas.springboot.app.dao;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

//Ahora se trabajara con paginacion la siguiente clase que estamos heredadndo
//tambien hereda de CrudRepository asi que tendremos todos los metodos de
// del CRUD ademas de las paginacion
public interface IClienteDao extends PagingAndSortingRepository<Cliente,Long > {

    @Query("select c from Cliente c left join fetch c.facturas f where c.id=?1")
    public Cliente fetchByIdWhithFacturas(Long id);
    //Aqui en el cuerpo se pueden tener otros metodos que no esten en el CRUD
}









//Esta interface la convertiremos en nuestro CRUD repository
//Ya no es necesario ponerle anotaciones java ya que es una clase propia de spring
//public interface IClienteDao extends CrudRepository<Cliente,Long > {


