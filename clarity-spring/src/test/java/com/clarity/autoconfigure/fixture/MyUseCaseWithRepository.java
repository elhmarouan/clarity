package com.clarity.autoconfigure.fixture;

import com.clarity.domain.annotations.UseCase;

@UseCase
public class MyUseCaseWithRepository {
  private final MyPersistenceRepository persistenceRepository;

  public MyUseCaseWithRepository(final MyPersistenceRepository persistenceRepository) {
    this.persistenceRepository = persistenceRepository;
  }

  public String sayHello() {
    return "Hello from %s! %s".formatted(this.getClass().getSimpleName(), persistenceRepository.sayHello());
  }
}
