package com.example.quotationpdfgeneratorapi.config;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.TemplateEngine;

@Slf4j
public class PdfConfig {

  private SecureRandom random = new SecureRandom();
  private ObjectMapper mapper = new ObjectMapper(createJsonFactory());
  private TemplateEngine thymeleaf = new TemplateEngine();

  private String loadResourceString (String resourcePath) {

    InputStream stream = PdfConfig.class.getClassLoader().getResourceAsStream(resourcePath);

    String content = "";
    if (stream != null) {
       content = new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.joining());
       log.info("Loaded resource file '{}' with {} chars", resourcePath, content.length());
    }

    return content;
  }

  private static JsonFactory createJsonFactory() {
    JsonFactoryBuilder builder = new JsonFactoryBuilder();
    builder.enable(JsonReadFeature.ALLOW_MISSING_VALUES);
    builder.enable(JsonReadFeature.ALLOW_TRAILING_COMMA);
    return builder.build();
  }
}
