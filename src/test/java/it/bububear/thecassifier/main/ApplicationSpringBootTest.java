package it.bububear.thecassifier.main;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationSpringBoot.class)
@TestPropertySource(locations = "classpath:application.yml")
class ApplicationSpringBootTest {

  @Autowired
  ApplicationContext applicationContext;

  @Value("${startup}")
  String startupPropertiesField;

  @Test
  void startUpTest() {
    assertThat(applicationContext).isNotNull();
  }

  @Test
  void rightApplicationProperties() {
    String valueWrittenInsideApplicationPropertiesFile = "ok";
    assertThat(startupPropertiesField).isEqualTo(valueWrittenInsideApplicationPropertiesFile);
  }

}
