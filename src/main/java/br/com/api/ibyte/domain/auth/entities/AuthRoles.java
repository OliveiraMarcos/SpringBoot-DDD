package br.com.api.ibyte.domain.auth.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.api.ibyte.domain.base.entities.EntityBase;


/**
 * @author marcos.oliveira
 */
@Entity
@Table(name = "Roles")
public class AuthRoles extends EntityBase<String> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "ConcurrencyStamp", nullable = true)
    private String concurrencyStamp;
    @Column(name = "Name", nullable = true)
    private String name;
    @Column(name = "NormalizedName", nullable = true)
    private String normalizedName;

    public String getConcurrencyStamp() {
        return this.concurrencyStamp;
    }

    public void setConcurrencyStamp(String concurrencyStamp) {
        this.concurrencyStamp = concurrencyStamp;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNormalizedName() {
        return this.normalizedName;
    }

    public void setNormalizedName(String normalizedName) {
        this.normalizedName = normalizedName;
    }


}