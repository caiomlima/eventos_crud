package com.eventos.repository;

import com.eventos.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    @Autowired
    UserModel findByEmailUsr(String emailUsr);

}
