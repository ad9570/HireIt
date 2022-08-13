package com.hire.it.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@JsonIgnore
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username", length = 50, unique = true)
	private String username;
	
	@JsonIgnore
	@Column(name = "password", length = 100)
	private String password;
	
	@Column(name = "nickname", length = 50)
	private String nickname;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@JsonIgnore
	@Column(name = "activated")
	private boolean activated;
	
	@ManyToMany //user 테이블과 authority 테이블의 다대다 관계를
	@JoinTable( //일대다+다대일 조인 테이블로 정의
			name = "user_authority",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
	private Set<Authority> authorities;

}
