package de.doubleslash.api_test_client.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Response {
  private long time;

  private List<Beer> data;
}
