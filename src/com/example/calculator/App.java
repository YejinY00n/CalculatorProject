package com.example.calculator;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Calculator cal = new Calculator();
    String input;

    System.out.println("==== Java Calculator ====");

    while(true) {
      String expression = sc.nextLine();
      // cal 계산 함수, 리턴 값 받아서 결과 출력

      // exit 입력 시 종료
      System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
      input = sc.nextLine();
      if(input.equals("exit")) break;
    }
  }
}
