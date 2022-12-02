package com.example.integrationGit.IntegrateGitlabGithub.Services.impl;

import com.example.integrationGit.IntegrateGitlabGithub.Services.GitLabServices;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GitLabServiceImpl implements GitLabServices {
    @Override
    public void createAnIssue(String URL) throws IOException, InterruptedException {
        HttpClient httpClient;
        httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-type","application/x-www-form-urlencoded")
                .header("Authorization",getBearerTokenHeader())
                .uri(URI.create(URL))
                .POST(HttpRequest.BodyPublishers.ofString("Shubham"))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response of Api Call : " + response + " " + response.body());
    }


    public static String getBearerTokenHeader() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }

}
