package com.example.sbgreeting.com.repositary;


import com.example.sbgreeting.com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<User, Long> {

}
