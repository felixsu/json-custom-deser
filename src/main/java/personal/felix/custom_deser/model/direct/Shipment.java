package personal.felix.custom_deser.model.direct;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Shipment {

  private long id;
  private long shipperId;

}
