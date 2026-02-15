package com.testing.library.dto;

import java.time.LocalDateTime;

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
public class BorrowDto {

      private Long id;
      private LocalDateTime borrowDate;
      private LocalDateTime returnDate;
      private Long memberId;
      private Long bookId;
      
}
