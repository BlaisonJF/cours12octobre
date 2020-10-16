package fr.2i.Cours12octobre.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController  //créer du JSON par défaut
public class ProductController {

    @Autowired
    private ProductDao metier;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String afficher(){
            return "Cours d'intro à Spring !"
        }

    @RequestMapping(value = "/unsimul", method = RequestMethod.GET)
    public Product tous(){
            return new Product ( code: 1, designation: "Ordinateur", prix: 1200);
    }

    @RequestMapping(value = "/tous", method = RequestMethod.GET)
    public List<Product> afficherTousLesProduits(){
    return this.metier.findAll();
    }

    @GetMapping(value = "/produit/{code}")
    public Product afficherProduit(@PathVariable int code){
        return metier.findById(code);
    }

    @PostMapping(value = "/ajouter")
    public Product ajouterProduit(@RequestBody Product product){
        return metier.save(product);
    }

    //URI vers la ressource créé dans le champ location
    @PostMapping(value = "/ajouterunproduit")
    public ResponseEntity<Void> ajouterUnProduit(@RequestBody Product product) {
        Product productAjoute = metier.save(product);
        if (productAjoute == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productAjoute.getCode()).toUri();
        return ResponseEntity.created(location).build();
    }

}
