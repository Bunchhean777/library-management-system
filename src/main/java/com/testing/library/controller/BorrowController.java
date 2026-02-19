package com.testing.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.testing.library.service.BorrowService;

@RestController
@RequestMapping("api/borrows")
public class BorrowController {

      private final BorrowService borrowService;

      public BorrowController(BorrowService borrowService) {
            this.borrowService = borrowService;
      }

}
