package com.sakinramazan.userservice.entity;

import com.sakinramazan.userservice.annotation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String lastname;

    @NotNull(message = "{validation.messages.users.username}")
    private String username;

    @NotNull(message = "{validation.messages.users.email}")
    @Email(message = "{validation.messages.users.valid-email}")
    private String email;

    @NotNull(message = "{validation.messages.users.password}")
    @ValidPassword
    private String password;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // Not need to persist todos
    @Transient
    private List<Todo> todos;

}
