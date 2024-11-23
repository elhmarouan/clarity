package com.clarity.autoconfigure.fixture;

import com.clarity.domain.annotations.UseCase;

@UseCase
public class MyUseCase {
  public String sayHello() {
    return "Hello from MyUseCase!";
  }
}
