package com.testing.library.member;

import java.util.List;

import com.testing.library.borrow.Borrow;

public class MemberMapper {

      public static MemberDto toDto(Member member) {
            if (member == null) return null;

            List<Long> borrowIds = member.getBorrow()
                  .stream()
                  .map(Borrow::getId)
                  .toList();

            return MemberDto.builder()
                  .id(member.getId())
                  .name(member.getName())
                  .gender(member.getGender())
                  .phone(member.getPhone())
                  .email(member.getEmail())
                  .address(member.getAddress())
                  .createAt(member.getCreateAt())
                  .borrowId(borrowIds)
                  .build();
      }

      public static Member toMember(MemberDto dto) {
            if (dto == null) return null;
            return Member.builder()
                  .id(dto.getId())
                  .name(dto.getName())
                  .gender(dto.getGender())
                  .phone(dto.getPhone())
                  .email(dto.getEmail())
                  .address(dto.getAddress())
                  .createAt(dto.getCreateAt())
                  .build();
      }
}
