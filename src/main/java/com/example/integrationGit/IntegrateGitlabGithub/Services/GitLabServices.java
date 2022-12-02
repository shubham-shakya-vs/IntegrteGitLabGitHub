package com.example.integrationGit.IntegrateGitlabGithub.Services;

import java.io.IOException;

public interface GitLabServices {

    void createAnIssue(String URL) throws IOException, InterruptedException;


}
