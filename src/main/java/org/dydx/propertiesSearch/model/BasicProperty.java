package org.dydx.propertiesSearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("cartodb_id")
    private Long cartodbId;
    @JsonProperty("pwd_parcel_id")
    private String pwdParcelId;
    @JsonProperty("parcel_number")
    private String parcelNumber;
    @JsonProperty("registry_number")
    private String registryNumber;

    private String objectString(Object object)
    {
        if (object==null) return "";
        return object.toString();
    }

    public String toString()
    {
        String output = "";
        output = "owner1: " + getOwner1() + System.lineSeparator();
        output += "owner2: " + getOwner2() + System.lineSeparator();
        output += "houseNumber: " + getHouseNumber() + System.lineSeparator();
        output += "streetDirection: " + getStreetDirection() + System.lineSeparator();
        output += "streetName: " + getStreetName() + System.lineSeparator();
        output += "streetDesignation: " + getStreetDirection() + System.lineSeparator();
        output += "zipCode: " + getZipCode() + System.lineSeparator();
        output += "cartoDbId: " + objectString(getCartodbId()) + System.lineSeparator();
        output += "pwdParcelId: " + getPwdParcelId() + System.lineSeparator();
        output += "parcelNumber: " + getParcelNumber() + System.lineSeparator();
        output += "registryNumber: " + getRegistryNumber() + System.lineSeparator();
        output += System.lineSeparator();


        return output;
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
