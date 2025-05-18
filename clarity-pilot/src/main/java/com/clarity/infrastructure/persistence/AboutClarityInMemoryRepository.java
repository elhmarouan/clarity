package com.clarity.infrastructure.persistence;

import com.clarity.domain.model.AboutClarity;
import com.clarity.domain.repository.AboutClarityRepository;

@PersistenceRepository
public class AboutClarityInMemoryRepository implements AboutClarityRepository {
  private static final AboutClarity aboutClarity = new AboutClarity("1.0", "X", "None");

  @Override
  public AboutClarity get() {
    return aboutClarity;
  }
}
