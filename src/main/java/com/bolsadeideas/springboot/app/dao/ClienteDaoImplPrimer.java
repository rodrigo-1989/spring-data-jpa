///OOOOOOOJOO aqui esta el CRUD completo

package com.bolsadeideas.springboot.app.dao;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
//Esta es  mi clase Dao que me permite la persistencia de los datos "permite acceso
// a los datos de la base de datos"
//La siguiente anotacion se encarga de traducir correctamente las excepciones que puedan ocurrir
@Repository()
//en la siguiente anotacion se espeficica que se debe usar este componente
//@Repository("clienteDaoJPA")
public class ClienteDaoImplPrimer implements IClienteDaoPrimero {
// El entity manager se encarga de manejar las clases entity el ciclo de vida persistir
// hacer consultas todo lo relacionado con las operaciones a la base de datos
    //las consultas son de tipo JPA van a las entitys no alas tablas

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    public void save(Cliente cliente){
        //Primero verificamos si el id, si es null se crea con el persist y si no es null
        // se modifica con el merge
        if (cliente.getId()!=null && cliente.getId()>0)
            em.merge(cliente);
        else
            em.persist(cliente);
    }

    //El siguiente metodo es para buscar un cliente en la tablas
    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class,id);
    }

    @Override
    public void eliminar(Long id) {
        //primero buscaremos que cliente hay que eliminar con el metodo findOne
        //luego se elimina con el metodo remove
        Cliente cliente = findOne(id);
        em.remove(cliente);
    }


}
