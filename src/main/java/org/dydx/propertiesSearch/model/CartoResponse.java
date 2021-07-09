package org.dydx.propertiesSearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Basic;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class CartoResponse {

    @JsonProperty("time")
    private BigDecimal time;
    @JsonProperty("fields")
    private Map<String, Map<String,String>> fields;
    @JsonProperty("total_rows")
    private long totalRows;

    public Set<String> returnFieldKeys()
    {
        return fields.keySet();
    }

    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public Map<String, Map<String, String>> getFields() {
        return fields;
    }

    public void setFields(Map<String, Map<String, String>> fields) {
        this.fields = fields;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }
}
