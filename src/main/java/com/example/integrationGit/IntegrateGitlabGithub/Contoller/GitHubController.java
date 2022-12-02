package com.example.integrationGit.IntegrateGitlabGithub.Contoller;

import com.example.integrationGit.IntegrateGitlabGithub.IssueRequest;
import com.example.integrationGit.IntegrateGitlabGithub.Services.GitHubServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/github")
public class GitHubController {

    @Autowired
    GitHubServices gitHubServices;

    @PostMapping("/owner/{owner}/repo/{repo}")
    public void createIssue(@PathVariable String owner, @PathVariable String repo, @RequestBody IssueRequest issueRequest) throws IOException, InterruptedException {
        //https://api.github.com/repos/OWNER/REPO/issues
        String URL = "https://api.github.com/repos/" + owner + "/" + repo+"/issues";

        gitHubServices.createAnIssue(URL,issueRequest);


    }

}
