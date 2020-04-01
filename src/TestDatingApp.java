import java.util.ArrayList;
import java.util.List;

public class TestDatingApp {
	
	public static void main(String[] args) {
		Users u1 = new Users();
		u1.setName("UserA");
		u1.setGender("Female");
		u1.setAge(25);
		List<String> in1 = new ArrayList<String>();
		in1.add("Cricket");
		in1.add("Tennis");
		u1.setInterests(in1);
		
		Users u2 = new Users();
		u2.setName("UserB");
		u2.setGender("Male");
		u2.setAge(27);
		List<String> in2 = new ArrayList<String>();
		in2.add("Cricket");
		in2.add("Football");
		in2.add("Movies");
		u2.setInterests(in2);
		
		
		
		Users u3 = new Users();
		u3.setName("UserC");
		u3.setGender("Male");
		u3.setAge(26);
		List<String> in3 = new ArrayList<String>();
		in3.add("Movies");
		in3.add("Tennis");
		in3.add("Football");
		in3.add("Cricket");
		u3.setInterests(in3);
		
		
		Users u4 = new Users();
		u4.setName("UserD");
		u4.setGender("Female");
		u4.setAge(24);
		List<String> in4 = new ArrayList<String>();
		in4.add("Tennis");
		in4.add("Football");
		in4.add("Badminton");
		u4.setInterests(in4);
		
		
		Users u5 = new Users();
		u5.setName("UserE");
		u5.setGender("Female");
		u5.setAge(32);
		List<String> in5 = new ArrayList<String>();
		in5.add("Cricket");
		u5.setInterests(in5);
		
		List<Users> otherUList = new ArrayList<Users>();
		otherUList.add(u1);
		otherUList.add(u3);
		otherUList.add(u4);
		otherUList.add(u5);
		MatchUsersUtil mu = new MatchUsersUtil();
		mu.getUsersBasedonMatch(u2, otherUList);

	}
	

}
