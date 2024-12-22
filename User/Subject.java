
package User;

import Education.ResearchPaper;

public interface Subject {

    void subscribe(Person person);
    void unsubscribe(Person person);
    void publish(ResearchPaper paper);
}