package com.example.evenimentemondene;

import org.json.JSONObject;

public interface EventsParser {
	
	public void parseNetworkResponse(String response);
	public Event parseJsonEvent(JSONObject jsonEvent);
}
