package com.example.calculator;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Parser parser = new Parser();
    Calculator cal = new Calculator();

    System.out.println("==== Java Calculator ====");

    while(true) {
      String expression = sc.nextLine();

      if(expression.equals("exit")) {
        break;
      }
      else {
        // Parser 통해 분리
        // Calculator 통해 계산
      }
    }
  }
}
