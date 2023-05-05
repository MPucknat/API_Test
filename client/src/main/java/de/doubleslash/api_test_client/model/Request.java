package de.doubleslash.api_test_client.model;

import lombok.Data;

@Data
public class Request {

  public enum Method {
    ID,
    AMOUNT,
    NOTHING
  }

  private Method method;
  private int number;
}
