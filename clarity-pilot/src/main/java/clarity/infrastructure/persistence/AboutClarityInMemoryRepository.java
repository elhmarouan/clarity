package clarity.infrastructure.persistence;

import clarity.domain.model.AboutClarity;
import clarity.domain.repository.AboutClarityRepository;
import com.clarity.infrastructure.persistence.PersistenceRepository;

@PersistenceRepository
public class AboutClarityInMemoryRepository implements AboutClarityRepository {
  private static final AboutClarity aboutClarity = new AboutClarity("1.0", "X", "None");

  @Override
  public AboutClarity get() {
    return aboutClarity;
  }
}
