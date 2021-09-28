package br.com.api.ibyte.domain.auth.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.api.ibyte.domain.base.entities.EntityBase;

/**
 * @author marcos.oliveira
 */
@Entity
@Table(name = "Users")
public class AuthUsers extends EntityBase<String> {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "AccessFailedCount", nullable = false)
    private int accessFailedCount;
    @Column(name = "ConcurrencyStamp",nullable = true)
    private String concurrencyStamp;
    @Column(name = "Email",nullable = true)
    private String email;
    @Column(name = "EmailConfirmed",nullable = false)
    private Boolean emailConfirmed;
    @Column(name = "LockoutEnabled",nullable = false)
    private Boolean lockoutEnabled;
    @Column(name = "LockoutEnd",nullable = true)
    private Date lockoutEnd;
    @Column(name = "NormalizedEmail",nullable = true)
    private String normalizedEmail;
    @Column(name = "NormalizedUserName",nullable = true)
    private String normalizedUserName;
    @Column(name = "PasswordHash",nullable = true)
    private String passwordHash;
    @Column(name = "PhoneNumber",nullable = true)
    private String phoneNumber;
    @Column(name = "PhoneNumberConfirmed",nullable = false)
    private Boolean phoneNumberConfirmed;
    @Column(name = "SecurityStamp",nullable = true)
    private String securityStamp;
    @Column(name = "TwoFactorEnabled",nullable = false)
    private Boolean twoFactorEnabled;
    @Column(name = "UserName",nullable = true)
    private String userName;


    public AuthUsers() {
        super();
    }

    public String getConcurrencyStamp() {
        return this.concurrencyStamp;
    }

    public void setConcurrencyStamp(final String concurrencyStamp) {
        this.concurrencyStamp = concurrencyStamp;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Boolean getEmailConfirmed() {
        return this.emailConfirmed;
    }

    public void setEmailConfirmed(final Boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public Boolean getLockoutEnabled() {
        return this.lockoutEnabled;
    }

    public void setLockoutEnabled(final Boolean lockoutEnabled) {
        this.lockoutEnabled = lockoutEnabled;
    }

    public Date getLockoutEnd() {
        return this.lockoutEnd;
    }

    public void setLockoutEnd(final Date lockoutEnd) {
        this.lockoutEnd = lockoutEnd;
    }

    public String getNormalizedEmail() {
        return this.normalizedEmail;
    }

    public void setNormalizedEmail(final String normalizedEmail) {
        this.normalizedEmail = normalizedEmail;
    }

    public String getNormalizedUserName() {
        return this.normalizedUserName;
    }

    public void setNormalizedUserName(final String normalizedUserName) {
        this.normalizedUserName = normalizedUserName;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public void setPasswordHash(final String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getPhoneNumberConfirmed() {
        return this.phoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed(final Boolean phoneNumberConfirmed) {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
    }

    public String getSecurityStamp() {
        return this.securityStamp;
    }

    public void setSecurityStamp(final String securityStamp) {
        this.securityStamp = securityStamp;
    }

    public Boolean getTwoFactorEnabled() {
        return this.twoFactorEnabled;
    }

    public void setTwoFactorEnabled(final Boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }
    
    public int getAccessFailedCount() {
        return this.accessFailedCount;
    }

    public void setAccessFailedCount(final int accessFailedCount) {
        this.accessFailedCount = accessFailedCount;
    }

    
}