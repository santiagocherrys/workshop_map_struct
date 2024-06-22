package com.riwi.libros_ya.domain.entities;

import com.riwi.libros_ya.util.enums.RoleUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String username;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 100, nullable = false )
    private String email;
    @Column(length = 100, nullable = false)
    private String full_name;
    @Enumerated(EnumType.STRING)
    private RoleUser role;

    //Relaciones
    @OneToMany(mappedBy = "user",
                cascade = CascadeType.ALL,
                orphanRemoval = false,
                fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "user",
                cascade = CascadeType.ALL,
                orphanRemoval = false,
                fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Loan> loans;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", full_name='" + full_name + '\'' +
                ", role=" + role +
                ", reservations=" + reservations +
                ", loans=" + loans +
                '}';
    }
}
