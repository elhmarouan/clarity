package com.clarity.infrastructure.web;

import com.clarity.domain.model.AboutClarity;

@DtoMapper
public class AboutClarityDtoMapper {
  public static AboutClarityDto toDto(AboutClarity aboutClarity) {
    return new AboutClarityDto(aboutClarity.version(), aboutClarity.author(), aboutClarity.license());
  }
}
