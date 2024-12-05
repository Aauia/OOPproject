package OOp1;

import java.util.Set;
import java.util.HashSet;

/**
* @generated
*/
public class ResearcherDecorator implements Researchable {
    
    /**
    * @generated
    */
    private Researchable researcher;
    
    
    /**
    * @generated
    */
    private Set<Researchable> researchable;
    
    
    /**
    * @generated
    */
    protected Researchable getResearcher() {
        return this.researcher;
    }
    
    /**
    * @generated
    */
    protected Researchable setResearcher(Researchable researcher) {
        this.researcher = researcher;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public double calculateHIndex() {
        //TODO
        return null;
    }
    
    
}
