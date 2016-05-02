package funoscope.domain;

public class UserAppDirectDto {

    private Integer appDirectUserId;
    private String email;
    private String firstName;
    private String lastName;
    private String openId;
    private String uuid;

    public Integer getAppDirectUserId() {
        return appDirectUserId;
    }

    public void setAppDirectUserId(Integer pAppDirectUserId) {
        appDirectUserId = pAppDirectUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String pEmail) {
        email = pEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String pFirstName) {
        firstName = pFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String pLastName) {
        lastName = pLastName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String pOpenId) {
        openId = pOpenId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String pUuid) {
        uuid = pUuid;
    }

}
