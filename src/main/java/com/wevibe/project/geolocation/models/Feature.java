
package com.wevibe.project.geolocation.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "type",
    "place_type",
    "relevance",
    "properties",
    "text",
    "place_name",
    "matching_place_name",
    "center",
    "geometry",
    "address",
    "context"
})

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
    @JsonProperty("text")
    private String text;
    @JsonProperty("place_name")
    private String placeName;
    @JsonProperty("matching_place_name")
    private String matchingPlaceName;
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

    public Feature() {

    }

    public Feature(String id, String type, List<String> placeType, Double relevance, Properties properties, String text, String placeName, String matchingPlaceName, List<Double> center, Geometry geometry, String address, List<Context> context, Map<String, Object> additionalProperties) {
        this.id = id;
        this.type = type;
        this.placeType = placeType;
        this.relevance = relevance;
        this.properties = properties;
        this.text = text;
        this.placeName = placeName;
        this.matchingPlaceName = matchingPlaceName;
        this.center = center;
        this.geometry = geometry;
        this.address = address;
        this.context = context;
        this.additionalProperties = additionalProperties;
    }

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

    @JsonProperty("matching_place_name")
    public String getMatchingPlaceName() {
        return matchingPlaceName;
    }

    @JsonProperty("matching_place_name")
    public void setMatchingPlaceName(String matchingPlaceName) {
        this.matchingPlaceName = matchingPlaceName;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Feature.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("placeType");
        sb.append('=');
        sb.append(((this.placeType == null)?"<null>":this.placeType));
        sb.append(',');
        sb.append("relevance");
        sb.append('=');
        sb.append(((this.relevance == null)?"<null>":this.relevance));
        sb.append(',');
        sb.append("properties");
        sb.append('=');
        sb.append(((this.properties == null)?"<null>":this.properties));
        sb.append(',');
        sb.append("text");
        sb.append('=');
        sb.append(((this.text == null)?"<null>":this.text));
        sb.append(',');
        sb.append("placeName");
        sb.append('=');
        sb.append(((this.placeName == null)?"<null>":this.placeName));
        sb.append(',');
        sb.append("matchingPlaceName");
        sb.append('=');
        sb.append(((this.matchingPlaceName == null)?"<null>":this.matchingPlaceName));
        sb.append(',');
        sb.append("center");
        sb.append('=');
        sb.append(((this.center == null)?"<null>":this.center));
        sb.append(',');
        sb.append("geometry");
        sb.append('=');
        sb.append(((this.geometry == null)?"<null>":this.geometry));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("context");
        sb.append('=');
        sb.append(((this.context == null)?"<null>":this.context));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
