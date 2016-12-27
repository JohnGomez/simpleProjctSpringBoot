/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.trescom.poc.daos;

import br.trescom.poc.models.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author as
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByName(String name);

}
