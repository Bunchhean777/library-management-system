package com.testing.library.model.io;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
      
      private Long id;
      private String name;
      private String gender;
      private String phone;
      private String email;
      private String address;
      private LocalDateTime createAt;

      private List<Long> borrowId;
}
