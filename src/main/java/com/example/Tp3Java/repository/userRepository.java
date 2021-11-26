/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Tp3Java.repository;

import com.example.Tp3Java.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 55229
 */
public interface userRepository extends JpaRepository<User, Short> {
    User findByEmail(String email);
}
