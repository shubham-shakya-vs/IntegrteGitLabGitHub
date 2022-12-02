package com.example.integrationGit.IntegrateGitlabGithub.Contoller;

import com.example.integrationGit.IntegrateGitlabGithub.IssueRequest;
import com.example.integrationGit.IntegrateGitlabGithub.Services.GitLabServices;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/gitlab")
public class GitLabController {

    @Autowired
    GitLabServices gitLabServices;

    //https://gitlab.com/api/v4/projects/41517753/issues?title=Issues%20with%20auth&labels=issue
    //&description=This is an issue created by using api through post

    private  String URL = "https://gitlab.com/api/v4/projects";



    @PostMapping("/projectId/{projectId}")
    public void createAnIssue(@PathVariable String projectId, @RequestParam String title, @RequestParam String description) throws IOException, InterruptedException {

        String temp = "/issues?title=" + title + "&description=" + description;

        //URL = URL + "/" + projectId + URLEncoder.encode(temp, StandardCharsets.UTF_8);
        URL = URL + "/" + projectId + "/issues?title=" + URLEncoder.encode(title, StandardCharsets.UTF_8) + "&description=" + URLEncoder.encode(description,StandardCharsets.UTF_8);

       System.out.println("URL : " + URL);

       gitLabServices.createAnIssue(URL );

    }


}
