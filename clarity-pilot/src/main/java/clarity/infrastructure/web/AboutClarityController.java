package clarity.infrastructure.web;

import static clarity.infrastructure.web.AboutClarityDtoMapper.toDto;

import clarity.domain.model.AboutClarity;
import clarity.domain.usecase.GetAboutClarityUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AboutClarityController {
  private final GetAboutClarityUseCase useCase;

  public AboutClarityController(final GetAboutClarityUseCase useCase) {
    this.useCase = useCase;
  }

  @GetMapping("/about")
  public AboutClarityDto getAbout() {
    final AboutClarity aboutClarity = useCase.process();
    return toDto(aboutClarity);
  }
}
