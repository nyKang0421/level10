package _12콜렉션멤버;

public class ActionPrint implements Action {

	@Override
	public void excute() {
		Utils utils = Utils.getInstance();
		MemberDAO dao = MemberDAO.getMemberDAO();
		
		System.out.println("==== [ 전체회원정보 ] ====");
		
		dao.printAllMember();
	}
	
	

}
