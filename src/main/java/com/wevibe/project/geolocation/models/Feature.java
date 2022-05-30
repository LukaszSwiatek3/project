
package com.wevibe.project.geolocation.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "type",
    "place_type",
    "relevance",
    "properties",
    "text_pl",
    "place_name_pl",
    "text",
    "place_name",
    "center",
    "geometry",
    "address",
    "context"
})
@Generated("jsonschema2pojo")
public class Feature {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("place_type")
    private List<String> placeType = null;
    @JsonProperty("relevance")
    private Double relevance;
    @JsonProperty("properties")
    private Properties properties;
    @JsonProperty("text_pl")
    private String textPl;
    @JsonProperty("place_name_pl")
    private String placeNamePl;
    @JsonProperty("text")
    private String text;
    @JsonProperty("place_name")
    private String placeName;
    @JsonProperty("center")
    private List<Double> center = null;
    @JsonProperty("geometry")
    private Geometry geometry;
    @JsonProperty("address")
    private String address;
    @JsonProperty("context")
    private List<Context> context = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("place_type")
    public List<String> getPlaceType() {
        return placeType;
    }

    @JsonProperty("place_type")
    public void setPlaceType(List<String> placeType) {
        this.placeType = placeType;
    }

    @JsonProperty("relevance")
    public Double getRelevance() {
        return relevance;
    }

    @JsonProperty("relevance")
    public void setRelevance(Double relevance) {
        this.relevance = relevance;
    }

    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @JsonProperty("text_pl")
    public String getTextPl() {
        return textPl;
    }

    @JsonProperty("text_pl")
    public void setTextPl(String textPl) {
        this.textPl = textPl;
    }

    @JsonProperty("place_name_pl")
    public String getPlaceNamePl() {
        return placeNamePl;
    }

    @JsonProperty("place_name_pl")
    public void setPlaceNamePl(String placeNamePl) {
        this.placeNamePl = placeNamePl;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("place_name")
    public String getPlaceName() {
        return placeName;
    }

    @JsonProperty("place_name")
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @JsonProperty("center")
    public List<Double> getCenter() {
        return center;
    }

    @JsonProperty("center")
    public void setCenter(List<Double> center) {
        this.center = center;
    }

    @JsonProperty("geometry")
    public Geometry getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("context")
    public List<Context> getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(List<Context> context) {
        this.context = context;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
