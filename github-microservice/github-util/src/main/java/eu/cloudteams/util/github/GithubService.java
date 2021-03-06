package eu.cloudteams.util.github;

import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.egit.github.core.service.UserService;
import org.eclipse.egit.github.core.service.CollaboratorService;
import org.eclipse.egit.github.core.service.LabelService;
import org.eclipse.egit.github.core.service.IssueService;

/**
 *
 * @author Christos Paraskeva <ch.paraskeva at gmail dot com>
 */
public final class GithubService {

    //GitHubClient
    private final GitHubClient githubClient = new GitHubClient();
    private final UserService userService;
    private final RepositoryService repositoryService;
    private final LabelService labelService;
    private final CommitService commitService;
    private final CollaboratorService collaboratorService;
    private final IssueService issueService;

    public GithubService(String accessToken) {
        githubClient.setOAuth2Token(accessToken);
        userService = new UserService(githubClient);
        repositoryService = new RepositoryService(githubClient);
        labelService = new LabelService(githubClient);
        commitService = new CommitService(githubClient);
        collaboratorService = new CollaboratorService(githubClient);
        issueService = new IssueService(githubClient);
    }

    public IssueService getIssueService() {
        return issueService;
    }

    public CollaboratorService getCollaboratorService() {
        return collaboratorService;
    }

    public LabelService getLabelService() {
        return this.labelService;
    }

    public CommitService getCommitService() {
        return this.commitService;
    }

    public UserService getUserService() {
        return this.userService;
    }

    public RepositoryService getGithubRepositoryService() {
        return this.repositoryService;
    }

}
