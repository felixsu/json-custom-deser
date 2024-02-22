package personal.felix.custom_deser.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import personal.felix.custom_deser.model.DirectRequestParam;
import personal.felix.custom_deser.model.direct.CommonDirectResponse;
import personal.felix.custom_deser.model.direct.Shipment;
import personal.felix.custom_deser.util.InputUtil;
import personal.felix.custom_deser.util.JsonUtil;

// todo all doGet etc are dummy method, assume you have the json from the response.
public class DirectClient extends BaseClient {

  public CommonDirectResponse<Shipment> getSingleShipment(Long id) {
    String url = "direct/same-url";
    Response response = doGet(url, new Request());
    String json = InputUtil.DIRECT_OBJECT;
    return getResponse(json, Shipment.class);
  }

  public CommonDirectResponse<Shipment> getListShipments(DirectRequestParam param) {
    String url = "direct/same-url?q&size";
    Response response = doGet(url, new Request());
    String json = InputUtil.DIRECT_ARRAY;
    return getResponse(json, Shipment.class);
  }

  public CommonDirectResponse<Shipment> createSingleShipment(Shipment request) {
    String url = "direct/same-url";
    doPost(url, new Request());
    return new CommonDirectResponse<>();
  }

  private CommonDirectResponse<Shipment> getResponse(String json, Class<?> clazz) {
    try {
      return JsonUtil.MAPPER
          .readValue(json,
              JsonUtil.MAPPER.getTypeFactory()
                  .constructParametricType(CommonDirectResponse.class, clazz));
    } catch (JsonProcessingException ex) {
      throw new IllegalStateException(ex.getMessage());
    }
  }


}
