package _12콜렉션멤버;

// mvc : model view controller

//controller 기능 - 페이지 연결
//페이지(view : Action 객체들) : 사용자 값 받아오고 값 전달
//DAO : 여러개의 멤버들의 기능
//VO(model) : Member

public class ActionInsert implements Action {

	@Override
	public void excute() {
		
		System.out.println("==== [ 회원가입 ] ====");
		
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
