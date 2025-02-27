package com.example.calculator;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArithmeticCalculator cal = new ArithmeticCalculator();
    String input;

    System.out.println("==== Java Calculator ====");

    while(true) {
      // 입력 받기
      try {
        System.out.print("첫번째 숫자: ");
        cal.setOp1(sc.nextInt());
        System.out.print("연산자: ");
        cal.setOperator(sc.next().charAt(0));
        System.out.print("두번째 숫자: ");
        cal.setOp2(sc.nextInt());
      }
      catch (Exception e) {
        System.out.println("잘못된 입력 값 입니다.");
        continue;
      }

      try {
        cal.calculate();    // 입력받은 식 계산
      }
      catch (Exception e) {
        System.out.println("잘못된 연산입니다.");
        continue;
      }

      System.out.printf("계산 결과: %d\n\n", cal.getLastResult());   // 결과 출력
      cal.getBiggerResults(cal.getLastResult());                   // 현재 결과보다 큰 이전의 계산 결과 출력

      // exit 입력 시 종료
      System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
      input = sc.next();
      if(input.equals("exit")) break;
    }
  }
}
