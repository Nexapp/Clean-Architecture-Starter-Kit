package ca.nexapp.starterkit.rest.parameters;

import java.util.Optional;

import javax.ws.rs.QueryParam;

import ca.nexapp.starterkit.rest.presenters.ingredients.UnitDisplay;
import io.swagger.annotations.ApiParam;

public class UnitDisplayParameter {

    @QueryParam("unit")
    @ApiParam(allowableValues = "metric, imperial", defaultValue = "metric", required = false, value = "The unit to display results")
    public Optional<String> raw;

    public UnitDisplayParameter() {
    }

    protected UnitDisplayParameter(Optional<String> raw) {
        this.raw = Optional.ofNullable(raw).orElse(Optional.empty());
    }

    public UnitDisplay value() {
        return raw.map(this::parse).orElse(UnitDisplay.METRIC);
    }

    private UnitDisplay parse(String value) {
        if (value.isEmpty()) {
            return UnitDisplay.METRIC;
        }

        if (value.equalsIgnoreCase("imperial")) {
            return UnitDisplay.IMPERIAL;
        }
        return UnitDisplay.METRIC;
    }

}
