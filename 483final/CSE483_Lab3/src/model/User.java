package model;

public class User {
    private String _username;
    private String _password;
    private Account _account;

    public User(String username, String password)
    {
        _password = password;
        _username = username;
    }

    public String GetUsername()
    {
        return _username;
    }

    public String GetUserPassword()
    {
        return _password;
    }

    public void SetUsername(String username)
    {
        _username = username;
    }

    public void SetPassword(String password)
    {
        _password = password;
    }
}
