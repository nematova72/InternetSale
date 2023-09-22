package com.example.internetsale.repo;

import com.example.internetsale.domain.User;
import com.example.internetsale.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userUser);

    boolean existsByUserName(String userName);
}
