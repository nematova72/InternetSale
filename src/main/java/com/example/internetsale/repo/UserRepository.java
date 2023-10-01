package com.example.internetsale.repo;

import com.example.internetsale.domain.User;
import com.example.internetsale.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userUser);
    @Query(nativeQuery = true, value = "select * from clean_code_user  where userName =:userName")
    User findByLogin(@Param("userName")String userName);

    boolean existsByUserName(String userName);
}
