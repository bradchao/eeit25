package tw.brad.api;

public record Member(
		long id,
		String account,
		String passwd,
		String name,
		String iconBase64,
		byte[] bike
		) {}
