package com.egym.entity;
import com.egym.entity.enums.RoleEnum;
import com.egym.utils.BCryptManagerUtil;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "UTILISATEUR")
public class User implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UTIL_ID")
    private Integer idUser;

    @NotNull
    @Column(name = "UTIL_USERNAME", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "UTIL_PASSWORD", nullable = false)
    private String password;

    @NotNull
    @Column(name = "UTIL_PRENOM", nullable = false)
    private String firstname;

    @NotNull
    @Column(name = "UTIL_EMAIL", nullable = false)
    private String email;

    @NotNull
    @Column(name = "UTIL_NOM", nullable = false)
    private String lastname;

    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @Cascade(value = CascadeType.REMOVE)
    @JoinTable(
            indexes = {@Index(name = "INDEX_USER_ROLE", columnList = "ROL_UTIL_ID")},
            name = "ROLES",
            joinColumns = @JoinColumn(name = "ROL_UTIL_ID")
    )
    @Column(name = "ROL_NAME", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<RoleEnum> roles;

    @Column(name = "UTIL_ACCOUNT_NON_EXPIRED")
    private boolean accountNonExpired;

    @Column(name = "UTIL_ACCOUNT_NON_LOCKED")
    private boolean accountNonLocked;

    @Column(name = "UTIL_CREDENTIALS_NON_EXPIRED")
    private boolean credentialsNonExpired;

    @Column(name = "UTIL_ENABLED")
    private boolean enabled;

    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY)
    Profil profil;

    
	public User() {
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.roles = Collections.singletonList(RoleEnum.ROLE_USER);
    }

    public User(String username, String password, String email, String firstname, String lastname, List<RoleEnum> roles) {
        this.username = username;
        this.password = BCryptManagerUtil.passwordencoder().encode(password);
        this.firstname = firstname;
        this.email = email;
        this.lastname = lastname;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = StringUtils.collectionToCommaDelimitedString(getRoles().stream()
                .map(Enum::name).collect(Collectors.toList()));
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    public void setPassword(String password) {
        if (!password.isEmpty()) {
            this.password = BCryptManagerUtil.passwordencoder().encode(password);
        }
    }

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<RoleEnum> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEnum> roles) {
		this.roles = roles;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}



}