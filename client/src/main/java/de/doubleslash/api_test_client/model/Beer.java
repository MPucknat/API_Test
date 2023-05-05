package de.doubleslash.api_test_client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Beer {

  private int id;

  private String name;

  private String hop;

  private String yeast;

  private String malt;

  private String style;
}
