
package com.wevibe.project.geolocation.models;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "query",
    "features",
    "attribution"
})

public class Example {

    @JsonProperty("type")
    private String type;
    @JsonProperty("query")
    private List<String> query = null;
    @JsonProperty("features")
    private List<Feature> features = null;
    @JsonProperty("attribution")
    private String attribution;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Example(){

    }

    public Example(String type, List<String> query, List<Feature> features, String attribution, Map<String, Object> additionalProperties) {
        this.type = type;
        this.query = query;
        this.features = features;
        this.attribution = attribution;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("query")
    public List<String> getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(List<String> query) {
        this.query = query;
    }

    @JsonProperty("features")
    public List<Feature> getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @JsonProperty("attribution")
    public String getAttribution() {
        return attribution;
    }

    @JsonProperty("attribution")
    public void setAttribution(String attribution) {
        this.attribution = attribution;
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
        sb.append(Example.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("query");
        sb.append('=');
        sb.append(((this.query == null)?"<null>":this.query));
        sb.append(',');
        sb.append("features");
        sb.append('=');
        sb.append(((this.features == null)?"<null>":this.features));
        sb.append(',');
        sb.append("attribution");
        sb.append('=');
        sb.append(((this.attribution == null)?"<null>":this.attribution));
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
