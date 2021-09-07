package ardi.springintro.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

  @GetMapping("/penjumlahan")
  public int penjumlahan(@RequestParam int a,@RequestParam int b) {
    return a+b;
  }

  @PostMapping(path ="/penjumlahan", consumes = MediaType.TEXT_PLAIN_VALUE)
  public int postPenjumlahan(@RequestBody int a) {
    return a;
  }
}
