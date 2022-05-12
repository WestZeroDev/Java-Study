package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//2022 KAKAO BLIND RECRUITMENT > 신고 결과 받기
public class Kakao_2022_01 {
	public int[] solution(String[] id_list, String[] report, int k) {
		List<User> user_list = new ArrayList<>();
        for(String id : id_list) {
            User user = new User(id);
            user_list.add(user);
        }
        
        Set<String> str_set = new HashSet<>(Arrays.asList(report));
        List<String> str_list = new ArrayList<>(str_set);
       
        List<Report> report_list = new ArrayList<>();
        for(String r : str_list) {
        	String[] arr = r.split(" ");
        	Report rp = new Report(arr[0], arr[1]);
        	report_list.add(rp);
        }
        
        for(Report r : report_list) {
        	for(User user : user_list) {
        		if(r.report_id.equals(user.id)) {
        			user.reportCount++;
        		}
        	}
        }
        
        for(User u : user_list) {
        	if(u.reportCount >= k) {
        		for(Report r : report_list) {
        			if(r.report_id.equals(u.id)) {
        				for(User e : user_list) {
        	        		if(e.id.equals(r.user_id)) {
        	        			e.mailCount++;
        	        		}
        	        	}
        			}
        		}
        	}
        }
        
        int[] answer = user_list.stream().mapToInt(e -> e.mailCount).toArray();
        return answer;
    }
	
}

class User {
    String id;
    int reportCount;
    int mailCount;
    
    public User() {}
    public User(String id) {
        this.id = id;
    }
}

class Report {
	String user_id;
	String report_id;
	
	public Report() {}
	public Report(String user_id, String report_id) {
		this.user_id = user_id;
		this.report_id = report_id;
	}
}