package com.clarity.autoconfigure.fixture;

import com.clarity.infrastructure.persistence.PersistenceRepository;

@PersistenceRepository
public class MyPersistenceRepository {
  public String sayHello() {
    return "Hello from %s!".formatted(this.getClass().getSimpleName());
  }
}
