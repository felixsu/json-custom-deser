package personal.felix.custom_deser.model.direct;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import personal.felix.custom_deser.util.JsonUtil;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonDirectResponse <T> {

  private boolean status;
  private T data;
  private List<T> listData;
  private Paging paging;

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Paging {
    private boolean hasNext;
  }
  public static class Deserializer extends
      StdDeserializer<CommonDirectResponse<?>> implements ContextualDeserializer {

    private static final ObjectMapper MAPPER = JsonUtil.MAPPER;

    private JavaType type;
    public Deserializer() {
      super(CommonDirectResponse.class);
    }

    @Override
    public JavaType getValueType() {
      return super.getValueType();
    }

    @Override
    public CommonDirectResponse<?> deserialize(JsonParser parser, DeserializationContext ctxt)
        throws IOException, JacksonException {
      CommonDirectResponse<?> response = new CommonDirectResponse<>();
      ObjectCodec codec = parser.getCodec();
      JsonNode node = codec.readTree(parser);

      // parse status
      boolean status = node.get("status").asBoolean();
      response.setStatus(status);

      // parse paging (optional)
      if (node.has("paging")) {
        Paging paging = MAPPER.readValue(node.get("paging").toString(), Paging.class);
        response.setPaging(paging);
      }

      // parse data (either object or array)
      JsonNode data = node.get("data");
      if (data.isArray()) {
        response.setListData(MAPPER
            .readValue(data.toString(),
                MAPPER.getTypeFactory().constructCollectionType(List.class, type)));
      } else {
        response.setData(MAPPER.readValue(data.toString(), type));

      }

      return response;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
        throws JsonMappingException {
      if (property == null) {
        this.type = ctxt.getContextualType().containedType(0);
      } else {
        this.type = property.getType().containedType(0);
      }
      return this;
    }
  }

}
