package com.testing.library.borrow;

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

      // @Autowired
      // private BorrowService serviceBorrow;
      // private BorrowDto borrowDto;

      // @PostMapping
      // public ResponseEntity<BorrowDto> createBorrowEmployee(@RequestBody BorrowDto borrowDto) {
      //       BorrowDto borrow = serviceBorrow.create(borrowDto);
      //          return new ResponseEntity<>(borrow, HttpStatus.CREATED); 
      // }

      // @GetMapping("/{id}")
      // public ResponseEntity<BorrowDto>  findById(@PathVariable("id") Long id) {
      //       BorrowDto borrow = serviceBorrow.findByid(id, borrowDto);
      //       return new ResponseEntity<>(borrow, HttpStatus.OK);
      // }

      // @GetMapping
      // public ResponseEntity<List<BorrowDto>> findAllBorrowsResponeEntity() {
      //       List<BorrowDto> borrows = serviceBorrow.findAllBorrows();
      //       return new ResponseEntity<>(borrows, HttpStatus.OK);
      // }

      // @PutMapping("/{id}")
      // public ResponseEntity<BorrowDto> updateBorrow(
      //       @PathVariable("id") Long id, 
      //       @RequestBody BorrowDto borrowDto) {
      //       BorrowDto borrowUpdate = serviceBorrow.updateBorrow(id, borrowDto.getReturnDate());
      //       return new ResponseEntity<>(borrowUpdate, HttpStatus.OK);
      // }

      // @DeleteMapping("/{id}")
      // public ResponseEntity<String> deleteBorrow(@PathVariable("id") Long id) {
      //       serviceBorrow.deleteBorrow(id);
      //       return ResponseEntity.ok("This borrow is Deleted successfully");
      // }

}
