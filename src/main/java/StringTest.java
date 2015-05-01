
public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select").append("\r\n");
		sb.append("rate.member_id, member.member_name, member_image.image_path, rate.rate").append("\r\n");
		sb.append("from").append("\r\n");
		sb.append("member, rate, member_image").append("\r\n");
		sb.append("where").append("\r\n");
		sb.append("rate.member_id = member.member_id and").append("\r\n");
		sb.append("member.member_id = member_image.member_id and").append("\r\n");
		sb.append("rate.category_id = "+ 1 +" and").append("\r\n");//
		sb.append("rate.delete_flag = false").append("\r\n");
		sb.append("order by rate.member_id;").append("\r\n");

		
		String sql = sb.toString();
		
		System.out.println(sql);
	}

}
