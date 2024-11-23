package com.clarity.autoconfigure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.clarity.autoconfigure.fixture.MyUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CustomAnnotationsBeanAutoConfiguration.class)
class SpringContextTest {

  @Autowired
  private MyUseCase myUseCase;

  @Test
  void contextLoads() {
    assertNotNull(myUseCase);
    assertEquals("Hello from MyUseCase!", myUseCase.sayHello());
  }


}
