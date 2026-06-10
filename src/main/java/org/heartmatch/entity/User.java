package org.heartmatch.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private int age;

    @Column(length = 1000)
    private String bio;

    private String gender;
    private String location;

    @ElementCollection
    private List<String> interests;

    private String lookingFor;

    @ElementCollection
    private List<String> photos;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    private boolean blocked = false;

    private LocalDateTime createdAt = LocalDateTime.now();
}