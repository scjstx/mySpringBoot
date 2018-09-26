
package com.ym.util;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

import java.util.UUID;

public class UUIDGenerator {

	private static final TimeBasedGenerator gen = Generators.timeBasedGenerator(EthernetAddress.fromInterface());

	public static UUID generate() {
		return gen.generate();
	}

	public static String generateUUIDStr() {
		return UUIDGenerator.generate().toString();
	}

}
