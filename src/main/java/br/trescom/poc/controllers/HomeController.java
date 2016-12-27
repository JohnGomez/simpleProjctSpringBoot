package br.trescom.poc.controllers;

import br.trescom.poc.models.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import br.trescom.poc.daos.ProductRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/produto")
public class HomeController {

    @Autowired
    ProductRepository produtoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody  List<Product> getAllProduct() {
        return (List) produtoRepository.findAll();
    }
    
    @RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProdutByName(@PathVariable("nome") String nome) {
        return (List) produtoRepository.findByName(nome);
    }
    
    

}
