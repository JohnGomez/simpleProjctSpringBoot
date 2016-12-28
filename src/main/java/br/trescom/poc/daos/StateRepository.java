package br.trescom.poc.daos;

import br.trescom.poc.models.State;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author as
 */
public interface StateRepository extends CrudRepository<State, Long> {

    List<State> findAllByOrderByIdDesc();

    List<State> findAll(Pageable pageable);

}
