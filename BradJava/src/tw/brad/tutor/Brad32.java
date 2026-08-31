package tw.brad.tutor;

import java.util.HashSet;
import java.util.Set;

import tw.brad.api.Member;

public class Brad32 {

	public static void main(String[] args) {
		Set<Member> members = new HashSet<>();
		Member m1 = new Member(1, "brad@brad.tw");
		Member m2 = new Member(2, "brad@brad.tw");
		Member m3 = new Member(1, "brad@brad.tw");
		members.add(m1);
		members.add(m2);
		members.add(m3);
		System.out.println(members.size());
		
		
	}

}
