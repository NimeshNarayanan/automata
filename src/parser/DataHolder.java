package parser;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class DataHolder {
    private String name;
    private String type;
    private Tuple tuple;
    @JsonProperty("pass-cases") List<String> pass_cases;
    @JsonProperty("fail-cases") List<String> failCases;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Tuple getTuple() {
        return tuple;
    }

    public void setTuple(Tuple tuple) {
        this.tuple = tuple;
    }

    public List<String> getPass_cases() {
        return pass_cases;
    }

    public void setPass_cases(List<String> pass_cases) {
        this.pass_cases = pass_cases;
    }

    public List<String> getFailCases() {
        return failCases;
    }

    public void setFailCases(List<String> failCases) {
        this.failCases = failCases;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", tuple=" + tuple +
                ", pass_cases=" + pass_cases +
                ", failCases=" + failCases +
                '}';
    }
}
