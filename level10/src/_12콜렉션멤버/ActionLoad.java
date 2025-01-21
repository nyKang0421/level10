package _12콜렉션멤버;

public class ActionLoad  implements Action  {

	@Override
	public void excute() {
		Utils utils = Utils.getInstance();
		MemberDAO dao = MemberDAO.getMemberDAO();
		System.out.println("==== [ 회원불러오기 ] ====");
		dao.loadData();
	}

}
