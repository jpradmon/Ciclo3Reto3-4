package com.usa.ciclo3.retociclo3.controller;

import com.usa.ciclo3.retociclo3.model.Cabin;
import com.usa.ciclo3.retociclo3.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin (origins= "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CabinController {
    @Autowired
    private CabinService cabinService;

    @GetMapping("/all")
    public List<Cabin> getAll(){return cabinService.getAll();}

    @GetMapping("/{id}")
    public Optional<Cabin> getCabin(@PathVariable("id") int id){return cabinService.getCabin(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin cabin){ return cabinService.save(cabin);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin cabin){return cabinService.update(cabin);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int id){return cabinService.deleteCabin(id);}
}
