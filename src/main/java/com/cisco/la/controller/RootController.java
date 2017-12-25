package com.cisco.la.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author P9030576
 *
 */
@RestController
@RequestMapping(value = "/")
public class RootController {

	@RequestMapping(value = "hook", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getResponse() {

		return "get welcome hook!";
	}

	@RequestMapping(value = "hook", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object postResponse(@RequestBody String json) {

		Map<String, Object> code = new HashMap<String, Object>();
		code.put("speech", "post welcome hook speech!" + json);
		code.put("displayText", "post welcome hook displayText!" + json);
		return code;
	}
}
