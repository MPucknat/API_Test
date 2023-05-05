package de.doubleslash.api_test_client;

import de.doubleslash.api_test_client.endpoints.CallProtocol.ProtocolType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProtocolTypeConverter implements Converter<String, ProtocolType> {

  @Override
  public ProtocolType convert(String value) {
    return ProtocolType.valueOf(value.toUpperCase());
  }
}
