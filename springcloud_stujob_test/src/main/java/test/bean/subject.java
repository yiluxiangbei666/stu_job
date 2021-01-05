package test.bean;

import java.io.Serializable;

public class subject implements Serializable {
    private String subjectname;
    private String A;
    private String B;
    private String C;
    private String D;
    private String trueanswer;

    public subject() {
    }

    public subject(String subjectname, String a, String b, String c, String d, String trueanswer) {
        this.subjectname = subjectname;
        A = a;
        B = b;
        C = c;
        D = d;
        this.trueanswer = trueanswer;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getTrueanswer() {
        return trueanswer;
    }

    public void setTrueanswer(String trueanswer) {
        this.trueanswer = trueanswer;
    }

    @Override
    public String toString() {
        return "subject{" +
                "subjectname='" + subjectname + '\'' +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", trueanswer='" + trueanswer + '\'' +
                '}';
    }
}
