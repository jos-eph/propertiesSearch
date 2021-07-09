package org.dydx.propertiesSearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Basic;
import java.util.List;

public class BasicPropertyCarto extends CartoResponse {
    @JsonProperty("rows")
    List<BasicProperty> rows;

    public List<BasicProperty> getRows() {
        return rows;
    }

    public void setRows(List<BasicProperty> rowsToSet) {
        this.rows = rowsToSet;
    }
}
