package com.api.fitPass.repository;

import com.api.fitPass.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
