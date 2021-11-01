package com.usa.ciclo3.retociclo3.repository;

import com.usa.ciclo3.retociclo3.crudrepository.CabinCrudRepository;
import com.usa.ciclo3.retociclo3.model.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CabinRepository {
    @Autowired
    private CabinCrudRepository cabinCrudRepository;

    public List<Cabin> getAll() {
        return (List<Cabin>)  cabinCrudRepository.findAll();
    }

    public Optional<Cabin> getCabin(int id){
        return cabinCrudRepository.findById(id);
    }

    public Cabin save(Cabin cabin){
        return cabinCrudRepository.save(cabin);
    }

    public void delete(Cabin cabin){cabinCrudRepository.delete(cabin);}
}
