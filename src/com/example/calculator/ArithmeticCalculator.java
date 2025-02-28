package com.example.calculator;

import java.util.ArrayList;

enum Operator {
  ADD('+'), SUBTRACT('-'), MULTIPLE('*'), DIVIDE('/');

  private char op;

  Operator (char op) {
    this.op = op;
  }

  public char getOp() {
    return this.op;
  }
}

public class ArithmeticCalculator <T extends Number> {
  private T op1;        // 첫번째 피연산자
  private T op2;        // 두번째 피연산자
  private char operator;  // 연산자
  private ArrayList<Object> resultList = new ArrayList<>();     // 계산 결과 저장

  ArithmeticCalculator() {
  }

  // 입력 받은 식 계산 후 필드에 결과 저장
  public void calculate() throws Exception {
    // 연산 후 결과 저장
    if (this.operator == Operator.ADD.getOp()) {
      this.resultList.add(this.op1.doubleValue() + this.op2.doubleValue());
    }
    else if (this.operator ==  Operator.SUBTRACT.getOp()) {
      this.resultList.add(this.op1.doubleValue() - this.op2.doubleValue());
    }
    else if (this.operator ==  Operator.MULTIPLE.getOp()) {
      this.resultList.add(this.op1.doubleValue() * this.op2.doubleValue());
    }
    else if (this.operator == Operator.DIVIDE.getOp()) {
      // 0으로 나누는 경우
      if(this.op2.doubleValue() == 0) {
        System.out.println("0 으로 나눌 수 없습니다.");
        throw new ArithmeticException();
      }

      this.resultList.add(this.op1.doubleValue() / this.op2.doubleValue());
    }
    else {
      System.out.println("유효하지 않은 연산자 입니다.");
      throw new Exception();
    }
  }


  // 피연산자1 (op1) setter
  public void setOp1(T op1) {
    this.op1 = op1;
  }

  // 피연산자2 (op2) setter
  public void setOp2(T op2) {
    this.op2 = op2;
  }

  // 연산자 (operator) setter
  public void setOperator(char operator) {
    this.operator = operator;
  }

  // 마지막 연산 결과 getter
  public T getLastResult() {
    return (T) this.resultList.get(resultList.size()-1);
  }

  // 저장된 연산 결과들 중 Scanner 로 입력받은 값보다 큰 결과값들을 출력
  public void getBiggerResults(T result) {
    System.out.print(result + " 보다 큰 이전의 계산 결과들: ");
      // 저장된 이전 결과들 중에서 result 보다 큰 값을 출력
     this.resultList.stream()
        .filter(r -> (result.doubleValue() - (Double)r < 0))    // 저장된 값 (r) 이 result 보다 크다면
        .forEach(r -> System.out.print(r+", "));
    System.out.println(" ");  // 줄바꿈
  }
}
