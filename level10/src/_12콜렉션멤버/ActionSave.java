package _12콜렉션멤버;

public class ActionSave implements Action  {

	@Override
	public void excute() {
		Utils utils = Utils.getInstance();
		MemberDAO dao = MemberDAO.getMemberDAO();
		System.out.println("==== [ 회원저장 ] ====");
		dao.saveData();
	}

}
