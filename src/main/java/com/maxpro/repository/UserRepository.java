package com.maxpro.repository;

import com.maxpro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    @Query("SELECT user FROM User user WHERE user.userName = :userName")
    User findUserByUserName(@Param("userName") String userName);

}
