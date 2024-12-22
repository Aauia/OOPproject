package User;

import Education.ResearchPaper;

class ResearchPaperDateComparator implements java.util.Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return paper1.getpublishDate().compareTo(paper2.getpublishDate());
    }
}