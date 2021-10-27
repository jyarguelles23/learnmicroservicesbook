package com.viqsystems.multiplication.Users.Repositories;


import com.viqsystems.multiplication.Users.Entities.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<Users, Long> {

    Optional<Users> findByAlias(final String alias);

    List<Users> findAllByIdIn(List<Long> idList);

}
