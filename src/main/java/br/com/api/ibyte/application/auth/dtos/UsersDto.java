package br.com.api.ibyte.application.auth.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.api.ibyte.application.base.dtos.IdentityDto;
/**
 *
 * @author marcos.oliveira
 */
public class UsersDto extends IdentityDto<UsersDto, String>{
    private int accessFailedCount;
    private String concurrencyStamp;
    private String email;
    private Boolean emailConfirmed;
    private Boolean lockoutEnabled;
    private Date lockoutEnd;
    private String normalizedEmail;
    private String normalizedUserName;
    private String passwordHash;
    private String phoneNumber;
    private Boolean phoneNumberConfirmed;
    private String securityStamp;
    private Boolean twoFactorEnabled;
    private String userName;

    @JsonProperty("accessFailedCount")
    public int getAccessFailedCount() {
        return this.accessFailedCount;
    }

    @JsonProperty("accessFailedCount")
    public void setAccessFailedCount(int accessFailedCount) {
        this.accessFailedCount = accessFailedCount;
    }

    @JsonProperty("concurrencyStamp")
    public String getConcurrencyStamp() {
        return this.concurrencyStamp;
    }

    @JsonProperty("concurrencyStamp")
    public void setConcurrencyStamp(String concurrencyStamp) {
        this.concurrencyStamp = concurrencyStamp;
    }

    @JsonProperty("email")
    public String getEmail() {
        return this.email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("emailConfirmed")
    public Boolean getEmailConfirmed() {
        return this.emailConfirmed;
    }

    @JsonProperty("emailConfirmed")
    public void setEmailConfirmed(Boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    @JsonProperty("lockoutEnabled")
    public Boolean getLockoutEnabled() {
        return this.lockoutEnabled;
    }

    @JsonProperty("lockoutEnabled")
    public void setLockoutEnabled(Boolean lockoutEnabled) {
        this.lockoutEnabled = lockoutEnabled;
    }

    @JsonProperty("lockoutEnd")
    public Date getLockoutEnd() {
        return this.lockoutEnd;
    }

    @JsonProperty("lockoutEnd")
    public void setLockoutEnd(Date lockoutEnd) {
        this.lockoutEnd = lockoutEnd;
    }

    @JsonProperty("normalizedEmail")
    public String getNormalizedEmail() {
        return this.normalizedEmail;
    }

    @JsonProperty("normalizedEmail")
    public void setNormalizedEmail(String normalizedEmail) {
        this.normalizedEmail = normalizedEmail;
    }

    @JsonProperty("normalizedUserName")
    public String getNormalizedUserName() {
        return this.normalizedUserName;
    }

    @JsonProperty("normalizedUserName")
    public void setNormalizedUserName(String normalizedUserName) {
        this.normalizedUserName = normalizedUserName;
    }

    @JsonProperty("passwordHash")
    public String getPasswordHash() {
        return this.passwordHash;
    }

    @JsonProperty("passwordHash")
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("phoneNumberConfirmed")
    public Boolean getPhoneNumberConfirmed() {
        return this.phoneNumberConfirmed;
    }

    @JsonProperty("phoneNumberConfirmed")
    public void setPhoneNumberConfirmed(Boolean phoneNumberConfirmed) {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
    }

    @JsonProperty("securityStamp")
    public String getSecurityStamp() {
        return this.securityStamp;
    }

    @JsonProperty("securityStamp")
    public void setSecurityStamp(String securityStamp) {
        this.securityStamp = securityStamp;
    }

    @JsonProperty("twoFactorEnabled")
    public Boolean getTwoFactorEnabled() {
        return this.twoFactorEnabled;
    }

    @JsonProperty("twoFactorEnabled")
    public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    @JsonProperty("userName")
    public String getUserName() {
        return this.userName;
    }

    @JsonProperty("userName")
    public void setUserName(String userName) {
        this.userName = userName;
    }

}