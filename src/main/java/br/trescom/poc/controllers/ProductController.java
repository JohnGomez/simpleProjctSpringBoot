package br.trescom.poc.controllers;

import br.trescom.poc.models.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import br.trescom.poc.daos.ProductRepository;
import java.io.IOException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produto")
public class ProductController {

    @Autowired
    ProductRepository produtoRepository;
    
    ModelAndView mv;
    
    @RequestMapping(value= "/index", method = RequestMethod.GET)
    public String index(){
        return "redirect:/resources/index.html";
    }
    @ResponseBody
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String uploadData(@RequestParam("file") MultipartFile file) throws IOException{
        System.out.println(file.getBytes());
    return "foi";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody  List<Product> getAllProduct() {
        return (List) produtoRepository.findAll();
    }
    
    @RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProdutByName(@PathVariable("nome") String nome) {
        return (List) produtoRepository.findByName(nome);
    }
    
    

}
