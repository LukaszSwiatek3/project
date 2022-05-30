
package com.wevibe.project.geolocation.models;

import java.util.HashMap;
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
    "text_pl",
    "text",
    "wikidata",
    "language_pl",
    "language",
    "short_code"
})
@Generated("jsonschema2pojo")
public class Context {

    @JsonProperty("id")
    private String id;
    @JsonProperty("text_pl")
    private String textPl;
    @JsonProperty("text")
    private String text;
    @JsonProperty("wikidata")
    private String wikidata;
    @JsonProperty("language_pl")
    private String languagePl;
    @JsonProperty("language")
    private String language;
    @JsonProperty("short_code")
    private String shortCode;
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

    @JsonProperty("text_pl")
    public String getTextPl() {
        return textPl;
    }

    @JsonProperty("text_pl")
    public void setTextPl(String textPl) {
        this.textPl = textPl;
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

    @JsonProperty("language_pl")
    public String getLanguagePl() {
        return languagePl;
    }

    @JsonProperty("language_pl")
    public void setLanguagePl(String languagePl) {
        this.languagePl = languagePl;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
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

}
