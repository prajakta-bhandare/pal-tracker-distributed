package io.pivotal.pal.tracker.allocations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestOperations;

public class ProjectClient {

    @Autowired
    private final RestOperations restOperations;
    private final String registrationServerEndpoint;

    public ProjectClient(RestOperations restOperations, String registrationServerEndpoint) {
        this.restOperations= restOperations;
        this.registrationServerEndpoint = registrationServerEndpoint;
    }

    public ProjectInfo getProject(long projectId) {
        return restOperations.getForObject(registrationServerEndpoint + "/projects/" + projectId, ProjectInfo.class);
    }
}
