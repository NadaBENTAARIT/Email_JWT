package com.loterie.loterie.payload.response;



import com.loterie.loterie.entity.Role;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private String tel;
    private String email;

    private String password;

    private Role role;

    public JwtResponse(String token, String username,String email, String tel, String password,Role role) {
        this.token = token;
        this.username = username;
        this.tel = tel;
        this.email = email;
        this.password = password;
        this.role=role ;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
