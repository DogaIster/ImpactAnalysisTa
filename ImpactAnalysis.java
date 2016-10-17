package com.atlassian.jira.plugins.panel.issue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.plugin.issuetabpanel.AbstractIssueTabPanel2;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanel;
import com.atlassian.jira.plugin.issuetabpanel.IssueTabPanel2;
import com.atlassian.jira.issue.tabpanels.GenericMessageAction;
import com.atlassian.jira.issue.Issue;
import com.atlassian.crowd.embedded.api.User;
import com.atlassian.jira.plugin.issuetabpanel.GetActionsRequest;
import java.util.Collections;
import java.util.List;

public abstract class ImpactAnalysis extends AbstractIssueTabPanel2 implements IssueTabPanel2
{
    private static final Logger log = LoggerFactory.getLogger(ImpactAnalysis.class);

    public List getActions(Issue issue, User remoteUser) {
        return Collections.singletonList(new GenericMessageAction("Welcome!"));
    }

    public boolean showPanel(Issue issue, User remoteUser)
    {
        return true;
    }
}
