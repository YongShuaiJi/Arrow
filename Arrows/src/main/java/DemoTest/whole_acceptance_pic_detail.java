package DemoTest;

public class whole_acceptance_pic_detail {
	private String acceptance_pic_detail_id;
	private String whole_acceptance_id;
	private String pic_dict_id;
	private int    min_pic;
	private String create_user_id; 
	private String create_time;
	private String last_update_time;
	private String last_update_user_id;
	private int is_delete;
	
	public void setAll(String acceptance_pic_detail_id,String whole_acceptance_id,String pic_dict_id,int min_pic,String create_user_id,String create_time,String last_update_time,String last_update_user_id,int is_delete) {
		this.acceptance_pic_detail_id = acceptance_pic_detail_id;
		this.whole_acceptance_id = whole_acceptance_id;
		this.pic_dict_id = pic_dict_id;
		this.min_pic = min_pic;
		this.create_user_id = create_user_id;
		this.create_time = create_time;
		this.last_update_time = last_update_time;
		this.last_update_user_id = last_update_user_id;
		this.is_delete = is_delete;
	}
	
	 
	public String getAcceptance_pic_detail_id() {
		return acceptance_pic_detail_id;
	}
	public void setAcceptance_pic_detail_id(String acceptance_pic_detail_id) {
		this.acceptance_pic_detail_id = acceptance_pic_detail_id;
	}
	public String getWhole_acceptance_id() {
		return whole_acceptance_id;
	}
	public void setWhole_acceptance_id(String whole_acceptance_id) {
		this.whole_acceptance_id = whole_acceptance_id;
	}
	public String getPic_dict_id() {
		return pic_dict_id;
	}
	public void setPic_dict_id(String pic_dict_id) {
		this.pic_dict_id = pic_dict_id;
	}
	public int getMin_pic() {
		return min_pic;
	}
	public void setMin_pic(int min_pic) {
		this.min_pic = min_pic;
	}
	public String getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getLast_update_time() {
		return last_update_time;
	}
	public void setLast_update_time(String last_update_time) {
		this.last_update_time = last_update_time;
	}
	public String getLast_update_user_id() {
		return last_update_user_id;
	}
	public void setLast_update_user_id(String last_update_user_id) {
		this.last_update_user_id = last_update_user_id;
	}
	public int getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}
	
	//用于测试，查看的的数据
	public String toString() { 
		return " whole_acceptance_pic_detail:[acceptance_pic_detail_id = "+acceptance_pic_detail_id +"\t"+ " whole_acceptance_id = "+whole_acceptance_id +"\t"+ " pic_dict_id = "+pic_dict_id +"\t"+ " min_pic = "+min_pic+"\t"+" create_user_id = "+create_user_id+"\t"+" create_time = "+create_time+"\t"+" last_update_time = "+ last_update_time+"\t"+" last_update_user_id = "+last_update_user_id+"\t"+" is_delete = "+is_delete + "]";
	}

	
	
	

}
