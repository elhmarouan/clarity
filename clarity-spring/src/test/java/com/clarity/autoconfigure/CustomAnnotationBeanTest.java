package com.clarity.autoconfigure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.clarity.autoconfigure.fixture.MyUseCase;
import com.clarity.autoconfigure.fixture.MyUseCaseWithRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CustomAnnotationsBeanAutoConfiguration.class)
class CustomAnnotationBeanTest {

  @Autowired
  private MyUseCase myUseCase;

  @Autowired
  private MyUseCaseWithRepository myUseCaseWithRepository;

  @Test
  void shouldCreateUseCaseBean_whenContextLoads() {
    // GIVEN
    final String expectedHelloMessage = "Hello from MyUseCase!";

    // WHEN
    // context loads

    // THEN
    assertNotNull(myUseCase);
    assertEquals(expectedHelloMessage, myUseCase.sayHello());
  }

  @Test
  void shouldCreateUseCase_andInjectRepository_whenContextLoads() {
    // GIVEN
    final String expectedHelloMessage = "Hello from MyUseCaseWithRepository! Hello from MyPersistenceRepository!";

    // WHEN
    // context loads

    // THEN
    assertNotNull(myUseCaseWithRepository);
    assertEquals(expectedHelloMessage, myUseCaseWithRepository.sayHello());
  }


}
