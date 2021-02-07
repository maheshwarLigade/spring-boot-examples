package com.techwasti.twiliodemo.model;




public class UserInfo {
    private String identity;
    private String token; 

    public String getIdentity(){
        return identity;
    }

    public String getToken(){
        return token;
    }

    public void setIdentity(String identity){
        this.identity=identity;
    }

    public void setToken(String token){
      this.token=token;
    }


}
