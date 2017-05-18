package com.bridgeit.toDoApp.serializable;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.StdDeserializer;

public class ItemDeserializer  extends StdDeserializer{

	protected ItemDeserializer(Class vc) {
		super(vc);
		
	}

	@Override
	public Object deserialize(JsonParser jp, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		 JsonNode node = jp.getCodec().readTree(jp);
		 String itemName = node.get("itemName").asText();
		return null;
	}

	
	

}
