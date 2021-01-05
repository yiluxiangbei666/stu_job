package test.bean;

public class subjectanswer {
    private String subjectname;
    private String youranswer;

    public subjectanswer() {
    }

    public subjectanswer(String subjectname, String youranswer) {
        this.subjectname = subjectname;
        this.youranswer = youranswer;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getYouranswer() {
        return youranswer;
    }

    public void setYouranswer(String youranswer) {
        this.youranswer = youranswer;
    }

    @Override
    public String toString() {
        return "subjectanswer{" +
                "subjectname='" + subjectname + '\'' +
                ", youranswer='" + youranswer + '\'' +
                '}';
    }
}
