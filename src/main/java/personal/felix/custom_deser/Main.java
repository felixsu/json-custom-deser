package personal.felix.custom_deser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.module.SimpleModule;
import personal.felix.custom_deser.model.direct.CommonDirectResponse;
import personal.felix.custom_deser.model.direct.CommonDirectResponse.Deserializer;
import personal.felix.custom_deser.model.direct.Shipment;
import personal.felix.custom_deser.util.InputUtil;
import personal.felix.custom_deser.util.JsonUtil;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

  public static void main(String[] args) throws JsonProcessingException {
    CommonDirectResponse<Shipment> result = JsonUtil.MAPPER
        .readValue(
            InputUtil.DIRECT_ARRAY,
            JsonUtil.MAPPER.getTypeFactory().constructParametricType(CommonDirectResponse.class, Shipment.class));
    System.out.println(result);

    CommonDirectResponse<Shipment> result2 = JsonUtil.MAPPER
        .readValue(
            InputUtil.DIRECT_OBJECT,
            JsonUtil.MAPPER.getTypeFactory().constructParametricType(CommonDirectResponse.class, Shipment.class));
    System.out.println(result2);
  }
}