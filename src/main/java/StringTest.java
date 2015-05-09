
public class StringTest {

	public static void main(String[] args) {
		/*
		StringBuilder sb = new StringBuilder();
		sb.append("select").append("\r\n");
		sb.append("rate.category_id, rate.member_id, rate.rate, member.member_name, category.category_id").append("\r\n");
		sb.append("from rate").append("\r\n");
		sb.append("inner join member on rate.member_id = member.member_id").append("\r\n");
		sb.append("inner join category on rate.category_id = category.category_id").append("\r\n");
		sb.append("where").append("\r\n");
		sb.append("rate.category_id = "+ 1 +" and").append("\r\n");
		sb.append("rate.delete_flag = false").append("\r\n");
		sb.append("order by rate.rate desc").append("\r\n");

		String sql = sb.toString();
		System.out.println(sql);
		*/
		
		double dbl;
		int	intv;
		for (int i = 0; i < 100; i++) {

			dbl = (Math.random()*24);
			intv = (int) dbl;
			System.out.println(intv);
		}
	}

}
