package com.testing.library.model.io;

public record BorrowRequestDto(
    Long bookId,
    Long memberId
) {}