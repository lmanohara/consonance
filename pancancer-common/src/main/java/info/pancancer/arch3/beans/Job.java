package info.pancancer.arch3.beans;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by boconnor on 2015-04-22.
 */
public class Job {
    private String state;
    private String uuid = UUID.randomUUID().toString().toLowerCase();
    private String workflow;
    private String workflowVersion;
    private String jobHash;
    private Map<String, String> ini = new HashMap<String, String>();

    public Job(String workflow, String workflowVersion, String jobHash, Map<String, String>  ini) {
        this.workflow = workflow;
        this.workflowVersion = workflowVersion;
        this.jobHash = jobHash;
        this.ini = ini;
    }

    public Job() {
        super();
    }

    public String toJSON () {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public Job fromJSON(String json) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return mapper.readValue(json, Job.class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @JsonProperty("job_uuid")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @JsonProperty("arguments")
    public Map<String, String> getIni() {
        return ini;
    }

    @JsonIgnore
    public String getIniStr() {
        StringBuffer sb = new StringBuffer();
        for (String key : this.ini.keySet()) {
            sb.append(key+"="+this.ini.get(key)).append("\n");
        }
        return(sb.toString());
    }

    public void setIni(Map<String, String> ini) {
        this.ini = ini;
    }

    @JsonProperty("job_hash")
    public String getJobHash() {
        return jobHash;
    }

    public void setJobHash(String jobHash) {
        this.jobHash = jobHash;
    }

    @JsonProperty("workflow_version")
    public String getWorkflowVersion() {
        return workflowVersion;
    }

    public void setWorkflowVersion(String workflowVersion) {
        this.workflowVersion = workflowVersion;
    }

    @JsonProperty("workflow_name")
    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    //Not sure what this was for, ignore it for now.
    @JsonIgnore
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
