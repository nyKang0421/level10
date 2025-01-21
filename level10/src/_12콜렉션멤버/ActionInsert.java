package _12콜렉션멤버;

// mvc : model view controller

//controller 기능 - 페이지 연결
//페이지(view : Action 객체들) : 사용자 값 받아오고 값 전달
//DAO : 여러개의 멤버들의 기능
//VO(model) : Member

public class ActionInsert implements Action {

	@Override
	public void excute() {
		
		Utils utils = Utils.getInstance();
		MemberDAO dao = MemberDAO.getMemberDAO();
		
		System.out.println("==== [ 회원가입 ] ====");
		while(true) {
			String id = utils.getStrValue("ID");
			if(id == null) continue;
			if(dao.isDuplId(id)) {
				utils.printErr("이미 사용중인 ID");
				continue;
			}
			String pw = utils.getStrValue("PW");
			if(pw == null) continue;
			String name = utils.getStrValue("이름");
			if(name == null) continue;
			
			dao.addAMember(id,pw,name);
			
			utils.printMsg("회원가입 완료");
			break;
		}
		
		/*
		 // 추가하는 dao 연결
		  String id = "test";
		  String pw = "1234";
		  String name = "테스트1";
		  
		  dao.addMember(id,pw,name);
		  
		  
		System.out.println("회원 가입 완료");
		 */
	}

}
