package it.bububear.thecassifier.bdd.steps;

import com.thoughtworks.gauge.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUpStep {

    @Step("The Step must receive input <inputString> and check if it the same at level code")
    public void implementation1(String actualInput) {
        String expectedOutput = "alright";
        assertThat(actualInput).isEqualTo(expectedOutput);
    }
}