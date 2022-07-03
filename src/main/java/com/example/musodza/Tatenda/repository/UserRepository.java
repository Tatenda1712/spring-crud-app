package com.example.musodza.Tatenda.repository;

import com.example.musodza.Tatenda.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UserRepository extends JpaRepository<UserModel, BigInteger> {
    UserModel findById(int id);
}
