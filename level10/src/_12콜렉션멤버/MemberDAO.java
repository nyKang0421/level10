package _12콜렉션멤버;

import java.util.ArrayList;

public class MemberDAO {
	
	private static ArrayList<Member> memberList;
	
	private MemberDAO() {};
	private static MemberDAO instance;
	public static MemberDAO getMemberDAO() {
		if(instance == null) instance = new MemberDAO();
		memberList = new ArrayList();
		return instance;
	}

}
