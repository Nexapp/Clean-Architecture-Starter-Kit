package ca.nexapp.starterkit.rest.parameters;

import static com.google.common.truth.Truth.assertThat;

import java.util.Optional;

import org.junit.Test;

import ca.nexapp.starterkit.rest.presenters.ingredients.UnitDisplay;

public class UnitDisplayParameterTest {

    @Test
    public void canParseImperialUnit() {
        UnitDisplayParameter parameter = new UnitDisplayParameter(Optional.of("iMperIAl"));

        assertThat(parameter.value()).isEqualTo(UnitDisplay.IMPERIAL);
    }

    @Test
    public void canParseMetricUnit() {
        UnitDisplayParameter parameter = new UnitDisplayParameter(Optional.of("meTriC"));

        assertThat(parameter.value()).isEqualTo(UnitDisplay.METRIC);
    }

    @Test
    public void givenNullValue_ShouldFallbackToMetric() {
        UnitDisplayParameter parameter = new UnitDisplayParameter(null);

        assertThat(parameter.value()).isEqualTo(UnitDisplay.METRIC);
    }

    @Test
    public void givenNoValue_ShouldFallbackToMetric() {
        UnitDisplayParameter parameter = new UnitDisplayParameter(Optional.empty());

        assertThat(parameter.value()).isEqualTo(UnitDisplay.METRIC);
    }

    @Test
    public void givenAnEmptyValue_ShouldFallbackToMetric() {
        UnitDisplayParameter parameter = new UnitDisplayParameter(Optional.of(""));

        assertThat(parameter.value()).isEqualTo(UnitDisplay.METRIC);
    }

    @Test
    public void givenAnUnknownValue_ShouldFallbackToMetric() {
        UnitDisplayParameter parameter = new UnitDisplayParameter(Optional.of("abcdef"));

        assertThat(parameter.value()).isEqualTo(UnitDisplay.METRIC);
    }
}
