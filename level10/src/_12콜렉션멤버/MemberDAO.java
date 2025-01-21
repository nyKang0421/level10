package _12콜렉션멤버;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MemberDAO {
	
	Utils utils = Utils.getInstance();
	
	private static ArrayList<Member> memberList;
	
	TreeSet[] treeset = {
			new TreeSet<>(),
			new TreeSet<>(new MemberComp(MemberComp.SortBy.NAME, MemberComp.SortDir.ASC)),
			new TreeSet<>(new MemberComp(MemberComp.SortBy.ID, MemberComp.SortDir.ASC)),
	};
	
	private MemberDAO() {
		memberList = new ArrayList();
	};
	private static MemberDAO instance;
	public static MemberDAO getMemberDAO() {
		if(instance == null) instance = new MemberDAO();
		return instance;
	}
	// 임시
	public ArrayList<Member> getMemberList() {
		return memberList;
	}
	public boolean isDuplId(String id) {
		if(memberList.size()==0) return false;
		for(Member m : memberList)
			if(id.equals(m.getId())) return true;
		return false;
	}
	public void addAMember(String id, String pw, String name) {
		memberList.add(new Member(id,pw,name));
		System.out.println(memberList.get(memberList.size()-1));
	}
	public void delAMember(String id) {
		for(int i = 0; i<memberList.size();i++) {
			if(memberList.get(i).getId().equals(id)) {
				memberList.remove(i);
				utils.printMsg("삭제 완료");
				return;
			}
		}
	}
	public boolean isNullCheck() {
		if(memberList == null || memberList.size()==0) return true;
		return false;
	}
	public void updateAMember() {
		int idx = 0;
		String id = utils.getStrValue("ID");
		if(id == null) return;
		if(!isDuplId(id)) {
			utils.printErr("존재하지 않는 ID");
			return;
		}
		
		updateExcute(id);
		
	}
	private void updateExcute(String id) {
		for(int i = 0; i<memberList.size();i++) {
			if(memberList.get(i).getId().equals(id)) {
				String pw = utils.getStrValue("PW");
				if(pw == null) return; 
				if(!isDuplPw(pw)) {
					utils.printErr("PW 오류");
					return;
				}
				String name = utils.getStrValue("이름");
				if(name == null) return;
				if(isDuplName(name)) {
					utils.printErr("기존 이름과 동일");
					return;
				}
				memberList.get(i).setName(name);
				utils.printMsg("수정 완료");
				System.out.println(memberList.get(i));
			}
		}
		
	}
	private boolean isDuplName(String name) {
		if(memberList.size()==0) return false;
		for(Member m : memberList)
			if(name.equals(m.getName())) return true;
		return false;
	}
	private boolean isDuplPw(String pw) {
		if(memberList.size()==0) return false;
		for(Member m : memberList)
			if(pw.equals(m.getPw())) return true;
		return false;
	}
	public void printAllMember() {
		/*
		ArrayList<Member> temp = (ArrayList<Member>) memberList.clone();
		Collections.sort(temp);
		for(Member m : temp)
			System.out.println(m);
		*/
		treeset[1] = new TreeSet<>(new MemberComp(MemberComp.SortBy.NAME, MemberComp.SortDir.ASC));
		for(Member m : memberList)
			treeset[1].add(m);
		for(Object m : treeset[1])
			System.out.println(m);
	}
	public void saveData() {
		String data = makeData();
		utils.saveExcute(data);
		
	}
	private String makeData() {
		String data = "";
		treeset[2] = new TreeSet<>(new MemberComp(MemberComp.SortBy.ID, MemberComp.SortDir.ASC));
		for(Member m : memberList)
			treeset[2].add(m);
		for(Object m : treeset[2])
			data += ((Member) m).forSaveData();
		return data;
	}
	public void loadData() {
		String data = utils.loadExcute();
		if(data == null||data.isBlank()||data.isBlank()) return;
		memberList.clear();
		String[] temp = data.split("\n");
		for(int i = 0; i<temp.length;i++) {
			String[] info = temp[i].split("/");
			memberList.add(new Member(info[0],info[1],info[2]));
			System.out.println(memberList.get(i));
		}
		utils.printMsg("파일 불러오기 성공");
	}
	
	

}
