package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Pizza;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.PizzaRepository;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getAll() {
        return pizzaRepository.findAll();
    }

    public Pizza getById(Long id) {
        return pizzaRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
    }

    public Pizza create(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza update(Pizza pizza) {
        // si version dans pizza
        // Pizza pizzaEnBase = getById(pizza.getId());
        // pizza.setVersion(pizzaEnBase.getVersion());
        return pizzaRepository.save(pizza);
    }

    public void delete(Pizza pizza) {
        pizzaRepository.delete(pizza);
    }

    public void deleteById(Long id) {
        pizzaRepository.deleteById(id);
    }


}
