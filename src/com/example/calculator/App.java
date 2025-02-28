package com.example.calculator;

import java.util.Scanner;

public class App <T extends Number>  {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArithmeticCalculator cal = new ArithmeticCalculator();
    String input;

    System.out.println("==== Java Calculator ====");

    while(true) {
      // 입력 받기
      try {
        System.out.print("첫번째 숫자: ");
        cal.setOp1(Double.parseDouble(sc.next()));
        System.out.print("연산자: ");
        cal.setOperator(sc.next().charAt(0));
        System.out.print("두번째 숫자: ");
        cal.setOp2(Double.parseDouble(sc.next()));
      }
      catch (Exception e) {
        System.out.println("잘못된 입력 값 입니다.");
        continue;
      }

      // 입력받은 식 계산
      try {
        cal.calculate();
      }
      catch (Exception e) {
        System.out.println("잘못된 연산입니다.");
        continue;
      }

      // 결과 출력
      System.out.println("계산 결과: " + cal.getLastResult()+"\n");   
      cal.getBiggerResults(cal.getLastResult());                   // 현재 결과보다 큰 이전의 계산 결과 출력

      // exit 입력 시 종료
      System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
      input = sc.next();
      if(input.equals("exit")) break;
    }
  }
}
