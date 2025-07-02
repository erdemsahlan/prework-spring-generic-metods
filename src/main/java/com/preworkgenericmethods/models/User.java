package com.preworkgenericmethods.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
}