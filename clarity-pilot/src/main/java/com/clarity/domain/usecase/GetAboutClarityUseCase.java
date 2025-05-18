package com.clarity.domain.usecase;

import com.clarity.domain.model.AboutClarity;
import com.clarity.domain.repository.AboutClarityRepository;
import com.clarity.domain.UseCase;

@UseCase
public class GetAboutClarityUseCase {
  private final AboutClarityRepository repository;

  public GetAboutClarityUseCase(final AboutClarityRepository repository) {
    this.repository = repository;
  }

  public AboutClarity process() {
    return repository.get();
  }
}
