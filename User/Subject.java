package User;

import java.util.List;

public interface Subject {
    void notifySubs(String news, List<UserType> targetGroups);
}
