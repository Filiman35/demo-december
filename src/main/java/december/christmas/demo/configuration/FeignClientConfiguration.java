package december.christmas.demo.configuration;

import com.github.mwiede.feign.validation.ExtendedFeign;
import december.christmas.demo.client.SantaClient;
import december.christmas.demo.client.SpidermanClient;
import december.christmas.demo.client.zorro.ZorroCallClient;
import december.christmas.demo.client.zorro.ZorroEmergencyClient;
import december.christmas.demo.exception.decoder.DemoErrorDecoder;
import december.christmas.demo.properties.SantaProperties;
import december.christmas.demo.properties.SpidermanProperties;
import december.christmas.demo.properties.ZorroProperties;
import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.form.FormEncoder;
import feign.gson.GsonDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/** Configuration for Feign client */
@Configuration
public class FeignClientConfiguration {

  private static final Validator VALIDATOR =
      Validation.buildDefaultValidatorFactory().getValidator();
  private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();
  private static final JacksonEncoder JACKSON_ENCODER = new JacksonEncoder();
  private static final JacksonDecoder JACKSON_DECODER = new JacksonDecoder();
  private static final GsonDecoder GSON_DECODER = new GsonDecoder();
  private static final FormEncoder URL_ENCODER = new FormEncoder();

  private final SantaProperties santaProperties;
  private final ZorroProperties zorroProperties;
  private final SpidermanProperties spidermanProperties;

  @Autowired
  public FeignClientConfiguration(
      SantaProperties santaProperties,
      ZorroProperties zorroProperties,
      SpidermanProperties spidermanProperties) {
    this.santaProperties = santaProperties;
    this.zorroProperties = zorroProperties;
    this.spidermanProperties = spidermanProperties;
  }

  @Bean
  public SantaClient santaClient() {
    return ExtendedFeign.builder(VALIDATOR)
        .client(OK_HTTP_CLIENT)
        .encoder(JACKSON_ENCODER)
        .errorDecoder(new DemoErrorDecoder())
        .logger(new Slf4jLogger(SantaClient.class))
        .requestInterceptor(new BasicAuthRequestInterceptor(santaProperties.getLogin(), santaProperties.getPassword()))
        .target(SantaClient.class, santaProperties.getDomain());
  }

  @Bean
  public ZorroCallClient zorroCallClient() {
    return Feign.builder()
        .client(OK_HTTP_CLIENT)
        .decoder(GSON_DECODER)
        .logger(new Slf4jLogger(ZorroCallClient.class))
        .logLevel(Logger.Level.FULL)
        .target(ZorroCallClient.class, zorroProperties.getDomain());
  }

  @Bean
  public ZorroEmergencyClient zorroEmergencyClient() {
    return Feign.builder()
        .client(OK_HTTP_CLIENT)
        .encoder(JACKSON_ENCODER)
        .decoder(GSON_DECODER)
        .logger(new Slf4jLogger(ZorroEmergencyClient.class))
        .logLevel(Logger.Level.FULL)
        .target(ZorroEmergencyClient.class, zorroProperties.getDomain());
  }

  @Bean
  public SpidermanClient spidermanClient() {
    return Feign.builder()
        .client(OK_HTTP_CLIENT)
        .encoder(JACKSON_ENCODER)
        .decoder(JACKSON_DECODER)
        .logger(new Slf4jLogger(SpidermanClient.class))
        .logLevel(Logger.Level.FULL)
        .target(SpidermanClient.class, spidermanProperties.getDomain());
  }
}