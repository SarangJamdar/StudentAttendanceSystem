package com.code.bug.model;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class LoginUser implements Serializable {
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return username;
		}
		public void setUserName(String username) {
			this.username = username;
		}	
//		public String getUserId() {
//			return userId;
//		}
//		public void setUserId(String userId) {
//			this.userId = userId;
//		}
		public String getUserPass() {
			return password;
		}
		public void setUserPass(String password) {
			this.password = password;
		}
	    @Column(name = "username")
	    private String username;
//	    @Column(name = "user_id")
//	    private String userId;
	    @Column(name = "password")
	    private String password;
}

