package _12콜렉션멤버;

import java.util.HashMap;
import java.util.Map;

public class Controller {
	
	private Map<Menu, Action> mapList;
	Utils utils = Utils.getInstance();
	MemberDAO dao = MemberDAO.getMemberDAO();
	
	public Controller() {
		mapList = new HashMap<Menu, Action>();
		
		mapList.put(Menu.INSERT, new ActionInsert());
		mapList.put(Menu.DELETE, new ActionDelete());
		mapList.put(Menu.UPDATE, new ActionUpdate());
		mapList.put(Menu.PRINT, new ActionPrint());
		mapList.put(Menu.SAVE, new ActionSave());
		mapList.put(Menu.LOAD, new ActionLoad());
	}
	
	public Action getAction(String string) {
		return mapList.get(Menu.getMenu(string));
	}
	
	public void run() {
		while (true) {
			System.out.println("========== 메뉴 ==========");
			System.out.println("1) 추가"); // id 중복제거
			System.out.println("2) 삭제"); // id 로 삭제
			System.out.println("3) 수정"); // id로 수정 -> 비번 검색 -> 비번 맞으면 이름 수정
			System.out.println("4) 출력"); // 이름순 으로 출력
			System.out.println("5) 저장"); // member.txt => id 순으로 저장
			System.out.println("6) 로드"); // member.txt 로드
			System.out.println("0) 종료");
			int sel = utils.getIntValue("메뉴",0,6);
			if(dao.isNullCheck()) {
				if(sel>1&&sel<6) {
					utils.printErr("존재하는 멤버 목록이 없음");
					continue;
				}
			}
			if (sel == 1) {
				// 추가하는 기능 DAO
				getAction("insert").excute();

			}else if(sel == 2){
				getAction("delete").excute();
				
			}else if(sel == 3){
				getAction("update").excute();
				
			}else if(sel == 4){
				getAction("print").excute();
				
			}else if(sel == 5){
				getAction("save").excute(); 
				
			}else if(sel == 6){
				getAction("load").excute(); 
				
			}else if(sel == 0){
				utils.printMsg("프로그램 종료");
				utils.closeScanner();
				break;
			}
		}
	}

}
