package com.example.three.util;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by admin on 2017/8/10.
 */
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {

	public SessionInitializer() {
		super(SessionConfig.class);
	}
}
