package com.infiniteskills.data.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "FINANCES_USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    private Date birthDate = new Date();

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Embedded
    private Address address;

    public Address getEmbededAddress() {
        return embededAddress;
    }

    public void setEmbededAddress(Address embededAddress) {
        this.embededAddress = embededAddress;
    }


    @AttributeOverrides(
            {
                    @AttributeOverride(name = "addressLine1", column = @Column(name = "USER_ADDRESS_LINE_1_OVERRIDE")),
                    @AttributeOverride(name = "addressLine2", column = @Column(name = "USER_ADDRESS_LINE_2_OVERRIDE")),
                    @AttributeOverride(name = "city", column = @Column(insertable = false, updatable = false)),
                    @AttributeOverride(name = "zipCode", column = @Column(insertable = false, updatable = false)),
                    @AttributeOverride(name = "state", column = @Column(insertable = false, updatable = false))
            }
    )
    @Embedded
    private Address embededAddress;

    @Transient
    private List<Address> addressList = new ArrayList<>();

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate = new Date();

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy = "system";

    @Column(name = "CREATED_DATE", updatable = false)
    private Date createdDate = new Date();

    @Column(name = "CREATED_BY")
    private String createdBy = "system";

    @Formula("lower(datediff(curdate(), birth_date)/365)")
    private int age;

    public int getAge() {
        return age;
    }

    public List<Address> getAddressList() {
        return addressList;
    }


    public void addAddress(Address address) {
        this.addressList.add(address);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", emailAddress='" + emailAddress + '\'' +
                ", addresses=" + addressList +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", age=" + age +
                '}';
    }
}
