import java.util.HashSet;
import java.util.List;

import com.zaipon.kami7.business.MemberBusiness;
import com.zaipon.kami7.service.command.MatchResultCommand;
import com.zaipon.kami7.service.form.MemberForm;


public class Teest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MemberBusiness business = new MemberBusiness();
		List<MemberForm> resultList = business.getEntry(1);
		HashSet<MemberForm> pair = business.getPair(1);
		
		System.out.println(pair.size());

		for(MemberForm form : pair){
			System.out.println("player:");
			System.out.println(form.getMemberId()+"\t"+ form.getMemberName()+"\t"+form.getImgPath());
		}

		System.out.println("===========前者の勝ち=============");
			MatchResultCommand command = new MatchResultCommand();
			command.setCategoryId(1);
			command.setWinnerId(1);//1600
			command.setLoserId(2);//1400
			business.updateRate(command);
		System.out.println("=================================");
		
		System.out.println("id\tname\tpath");
		for(MemberForm form: resultList){
			System.out.println(form.getMemberId()+"\t"+form.getMemberName()+"\t"+form.getImgPath());
		}
	}

}
