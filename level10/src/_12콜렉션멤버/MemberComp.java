package _12콜렉션멤버;

import java.util.Comparator;

public class MemberComp implements Comparator<Member>  {
	
	enum SortBy{NAME,ID}
	enum SortDir{ASC,DESC}
	
	private SortBy sortby;
	private SortDir sortdir;

	MemberComp(SortBy sortby, SortDir sortdir) {
		super();
		this.sortby = sortby;
		this.sortdir = sortdir;
	}


	@Override
	public int compare(Member m1, Member m2) {
		int result = 0;
		switch(sortby){
		case NAME : result = m1.getName().compareTo(m2.getName()); break;
		case ID : result = m1.getId().compareTo(m2.getId()); break;
		}
		return result*(sortdir == sortdir.ASC? 1:-1);
	}

}
