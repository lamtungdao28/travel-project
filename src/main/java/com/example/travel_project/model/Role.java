package com.example.travel_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends AbstractEntity<Integer> {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "role")
    @Builder.Default
    private Set<UserHasRole> users = new HashSet<>();

    @OneToMany(mappedBy = "role")
    @Builder.Default
    private Set<User> directUsers = new HashSet<>();

    @OneToMany(mappedBy = "role")
    @Builder.Default
    private Set<RoleHasPermission> rolePermissions = new HashSet<>();
}
