import java.util.ArrayList;

import java.util.List;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MatchUsersUtil {

	
public List<Users> getUsersBasedonMatch(Users u,List<Users> otherUList) {
	
	List<Users> uListBySex = new ArrayList<Users>();
	List<Users> uListByAge = new ArrayList<Users>();
	List<Users> uListByInterests = new ArrayList<Users>();
	List<Users> uListAfterMatch = new ArrayList<Users>();
	
	//Filter users by opposite sex
	uListBySex = getUsersBasedOnOppositeSex(u, otherUList);
				 
	//set match score based on interest
	uListByInterests = setUsersMatchScore(u, uListBySex);
	
	//sort users by age gap
	uListByAge= getUsersBasedOnAgeGap(u, uListBySex);
	
	//sort users by match score
	uListAfterMatch= getUsersBasedOnMatchScore(uListByAge);
	
	Users u1 =uListAfterMatch.get(0);
	Users u2 =uListAfterMatch.get(1);
	
	System.out.println("The first best matched user is "+u1.getName());
	System.out.println("The second best  matched user is "+u2.getName());
	
	return uListAfterMatch;

}


public List<Users> getUsersBasedOnOppositeSex(Users u,List<Users> otherUList){

	List<Users> filteredUListByOppSex = new ArrayList<Users>();
    Predicate<Users> byOppSex ;
    if(u.getGender().equals("Male"))
    	byOppSex=user -> user.getGender().equals("Female");
	else
		byOppSex=user -> user.getGender().equals("Male");			

		filteredUListByOppSex = otherUList.stream().filter(byOppSex)
			                .collect(Collectors.toList());

	return filteredUListByOppSex;
}


public List<Users> getUsersBasedOnAgeGap(Users u,List<Users> otherUList){

	//Lambda expression for sorting by age 
	otherUList.sort((Users u1, Users u2)->
	(Math.abs(u.getAge() - u1.getAge()))-
    		(Math.abs(u.getAge() - u2.getAge()))); 
	
	return otherUList;
}


public List<Users> getUsersBasedOnMatchScore(List<Users> otherUList){

	//Lambda expression for sorting by matching score 
	otherUList.sort((Users u1, Users u2)->u2.getMatchScore()-u1.getMatchScore()); 

	return otherUList;
}


public List<Users> setUsersMatchScore(Users u,List<Users> otherUList){

	List<String> primaryUserInterest = u.getInterests();
	//List<Users> sortedUsersByMatchList = new ArrayList<Users>();
	
	//generate score for interest matching after this
		for(Users userForRating:otherUList) {
			int matchScore=0;
			
			//Users temp1 ;
			List<String> userForRatingInterest=userForRating.getInterests();

			if(primaryUserInterest.size()>=userForRatingInterest.size()) {
				List<String> temp1= new ArrayList<String>(primaryUserInterest);
				temp1.retainAll(userForRatingInterest);
				matchScore = temp1.size();
			}
			else {
				List<String> temp2= new ArrayList<String>(userForRatingInterest);
				temp2.retainAll(primaryUserInterest);
				matchScore = temp2.size();
				
			}
			userForRating.setMatchScore(matchScore);			
		}	
		return otherUList;

}



}
