package OOp1;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class Researcher extends ResearcherDecorator implements Researchable {
    
    /**
    * @generated
    */
    private ResearchPaper researchPaper;
    
    /**
    * @generated
    */
    private ResearchProjects reseachProjects;
    
    
    /**
    * @generated
    */
    private Set<ResearchPaper> researchPaper2;
    
    /**
    * @generated
    */
    private Set<ResearchProjects> researchProjects;
    
    
    /**
    * @generated
    */
    private ResearchPaper getResearchPaper() {
        return this.researchPaper;
    }
    
    /**
    * @generated
    */
    private ResearchPaper setResearchPaper(ResearchPaper researchPaper) {
        this.researchPaper = researchPaper;
    }
    
    /**
    * @generated
    */
    private ResearchProjects getReseachProjects() {
        return this.reseachProjects;
    }
    
    /**
    * @generated
    */
    private ResearchProjects setReseachProjects(ResearchProjects reseachProjects) {
        this.reseachProjects = reseachProjects;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public Collection printPapers() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public double calculateHIndex() {
        //TODO
        return null;
    }
    
    
}
