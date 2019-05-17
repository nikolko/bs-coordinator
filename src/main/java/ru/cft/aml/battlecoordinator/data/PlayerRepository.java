package ru.cft.aml.battlecoordinator.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity, Long> {

    Optional<PlayerEntity> findByUiId(Integer id);
    Optional<PlayerEntity> findByUiIdNot(Integer id);
}
