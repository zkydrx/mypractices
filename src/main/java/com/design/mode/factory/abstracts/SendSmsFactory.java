package com.design.mode.factory.abstracts;

import com.design.mode.factory.common.ISender;
import com.design.mode.factory.common.SmsSender;

public class SendSmsFactory implements Provider {

	@Override
	public ISender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}
