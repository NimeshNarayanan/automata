package helper;

import automata.DFA;
import parser.DataHolder;

import java.util.List;

public class TestRunner {


    private boolean passCases;
    private final boolean failCases;
    private List<DataHolder> dataHolder;

    public TestRunner(List<DataHolder> dataHolder) {

        this.dataHolder = dataHolder;
        this.passCases = true;
        this.failCases = true;

    }

    public boolean runTest() throws Exception {
        for(DataHolder data : dataHolder){
            DFAGenerator dfaGenerator = new DFAGenerator(data.getTuple());
            DFA dfa = dfaGenerator.generateDFA();
            this.testPassCases(data.getPass_cases(), dfa);
            this.testFailCases(data.getFailCases(),dfa);
        }
        if(passCases && failCases)
            return true;
        return false;
    }

    private void testFailCases(List<String> failCases, DFA dfa) {
        failCases.stream().forEach(string->{
            if((dfa.isLanguagePasses(string))) this.passCases = false;
        });
    }

    private void testPassCases(List<String> passCases, DFA dfa) {
        passCases.stream().forEach(string->{
            if(!(dfa.isLanguagePasses(string))) this.passCases = false;
        });
    }

}

