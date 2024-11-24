package clarity.infrastructure.web;

import com.clarity.infrastructure.web.Dto;

@Dto
public record AboutClarityDto(String version, String author, String license) {
}
