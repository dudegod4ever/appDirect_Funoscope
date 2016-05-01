package funoscope.web.domain;

public class ZodiacQuote {

    private Integer year;
    private Integer week;
    private String sign;
    private String prediction;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer pYear) {
        year = pYear;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer pWeek) {
        week = pWeek;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String pSign) {
        sign = pSign;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String pPrediction) {
        prediction = pPrediction;
    }

}
