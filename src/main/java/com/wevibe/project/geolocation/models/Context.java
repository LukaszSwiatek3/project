
package com.wevibe.project.geolocation.models;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "text",
    "wikidata",
    "short_code"
})

public class Context {

    @JsonProperty("id")
    private String id;
    @JsonProperty("text")
    private String text;
    @JsonProperty("wikidata")
    private String wikidata;
    @JsonProperty("short_code")
    private String shortCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Context(){

    }

    public Context(String id, String text, String wikidata, String shortCode, Map<String, Object> additionalProperties) {
        this.id = id;
        this.text = text;
        this.wikidata = wikidata;
        this.shortCode = shortCode;
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

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("wikidata")
    public String getWikidata() {
        return wikidata;
    }

    @JsonProperty("wikidata")
    public void setWikidata(String wikidata) {
        this.wikidata = wikidata;
    }

    @JsonProperty("short_code")
    public String getShortCode() {
        return shortCode;
    }

    @JsonProperty("short_code")
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
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
        sb.append(Context.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("text");
        sb.append('=');
        sb.append(((this.text == null)?"<null>":this.text));
        sb.append(',');
        sb.append("wikidata");
        sb.append('=');
        sb.append(((this.wikidata == null)?"<null>":this.wikidata));
        sb.append(',');
        sb.append("shortCode");
        sb.append('=');
        sb.append(((this.shortCode == null)?"<null>":this.shortCode));
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
