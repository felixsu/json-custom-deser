package personal.felix.custom_deser.step;

import java.util.List;
import java.util.Map;
import personal.felix.custom_deser.client.DirectClient;
import personal.felix.custom_deser.model.DirectRequestParam;
import personal.felix.custom_deser.model.direct.Shipment;

public class DirectStep {

  private DirectClient client = new DirectClient();

  // @When("do something")
  public void readAllShipments(Map<String, String> datatable) {
    DirectRequestParam param = DirectRequestParam.builder()
        .q(Integer.parseInt(datatable.get("query")))
        .size(Integer.parseInt(datatable.get("size")))
        .build();

    List<Shipment> shipments = client
        .getListShipments(param)
        .getListData();
  }

  // @When("do something2")
  public void getSingleShipment(long id) {
    Shipment shipment = client
        .getSingleShipment(id)
        .getData();
  }

}
