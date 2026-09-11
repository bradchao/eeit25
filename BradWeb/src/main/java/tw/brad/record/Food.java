package tw.brad.record;

// 資料模型 => getter, setter, equals, tostring
public record Food(
		long id,
		String name,
		String tel,
		String city,
		String town,
		String addr,
		String picurl
		) {}
