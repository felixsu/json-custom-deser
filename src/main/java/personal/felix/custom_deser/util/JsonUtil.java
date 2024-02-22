package personal.felix.custom_deser.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.module.SimpleModule;
import personal.felix.custom_deser.model.direct.CommonDirectResponse;
import personal.felix.custom_deser.model.direct.CommonDirectResponse.Deserializer;

public class JsonUtil {

  public static final ObjectMapper MAPPER = new ObjectMapper();

  static {
    SimpleModule module = new SimpleModule();
    module.addDeserializer(CommonDirectResponse.class, new Deserializer());
    MAPPER.registerModules(module);
    MAPPER.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
  }

}
