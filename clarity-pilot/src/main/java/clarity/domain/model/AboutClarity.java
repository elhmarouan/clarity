package clarity.domain.model;

import com.clarity.domain.DomainObject;

@DomainObject
public record AboutClarity(String version, String author, String license) {
}
