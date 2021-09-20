package com.eventos.repository;

import com.eventos.model.OrgModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgRepository extends JpaRepository<OrgModel, Integer> {
    @Autowired
    OrgModel findByEmailOrg(String emailOrg);
}
