package cn.edu.nwafu.erosion.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "用户ID")
    private Long id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "注册日期")
    private Date registrationDate;
    @ApiModelProperty(value = "上次登录时间")
    private Date lastLogin;
    @ApiModelProperty(value = "用户的名")
    private String firstName;
    @ApiModelProperty(value = "用户的姓")
    private String lastName;
    @ApiModelProperty(value = "性别：男、女、其他")
    private String gender;
    @ApiModelProperty(value = "出生日期")
    private Date dateOfBirth;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "电话号码")
    private String phoneNumber;
    @ApiModelProperty(value = "个人头像路径")
    private String profilePicture;
    @ApiModelProperty(value = "所属单位")
    private String organization;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "个人简介")
    private String biography;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", email=").append(email);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", gender=").append(gender);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", address=").append(address);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", profilePicture=").append(profilePicture);
        sb.append(", organization=").append(organization);
        sb.append(", realName=").append(realName);
        sb.append(", biography=").append(biography);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}