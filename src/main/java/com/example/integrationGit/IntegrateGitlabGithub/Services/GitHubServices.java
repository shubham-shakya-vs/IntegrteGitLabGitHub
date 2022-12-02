package com.example.integrationGit.IntegrateGitlabGithub.Services;

import com.example.integrationGit.IntegrateGitlabGithub.IssueRequest;

import java.io.IOException;

public interface GitHubServices {

    void createAnIssue(String URL, IssueRequest issueRequest) throws IOException, InterruptedException;


}
