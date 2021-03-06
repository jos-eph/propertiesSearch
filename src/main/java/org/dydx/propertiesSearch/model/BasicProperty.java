package org.dydx.propertiesSearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BasicProperty
{
    @JsonProperty("owner_1")
    private String owner1;
    @JsonProperty("owner_2")
    private String owner2;

    @JsonProperty("house_number")
    private String houseNumber;
    @JsonProperty("street_direction")
    private String streetDirection;
    @JsonProperty("street_name")
    private String streetName;
    @JsonProperty("street_designation")
    private String streetDesignation;

    @JsonProperty("zip_code")
    private String zipCode;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("market_value")
    private BigDecimal marketValue;

    @JsonProperty("cartodb_id")
    private Long cartodbId;
    @JsonProperty("pwd_parcel_id")
    private String pwdParcelId;
    @JsonProperty("parcel_number")
    private String parcelNumber;
    @JsonProperty("registry_number")
    private String registryNumber;

    public BasicProperty()
    { }

    public BasicProperty(String owner1, String owner2, String houseNumber, String streetDirection,
                         String streetName, String streetDesignation, String zipCode, BigDecimal marketValue)
    {
        this.setOwner1(owner1);
        this.setOwner2(owner2);
        this.setHouseNumber(houseNumber);
        this.setStreetDirection(streetDirection);
        this.setStreetName(streetName);
        this.setStreetDesignation(streetDesignation);
        this.setZipCode(zipCode);
        this.setMarketValue(marketValue);
    }


    private String objectString(Object object)
    {
        if (object==null || object.equals("null")) {return "";}
        return object.toString();
    }

    public String longToString()
    {
        String output = "";
        output = "owner1: " + getOwner1() + System.lineSeparator();
        output += "owner2: " + getOwner2() + System.lineSeparator();
        output += "houseNumber: " + getHouseNumber() + System.lineSeparator();
        output += "streetDirection: " + getStreetDirection() + System.lineSeparator();
        output += "streetName: " + getStreetName() + System.lineSeparator();
        output += "streetDesignation: " + getStreetDesignation() + System.lineSeparator();
        output += "unit: " + getUnit() + System.lineSeparator();
        output += "zipCode: " + getZipCode() + System.lineSeparator();
        output += "marketValue: " + getMarketValue().toString() + System.lineSeparator();
        output += "cartoDbId: " + objectString(getCartodbId()) + System.lineSeparator();
        output += "pwdParcelId: " + getPwdParcelId() + System.lineSeparator();
        output += "parcelNumber: " + getParcelNumber() + System.lineSeparator();
        output += "registryNumber: " + getRegistryNumber() + System.lineSeparator();
        output += System.lineSeparator();


        return output;
    }

    public String toString() {
        String output = "";
        String ownerBlock = (objectString(getOwner2()).equals("")) ?
                objectString(getOwner1()) :
                objectString(getOwner1()) + ", " + objectString(getOwner2());
        String streetDirectionBlock = (objectString(getStreetDirection()).equals(""))
                ? " " : objectString(getStreetDirection());
        String addressBlock = getHouseNumber() + " " + streetDirectionBlock + "   " + getStreetName() + " " + getStreetDesignation() + objectString(getUnit());
        String zipcodeBlock = "Phila " + getZipCode();
   //     String valueBlock = "$" + getMarketValue().toString();
        String valueBlock = "";
        output = String.format("%-50s%-30s%13s%14s",ownerBlock,addressBlock,zipcodeBlock,valueBlock);
        return output;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(BigDecimal marketValue) {
        this.marketValue = marketValue;
    }

    public String getOwner1() {
        return owner1;
    }

    public void setOwner1(String owner1) {
        this.owner1 = owner1;
    }

    public String getOwner2() {
        return owner2;
    }

    public void setOwner2(String owner2) {
        this.owner2 = owner2;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetDirection() {
        return streetDirection;
    }

    public void setStreetDirection(String streetDirection) {
        this.streetDirection = streetDirection;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetDesignation() {
        return streetDesignation;
    }

    public void setStreetDesignation(String streetDesignation) {
        this.streetDesignation = streetDesignation;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getCartodbId() {
        return cartodbId;
    }

    public void setCartodbId(Long cartodbId) {
        this.cartodbId = cartodbId;
    }

    public String getPwdParcelId() {
        return pwdParcelId;
    }

    public void setPwdParcelId(String pwdParcelId) {
        this.pwdParcelId = pwdParcelId;
    }

    public String getParcelNumber() {
        return parcelNumber;
    }

    public void setParcelNumber(String parcelNumber) {
        this.parcelNumber = parcelNumber;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }
}
