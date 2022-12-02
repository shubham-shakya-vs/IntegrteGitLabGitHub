package com.example.integrationGit.IntegrateGitlabGithub.Services.impl;

import com.example.integrationGit.IntegrateGitlabGithub.IssueRequest;
import com.example.integrationGit.IntegrateGitlabGithub.Services.GitHubServices;
import com.google.gson.Gson;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GitHubServiceImpl implements GitHubServices {

    private static final Gson gson = new Gson();
    @Override
    public void createAnIssue(String URL, IssueRequest issueRequest) throws IOException, InterruptedException {
        HttpClient httpClient;
        httpClient = HttpClient.newHttpClient();

        String data = gson.toJson(issueRequest);

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-type","application/x-www-form-urlencoded")
                .header("Authorization",getBearerTokenHeader())
                .uri(URI.create(URL))
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response of Api Call : " + response + " " + response.body());

    }

    public static String getBearerTokenHeader() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }
}
