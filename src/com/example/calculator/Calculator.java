package com.example.calculator;

import java.util.Scanner;

public class Calculator {
  private Scanner sc;     // 스캐너
  private Integer op1;        // 첫번째 피연산자
  private Integer op2;        // 두번째 피연산자
  private char operator;  // 연산자
  private Integer result;     // 계산 결과

  // 생성자
  Calculator() {
    this.sc = new Scanner(System.in);
  }

  // 식 입력 받기
  public void getExpr() {
    System.out.print("첫번째 숫자: ");   // Memo: 예외 처리
    this.op1 = sc.nextInt();
    System.out.print("연산자: ");
    this.operator = sc.next().charAt(0);
    System.out.print("두번째 숫자: ");
    this.op2 = sc.nextInt();
  }

  // 입력 받은 식 계산 후 필드에 결과 저장
  public void calculate() {
    // 연산자
    if (this.operator == '+') {
      this.result = this.op1 + this.op2;
    }
    else if (this.operator == '-') {
      this.result = this.op1 - this.op2;
    }
    else if (this.operator == '*') {
      this.result = this.op1 * this.op2;
    }
    else if (this.operator == '/') {
      this.result = this.op1 / this.op2;    // Memo: 0 나누기 예외처리
    }
  }

  // Getter
  public Integer getter() {


   return 0;
  }

  // Setter
  public void setter() {

  }
}
