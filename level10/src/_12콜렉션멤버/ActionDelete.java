package _12콜렉션멤버;

public class ActionDelete implements Action {

	@Override
	public void excute() {
		Utils utils = Utils.getInstance();
		MemberDAO dao = MemberDAO.getMemberDAO();
		
		System.out.println("==== [ 회원삭제 ] ====");
		
		String id = utils.getStrValue("ID");
		if(!dao.isDuplId(id)) {
			utils.printErr("존재하지 않는 ID");
			return;
		}
		dao.delAMember(id);
	}

}
