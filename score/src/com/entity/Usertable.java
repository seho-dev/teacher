package com.entity;

public class Usertable {
		private Object user_id;
		private String user_pd;
		private Object role_id;
		private String user_img;
		public String getUser_img() {
			return user_img;
		}
		public void setUser_img(String user_img) {
			this.user_img = user_img;
		}
		public Object getUser_id() {
			return user_id;
		}
		public void setUser_id(Object object) {
			this.user_id = object;
		}
		public String getUser_pd() {
			return user_pd;
		}
		public void setUser_pd(Object object) {
			this.user_pd = (String) object;
		}
		public Object getRole_id() {
			return role_id;
		}
		public void setRole_id(long role_id) {
			this.role_id = role_id;
		}
}
