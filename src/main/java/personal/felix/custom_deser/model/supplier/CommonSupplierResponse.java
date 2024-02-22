package personal.felix.custom_deser.model.supplier;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// todo write the custom deserializer
public class CommonSupplierResponse <T> {

  private int number;
  private int page;
  private List<T> suppliers;

}
