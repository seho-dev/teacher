package com.entity;

public class Authoritytable {
		/**
		 * È¨ÏÞ±í
		 */
	private int  authority_id ;
	private String au_name;
	private int menu_id;
	public int getAuthority_id() {
			return authority_id;
		}
		public void setAuthority_id(int authority_id) {
			this.authority_id = authority_id;
		}
		public String getAu_name() {
			return au_name;
		}
		public void setAu_name(String au_name) {
			this.au_name = au_name;
		}
		public int getMenu_id() {
			return menu_id;
		}
		public void setMenu_id(int menu_id) {
			this.menu_id = menu_id;
		}
	
}
