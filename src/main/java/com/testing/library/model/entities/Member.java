package com.testing.library.model.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "tbl_member")
public class Member {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime createAt; 

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Borrow> borrows = new ArrayList<>();

    public Member(){}
}
