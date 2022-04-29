package pizzayolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzayolo.entity.CommandeBoisson;
import pizzayolo.entity.CommandeBoissonKey;

public interface CommandeBoissonRepository extends JpaRepository<CommandeBoisson, CommandeBoissonKey>{

}
