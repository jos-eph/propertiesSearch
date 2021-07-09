package org.dydx.propertiesSearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BasicPropertyList extends CartoResponse {

    @JsonProperty("rows")
    private List<BasicProperty> rows;

    public List<BasicProperty> getRows() {
        return rows;
    }
    
    public void setRows(List<BasicProperty> rows) {
        this.rows = rows;
    }
}
