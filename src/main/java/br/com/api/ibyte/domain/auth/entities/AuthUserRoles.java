package br.com.api.ibyte.domain.auth.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.api.ibyte.domain.base.entities.EntityBase;


/**
 * @author marcos.oliveira
 */
@Entity
@Table(name = "UserRoles")
public class AuthUserRoles extends EntityBase<String> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "UserId", nullable = true)
    private String userId;
    @Column(name = "RoleId", nullable = true)
    private String roleId;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AuthUsers.class)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private AuthUsers user;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AuthRoles.class)
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private AuthRoles role;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public AuthUsers getUser() {
        return this.user;
    }

    public void setUser(AuthUsers user) {
        this.user = user;
    }

    public AuthRoles getRole() {
        return this.role;
    }

    public void setRole(AuthRoles role) {
        this.role = role;
    }
    
}