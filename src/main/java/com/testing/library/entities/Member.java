package com.testing.library.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.testing.library.status.MemberStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_member")
public class Member {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_gender")
    private String gender;

    @Column(name = "member_dob")
    private String date_of_birth;

    @Column(name = "member_phone")
    private String phone;

    @Column(name = "member_emial")
    private String email;

    @Column(name = "member_address")
    private String address;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDateTime create_at; 

    @OneToMany(mappedBy = "member")
    private List<Borrow> borrow;
}
