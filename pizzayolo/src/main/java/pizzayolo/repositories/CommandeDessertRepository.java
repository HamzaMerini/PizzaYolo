package pizzayolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzayolo.entity.CommandeDessert;
import pizzayolo.entity.CommandeDessertKey;

public interface CommandeDessertRepository extends JpaRepository<CommandeDessert, CommandeDessertKey>{

}
