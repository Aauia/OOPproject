package Main;

public class UserSession {
    private static UserSession instance;
    private String email;
    private boolean isResearcher; // Поле для роли "исследователь"

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void login(String email, boolean isResearcher) {
        this.email = email;
        this.isResearcher = isResearcher;
    }

    public void logout() {
        this.email = null;
        this.isResearcher = false; // Сброс роли
    }

    public String getLoggedInEmail() {
        return email;
    }

    public boolean isLoggedIn() {
        return email != null;
    }

    public boolean isResearcher() {
        return isResearcher;
    }
}