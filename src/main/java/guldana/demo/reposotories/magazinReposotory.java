package guldana.demo.reposotories;


import guldana.demo.models.magazin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface magazinReposotory extends CrudRepository<magazin, Long> {
    Optional<magazin> findById(Long id);

}
