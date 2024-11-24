package clarity.domain.usecase;

import clarity.domain.model.AboutClarity;
import clarity.domain.repository.AboutClarityRepository;
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
