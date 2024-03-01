package com.telusko.generator;

import java.util.UUID;

public class UUIDGenarator 
{
	public String generateUUID()
	{
		return UUID.randomUUID().toString().replace("-", "");
	}
}
