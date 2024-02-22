package personal.felix.custom_deser.model;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectRequestParam {

  private int q;
  private int size;
  private String keyword;

  Map<String, String> toQueryParam() {
    Map<String, String> map = new HashMap<>();
    map.put("q", Integer.toString(q));
    map.put("size", Integer.toString(size));
    return map;
  }

}
