package com.testing.library.member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.testing.library.borrow.Borrow;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_member")
@Builder
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

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private final List<Borrow> borrow = new ArrayList<>();
}
