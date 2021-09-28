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
@Table(name = "Roles")
public class AuthUserClaims extends EntityBase<String> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "claimType", nullable = true)
    private String ClaimType;
    @Column(name = "ClaimValue", nullable = true)
    private String claimValue;
    @Column(name = "RoleId", nullable = true)
    private String roleId;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AuthRoles.class)
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private AuthRoles role;
    public String getClaimType() {
        return this.ClaimType;
    }

    public void setClaimType(String ClaimType) {
        this.ClaimType = ClaimType;
    }

    public String getClaimValue() {
        return this.claimValue;
    }

    public void setClaimValue(String claimValue) {
        this.claimValue = claimValue;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}