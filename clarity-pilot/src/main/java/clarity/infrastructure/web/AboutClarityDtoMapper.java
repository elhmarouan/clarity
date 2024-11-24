package clarity.infrastructure.web;

import clarity.domain.model.AboutClarity;
import com.clarity.infrastructure.web.DtoMapper;

@DtoMapper
public class AboutClarityDtoMapper {
  public static AboutClarityDto toDto(AboutClarity aboutClarity) {
    return new AboutClarityDto(aboutClarity.version(), aboutClarity.author(), aboutClarity.license());
  }
}
